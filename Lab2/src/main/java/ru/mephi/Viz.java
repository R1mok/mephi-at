package ru.mephi;

import com.mxgraph.layout.*;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.util.mxCellRenderer;
import javafx.util.Pair;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.jgraph.graph.Edge;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.util.*;


class MyEdge extends DefaultWeightedEdge {
    public String edgeName;
    public boolean startNode = false;

    @Override
    public String toString() {
        return edgeName;
    }
}

public class Viz {
    public static DirectedWeightedPseudograph<String, MyEdge> createDFAGraph(SoftReference<DFA> dfa) throws IOException {
        File imgFile = new File("DFAgraph.png");
        imgFile.createNewFile();
        DirectedWeightedPseudograph<String, MyEdge> g =
                new DirectedWeightedPseudograph<String, MyEdge>(MyEdge.class);
        for (SoftReference<DFANode> dfanode : dfa.get().getSets()) {
            String curVertex = "";
            Set<Integer> hashSet = new TreeSet<>();
            if (dfanode.get().getValue().size() == 0) {
                curVertex += "T";
                g.addVertex(curVertex);
                continue;
            }
            for (SoftReference<NFANode> nfanode : dfanode.get().getValue()) {
                hashSet.add(nfanode.get().getId());
            }
            for (Integer elem : hashSet) {
                curVertex = curVertex.concat(String.valueOf(elem)) + ".";
            }
            g.addVertex(curVertex);
        }
        for (SoftReference<DFANode> dfanode : dfa.get().getSets()) {
            Set<Integer> hashSet = new TreeSet<>();
            for (SoftReference<NFANode> nfanode : dfanode.get().getValue()) {
                hashSet.add(nfanode.get().getId());
            }
            String sourceVertex = "";
            for (Integer elem : hashSet) {
                sourceVertex = sourceVertex.concat(String.valueOf(elem)) + ".";
            }
            if (sourceVertex.equals("")) {
                sourceVertex = "T";
            }
            hashSet.clear();
            for (Pair<SoftReference<DFANode>, String> nfanode : dfanode.get().listNodes) {
                for (SoftReference<NFANode> destnfa : nfanode.getKey().get().getValue()) {
                    hashSet.add(destnfa.get().getId());
                }
                String destVertex = "";
                for (Integer elem : hashSet) {
                    destVertex = destVertex.concat(String.valueOf(elem)) + ".";
                }
                hashSet.clear();
                if (destVertex.equals("")) {
                    destVertex = "T";
                }
                String curEdge = nfanode.getValue();
                if (Objects.equals(nfanode.getValue(), "CIRCUMFLEXUS"))
                    curEdge = "^";

                MyEdge edge = new MyEdge();
                edge.edgeName = curEdge;
                g.addEdge(sourceVertex, destVertex, edge);
            }
        }
        return g;
    }

