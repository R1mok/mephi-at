import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Robot { // класс робота
    private List<String> fileMaze = new ArrayList<>(); // список сторк файла
    private int x; // координата X
    private int y; // координата Y
    private String[][] matrix; // space = " ", wall = "#", robot = "R", exit = "X"
    Pair<Integer, Integer> coordinates; // текущие координаты робота
    Pair<Integer, Integer> exitCoord; // координаты выхода (считываются с карты лабиринта)
    Stack<Pair<Integer, Integer>> portals = new Stack<>(); // стэк порталов

    protected boolean inExit() throws MyException { // проверяет робота на нахождение у выхода
        if (coordinates.equals(exitCoord)) { // если робот на выходе, выбрасывает из программы
            System.out.println("ROBOT OUT FROM MAZE");
            MyException e = new MyException(new Opr("ROBOT OUT FROM MAZE"));
            throw e;
        } else return false;
    }

    public void putPortal() {
        portals.add(coordinates);
    } // ставит портал

    public void teleport() { // телепортируется на место последнего портала
        matrix[coordinates.getValue()][coordinates.getKey()] = " ";
        coordinates = portals.peek();
        matrix[coordinates.getValue()][coordinates.getKey()] = "R";
        printMaze();
        System.out.println("TELEPORT");
    }

    public void printMaze() { // вывод лабиринта
        for (int i = 0; i < this.y; ++i) {
            for (int j = 0; j < this.x; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("---------------");
    }

    public int toTOP() throws MyException { // робот идет вверх
        if (coordinates.getValue() - 1 < 0 || matrix[coordinates.getValue() - 1][coordinates.getKey()].equals("#")) {
            return 0; // если уперлись в стену
        } else {
            coordinates = new Pair<>(coordinates.getKey(), coordinates.getValue() - 1);
            matrix[coordinates.getValue()][coordinates.getKey()] = "R";
            matrix[coordinates.getValue() + 1][coordinates.getKey()] = " ";
        }
        printMaze();
        System.out.println("TOP");
        if (inExit()) {
            System.out.println("Robot out");
        }
        return 1;
    }

    public int toBOTTOM() throws MyException { // робот идет вниз
        if (coordinates.getValue() + 1 == this.y || matrix[coordinates.getValue() + 1][coordinates.getKey()].equals("#")) {
            return 0;
        } else {
            coordinates = new Pair<>(coordinates.getKey(), coordinates.getValue() + 1);
            matrix[coordinates.getValue()][coordinates.getKey()] = "R";
            matrix[coordinates.getValue() - 1][coordinates.getKey()] = " ";
        }
        printMaze();
        System.out.println("BOTTOM");
        if (inExit()) {
            System.out.println("Robot out");
        }
        return 1;
    }

    public int toRIGHT() throws MyException {
        if (coordinates.getKey() + 1 == this.x || matrix[coordinates.getValue()][coordinates.getKey() + 1].equals("#")) {
            return 0;
        } else {
            coordinates = new Pair<>(coordinates.getKey() + 1, coordinates.getValue());
            matrix[coordinates.getValue()][coordinates.getKey()] = "R";
            matrix[coordinates.getValue()][coordinates.getKey() - 1] = " ";
        }
        printMaze();
        System.out.println("RIGHT");
        if (inExit()) {
            System.out.println("Robot out");
        }
        return 1;
    }

    public int toLEFT() throws MyException {
        if (coordinates.getKey() - 1 < 0 || matrix[coordinates.getValue()][coordinates.getKey() - 1].equals("#")) {
            return 0;
        } else {
            coordinates = new Pair<>(coordinates.getKey() - 1, coordinates.getValue());
            matrix[coordinates.getValue()][coordinates.getKey()] = "R";
            matrix[coordinates.getValue()][coordinates.getKey() + 1] = " ";
        }
        printMaze();
        System.out.println("LEFT");
        if (inExit()) {
            System.out.println("Robot out");
        }
        return 1;
    }

    public Robot(String fileName) {
        try { // считываение с файла в fileMaze
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                fileMaze.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.y = fileMaze.size();
        if (fileMaze.size() != 0) {
            this.x = fileMaze.get(0).length();
        }
        this.matrix = new String[this.y][this.x]; // составление матрицы, в которой содержится лабиринт
        for (int i = 0; i < this.y; ++i) {
            String str = fileMaze.get(i);
            for (int j = 0; j < this.x; ++j) {
                this.matrix[i][j] = String.valueOf(str.charAt(j));
                if (this.matrix[i][j].equals("R")) {
                    this.coordinates = new Pair<>(j, i);
                }
                if (this.matrix[i][j].equals("X")) {
                    this.exitCoord = new Pair<>(j, i);
                }
            }
        }

    }
}
