import java.util.Scanner;

public class functions {
    static int k = 0;
    static int xCount = 0;
    static int oCount = 0;
    static int xSplit = 0;
    static int oSplit = 0;
    static int empty = 0;
    static int count = 1;
    static boolean exit = false;
    static String x ;
    static String y;
    static char[][] cellArray = new char[3][3];

    public static void inputArray()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellArray[i][j] = ' ';
            }

        }
    }
    public static void inputCoordinate()
    {
        System.out.println("Enter the coordinates: ");
        Scanner Scanner = new Scanner(System.in);
        x = Scanner.next();
        y = Scanner.next();
        if(x.charAt(0) < '0' || x.charAt(0) > '9' || y.charAt(0) < '0' || y.charAt(0) > '9' )
        {
            System.out.println("You should enter numbers!");
            functions.inputCoordinate();
        }
        else if ( Integer.parseInt(x) > 3 || Integer.parseInt(y) > 3 || Integer.parseInt(x) <= 0 || Integer.parseInt(y) <=0) {
            System.out.println("Coordinates should be from 1 to 3!");
            functions.inputCoordinate();
        }
    }
    public  static void fillCheck()
    {
        int i = 0;
        if((x.charAt(0) - 49) == 0 && (y.charAt(0) - 48)  == 3 || (x.charAt(0) - 49) == 1 && (y.charAt(0) - 48) == 3 || (x.charAt(0) - 49) == 2 && (y.charAt(0) - 48) == 3)
        {
            i = 0;
        }
        if((x.charAt(0) - 49) == 0 && (y.charAt(0) - 48) == 2 || (x.charAt(0) - 49) == 1 && (y.charAt(0) - 48) == 2 || (x.charAt(0) - 49) == 2 && (y.charAt(0) - 48) == 2)
        {
            i = 1;
        }
        if((x.charAt(0) - 49) == 0 && (y.charAt(0) - 48) == 1 || (x.charAt(0) - 49) == 1 && (y.charAt(0) - 48) == 1 || (x.charAt(0) - 49) == 2 && (y.charAt(0) - 48) == 1)
        {
            i = 2;
        }
        int j = x.charAt(0) - 49;
        if(cellArray[i][j] == 'X' || cellArray[i][j] == 'O')
        {
            System.out.println("This cell is occupied! Choose another one!");
            functions.inputCoordinate();
        }
        else {
            if(count % 2 == 0)
            {
                cellArray[i][j] = 'O';
                count++;
            }
            else if(count % 2 != 0)
            {
                cellArray[i][j] = 'X';
                count++;
            }
            functions.printArray();
        }
    }
    public  static void emptyCheck()
    {
        for(int i = 0; i < cellArray.length; i++) {
            for(int j = 0; j < cellArray[i].length; j++) {
                if(/*cellArray[i][j] == '_' ||*/ cellArray[i][j] == ' ') {
                    empty++;
                } else if(cellArray[i][j] == 'X') {
                    xSplit++;
                } else if(cellArray[i][j] == 'O') {
                    oSplit++;
                } else if(cellArray[i][j] != ' '){
                    empty = 0;
                }
            }
        }
    }

    public  static void horizontalCheck()
    {
        for(int i = 0; i < cellArray.length; i++) {
            if(cellArray[i][0] == 'X' && cellArray[i][1] == 'X' && cellArray[i][2] == 'X') {
                xCount++;
            }
            else if(cellArray[i][0] == 'O' && cellArray[i][1] == 'O' && cellArray[i][2] == 'O') {
                oCount++;
            }
        }
    }

    public static void verticalCheck()
    {

        for(int j = 0; j < cellArray.length; j++) {
            if(cellArray[0][j] == 'X' && cellArray[1][j] == 'X' && cellArray[2][j] == 'X') {
                xCount++;
            }
            else if(cellArray[0][j] == 'O' && cellArray[1][j] == 'O' && cellArray[2][j] == 'O') {
                oCount++;
            }
        }
    }

    public static void diagonalCheck()
    {
        if(cellArray[0][0] == 'X' && cellArray[1][1] == 'X' && cellArray[2][2] == 'X' ||
                cellArray[0][2] == 'X' && cellArray[1][1] == 'X' && cellArray[2][0] == 'X') {
            xCount++;
        }
        else if(cellArray[0][0] == 'O' && cellArray[1][1] == 'O' && cellArray[2][2] == 'O' ||
                cellArray[0][2] == 'O' && cellArray[1][1] == 'O' && cellArray[2][0] == 'O') {
            oCount++;
        }
    }

    public  static void printArray()
    {
        System.out.println("---------");
        System.out.println("| " + cellArray[0][0] + " " + cellArray[0][1] + " " + cellArray[0][2] + " |" );
        System.out.println("| " + cellArray[1][0] + " " + cellArray[1][1] + " " + cellArray[1][2] + " |" );
        System.out.println("| " + cellArray[2][0] + " " + cellArray[2][1] + " " + cellArray[2][2] + " |" );
        System.out.println("---------");
    }

    public  static void printFinalResult()
    {
        if((xCount == 1 && oCount == 1) /*|| (xSplit - oSplit) > 2 || (oSplit - xSplit) > 2*/) {
            System.out.println("Impossible");
            exit = true;
        } else if(xCount == 0 && oCount == 0 && empty > 0) {
            exit = false;
        } else if(xCount == 0 && oCount == 0 && empty == 0) {
            System.out.println("Draw");
            exit = true;
        } else if(xCount > 0) { //xCount == 0;
            System.out.println("X wins");
            exit = true;
        } else if(oCount == 1) {
            System.out.println("O wins");
            exit = true;
        }
    }
}