    public static void VizDFA(SoftReference<DFA> dfa) throws IOException {
        JGraphXAdapter<String, MyEdge> graphAdapter =
                new JGraphXAdapter<String, MyEdge>(createDFAGraph(dfa));
        mxIGraphLayout layout = new mxHierarchicalLayout(graphAdapter); // mxHierarchicalLayout
        layout.execute(graphAdapter.getDefaultParent());
        BufferedImage image =
                mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("DFAgraph.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static DirectedWeightedPseudograph<String, MyEdge> createNFAGraph(SoftReference<NFA> nfa) throws IOException {
        File imgFile = new File("NFAgraph.png");
        imgFile.createNewFile();
        DirectedWeightedPseudograph<String, MyEdge> g =
                new DirectedWeightedPseudograph<String, MyEdge>(MyEdge.class);
        for (NFANode nfaNode : nfa.get().nodes) {
            String curVertex = String.valueOf(nfaNode.getId());
            g.addVertex(curVertex);
        }
        for (NFANode nfaNode : nfa.get().nodes) {
            String sourceVertex = String.valueOf(nfaNode.getId());
            for (Pair<SoftReference<NFANode>, Node> elem : nfaNode.listNodes) {
                String curEdge;
                if (elem.getValue().getValue() instanceof Metasymbols) {
                    curEdge = ((Metasymbols) elem.getValue().getValue()).value;
                } else {
                    curEdge = ((Node) elem.getValue().getValue()).getValue().toString();
                }
                if (Objects.equals(curEdge, "CIRCUMFLEXUS"))
                    curEdge = "^";
                MyEdge tmpEdge = new MyEdge();
                tmpEdge.edgeName = curEdge;
                String destVertex = String.valueOf(elem.getKey().get().getId());
                g.addEdge(sourceVertex, destVertex, tmpEdge);
            }
        }
        return g;
    }

    public static void VizNFA(SoftReference<NFA> nfa) throws IOException {
        JGraphXAdapter<String, MyEdge> graphAdapter =
                new JGraphXAdapter<String, MyEdge>(createNFAGraph(nfa));
        mxIGraphLayout layout = new mxHierarchicalLayout(graphAdapter); // mxHierarchicalLayout
        layout.execute(graphAdapter.getDefaultParent());
        BufferedImage image =
                mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("NFAgraph.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static DirectedWeightedPseudograph<String, MyEdge> createMinDFAGraph(SoftReference<minDFA> mindfa) throws IOException {
        File imgFile = new File("minDFAgraph.png");
        imgFile.createNewFile();
        DirectedWeightedPseudograph<String, MyEdge> g =
                new DirectedWeightedPseudograph<>(MyEdge.class);
        for (int i = 0; i < mindfa.get().nodesArray.length; ++i) {
            g.addVertex(String.valueOf(i + 1));
        }
        for (int i = 0; i < mindfa.get().nodesArray.length; ++i) {
            String sourceVertex = String.valueOf(mindfa.get().nodesArray[i].get().getValue().stream().findAny().get().get().getId());
            for (Pair<SoftReference<DFANode>, String> listNode : mindfa.get().nodesArray[i].get().listNodes) {
                String destVertex = String.valueOf(listNode.getKey().get().getValue().stream().findAny().get().get().getId());
                String curEdge = listNode.getValue();
                MyEdge edge = new MyEdge();
                edge.edgeName = curEdge;
                g.addEdge(sourceVertex, destVertex, edge);
            }
        }
        return g;
    }

    public static void VizMinDFA(SoftReference<minDFA> mindfa) throws IOException {
        JGraphXAdapter<String, MyEdge> graphAdapter =
                new JGraphXAdapter<>(createMinDFAGraph(mindfa));
        mxIGraphLayout layout = new mxHierarchicalLayout(graphAdapter); // mxHierarchicalLayout
        layout.execute(graphAdapter.getDefaultParent());
        BufferedImage image =
                mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("minDFAgraph.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static DirectedWeightedPseudograph<String, MyEdge> createMulDFAGraph(SoftReference<mulDFA> muldfa) throws IOException {
        File imgFile = new File("mulDFAgraph.png");
        imgFile.createNewFile();
        DirectedWeightedPseudograph<String, MyEdge> g =
                new DirectedWeightedPseudograph<>(MyEdge.class);
        for (int i = 0; i < muldfa.get().nodesArray.length; ++i) {
            g.addVertex(String.valueOf(i + 1));
        }
        for (int i = 0; i < muldfa.get().nodesArray.length; ++i) {
            String sourceVertex = String.valueOf(i + 1);
            for (Pair<MulDFANode, String> listnode : muldfa.get().nodesArray[i].listnodes) {
                String desVertex = String.valueOf(Arrays.asList(muldfa.get().nodesArray).indexOf(listnode.getKey()) + 1);
                String curEdge = listnode.getValue();
                MyEdge edge = new MyEdge();
                edge.edgeName = curEdge;
                g.addEdge(sourceVertex, desVertex, edge);
            }
        }
        return g;
    }

    public static void VizMulDFA(SoftReference<mulDFA> muldfa) throws IOException {
        JGraphXAdapter<String, MyEdge> graphAdapter =
                new JGraphXAdapter<String, MyEdge>(createMulDFAGraph(muldfa));
        mxIGraphLayout layout = new mxHierarchicalLayout(graphAdapter); // mxHierarchicalLayout
        layout.execute(graphAdapter.getDefaultParent());
        BufferedImage image =
                mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("mulDFAgraph.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    public static void main(String[] args) throws IOException {
        String str = "b|c|d";
        AbstractSyntaxTree tree = new AbstractSyntaxTree(str);
        Node rootNode = tree.buildTree();
        tree.doOrder(rootNode);
        NFA nfa = new NFA(rootNode);
        SoftReference<NFA> nfaSR = new SoftReference<>(nfa);
        DFA dfa = new DFA();
        dfa = dfa.makeDFA(nfaSR);
        SoftReference<DFA> dfaSR = new SoftReference<>(dfa);
        System.out.println("NFA nodes");
        System.out.println("StartNode: " + nfa.getStart().get().getId());
        System.out.println("EndNode: " + nfa.getEnd().get().getId());
        VizNFA(nfaSR);
        System.out.println("DFA nodes");
        System.out.print("Start node: ");
        TreeSet<Integer> hashSet = new TreeSet<>();
        for (SoftReference<NFANode> nfastart : dfa.getStart().get().getValue()) {
            hashSet.add(nfastart.get().getId());
        }
        for (Integer elem : hashSet) {
            System.out.print(elem);
        }
        System.out.println("");
        hashSet.clear();
        System.out.print("End nodes: ");
        for (SoftReference<DFANode> endNodes : dfa.getEnd()) {
            for (SoftReference<NFANode> endNFANodes : endNodes.get().getValue()) {
                hashSet.add(endNFANodes.get().getId());
            }
            for (Integer elem : hashSet) {
                System.out.print(elem + ".");
            }
            hashSet.clear();
            System.out.print(" ");
        }
        VizDFA(dfaSR);
        minDFA mindfa = new minDFA();
        mindfa.makeMinDFA(dfa);
        SoftReference<minDFA> mindfaSR = new SoftReference<>(mindfa);
        VizMinDFA(mindfaSR);
        System.out.println("\nminDFA nodes");
        System.out.print("Start node: " + mindfa.startNode.get().getValue().stream().findFirst().get().get().getId() + "\n");
        System.out.print("End nodes: ");
        for (SoftReference<DFANode> endNode : mindfa.endNodes) {
            System.out.print(endNode.get().getValue().stream().findFirst().get().get().getId() + " ");
        }
        System.out.println("");
        RegexLib rl = new RegexLib();
        mulDFA muldfa = rl.complement("b|c|d");
        Viz.VizMulDFA(new SoftReference<>(muldfa));
        printMulDFA(muldfa);
    }

    public static void printMulDFA(mulDFA muldfa) {
        System.out.println("MulDFA");
        System.out.print("Start node: ");
        int i = 1;
        for (MulDFANode node : muldfa.nodesArray){
            if (node.equals(muldfa.startNode)){
                System.out.print(i);
            }
            ++i;
        }
        i = 1;
        System.out.print("\nEnd nodes: ");
        if (muldfa.endNodes != null) {
            for (MulDFANode node : muldfa.nodesArray) {
                for (MulDFANode endNode : muldfa.endNodes) {
                    if (endNode.equals(node)) {
                        System.out.print(i + " ");
                    }
                }
                ++i;
            }
        } else {
            System.out.println("Haven't nodes");
        }
        System.out.println("");
    }
}