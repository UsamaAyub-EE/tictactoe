import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        while(!functions.exit)
        {
            if(counter == 0)
            {
                functions.inputArray();
                functions.printArray();
                counter++;
            }
            functions.inputCoordinate();
            functions.fillCheck();
            functions.emptyCheck();
            functions.horizontalCheck();
            functions.verticalCheck();
            functions.diagonalCheck();
            functions.printFinalResult();
        }
    }
}



