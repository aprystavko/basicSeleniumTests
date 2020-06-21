package workWithFile;

public class Main {

    public static void main(String[] args) {

        String filePath = "C://WorkWithFiles//write_file.txt";

        FileOperation fileOperation = new FileOperation();

        fileOperation.printFileInConsole(filePath);
        fileOperation.updateFile("Hello Bugs", filePath);
        fileOperation.printFileInConsole(filePath);
        System.out.println("");

        Matrix matrix = new Matrix();
        System.out.println("Create matrix and out in console log:");
        int[][] myMatrix = matrix.createMatrix(3, 3);

        System.out.println("Change diagonal values in the matrix:");
        matrix.updateDiagonalMatrix(myMatrix, 9);

        fileOperation.updateFile(matrix.makeStrongFromMatrix(myMatrix), filePath);
        fileOperation.printFileInConsole(filePath);
    }
}
