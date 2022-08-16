package tictactoe;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static final String X = "X";
    public static final String O = "O";
    public static final String empty = " ";
    //public static String reductiveInput;

    static void printBoard(char[][] symbols) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(symbols[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean checkWinX(char[][] symbols){
        for (int i = 0; i < 3; i++){
            if(symbols[i][0] == symbols[i][1] && symbols[i][1] == symbols[i][2]){
                if(symbols[i][0] == X.charAt(0)){
                    System.out.println("X wins");
                    return true;
                }
            }
        }
        for (int j = 0; j < 3; j++){
            if(symbols[0][j] == symbols[1][j] && symbols[1][j] == symbols[2][j]){
                if(symbols[0][j] == X.charAt(0)){
                    System.out.println("X wins");
                    return true;
                }
            }
        }
        if(symbols[0][0] == symbols[1][1] && symbols[1][1] == symbols[2][2]){
            if(symbols[0][0] == X.charAt(0)){
                System.out.println("X wins");
                return true;
            }
        }
        if(symbols[0][2] == symbols[1][1] && symbols[1][1] == symbols[2][0]){
            if(symbols[0][2] == X.charAt(0)){
                System.out.println("X wins");
                return true;
            }
        }
        return false; //X doesn't win.
    }

    static boolean checkWinO(char[][] symbols){
        for (int i = 0; i < 3; i++){
            if(symbols[i][0] == symbols[i][1] && symbols[i][1] == symbols[i][2]){
                if(symbols[i][0] == O.charAt(0)){
                    System.out.println("O wins");
                    return true;
                }
            }
        }
        for (int j = 0; j < 3; j++){
            if(symbols[0][j] == symbols[1][j] && symbols[1][j] == symbols[2][j]){
                if(symbols[0][j] == O.charAt(0)){
                    System.out.println("O wins");
                    return true;
                }
            }
        }
        if(symbols[0][0] == symbols[1][1] && symbols[1][1] == symbols[2][2]){
            if(symbols[0][0] == O.charAt(0)){
                System.out.println("O wins");
                return true;
            }
        }
        if(symbols[0][2] == symbols[1][1] && symbols[1][1] == symbols[2][0]){
            if(symbols[0][2] == O.charAt(0)){
                System.out.println("O wins");
                return true;
            }
        }
        return false; //Y doesn't win.
    }

    static boolean checkFinished(char[][] symbols){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(symbols[i][j] == empty.charAt(0)){
                    return false;
                }
            }
        }
        return true; //Really finished. Print draw (run this method the last).
    }

    public static void main(String[] args) {
        // write your code here
        char[][] symbols = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                symbols[i][j] = empty.charAt(0);
            }
        }
        printBoard(symbols);
        int turn = 0;
        Scanner sc = new Scanner(System.in);

        int inputRow = 0;
        int inputColumn = 0;

            while (true){
                try{
                    inputRow = Integer.parseInt(sc.next());
                    inputColumn = Integer.parseInt(sc.next());
                }catch (NumberFormatException e){
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (inputRow > 3 || inputColumn > 3){
                    System.out.println("Coordinates should be from 1 to 3!");
                }else{
                    if (symbols[inputRow-1][inputColumn-1] != empty.charAt(0)){
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    if (turn %2 == 0){
                        symbols[inputRow-1][inputColumn-1] = "X".charAt(0);
                    }
                    if (turn %2 == 1){symbols[inputRow-1][inputColumn-1] = "O".charAt(0);}
                    printBoard(symbols);
                    turn ++;
                    if(checkWinX(symbols)){
                        System.out.println("X wins");
                        System.exit(0);
                    }
                    else if(checkWinO(symbols)){
                        System.out.println("O wins");
                        System.exit(0);
                    }
                    if(checkFinished(symbols)){
                        break;
                    }
                }
            }
        System.out.println("Draw");
        System.exit(0);
    }

}
