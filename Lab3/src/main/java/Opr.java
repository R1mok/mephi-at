import java.util.ArrayList;
import java.util.List;

public class Opr {

    NodeType typeNode;
    operType operType;
    String funcCall;
    Opr(NodeType nt){
        this.typeNode = nt;
    }
    Opr() {}
    Opr (String funcName){
        this.funcCall = funcName;
    }
    Opr(NodeType nt, operType ot){
        this.typeNode = nt;
        this.operType = ot;
    }
    protected List<Opr> ops = new ArrayList<>();
    public void addInListOpr(Opr oper){
        ops.add(oper);
    }
}
