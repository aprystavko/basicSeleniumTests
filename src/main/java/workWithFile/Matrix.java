package workWithFile;

public class Matrix {


    public int[][] createMatrix(int matrixLength, int matrixWidth) {
        int[][] arrayOutput = new int[0][];
        try {
            arrayOutput = new int[matrixLength][matrixWidth];
            for (int i = 0; i < arrayOutput.length; i++) {
                for (int j = 0; j < arrayOutput.length; j++) {
                    arrayOutput[i][j] = 0;
                }
            }
            printMatrix(arrayOutput);
            return arrayOutput;
        } catch (NegativeArraySizeException e) {
            System.out.println("Размер метрица не может быть отрицательным числом");
        } catch (Exception e) {
            System.out.println("Something wrong in createMatrix");
        }
        return arrayOutput;
    }

    public int[][] updateDiagonalMatrix(int matrix[][], int diagonalValue) {

        try {
            int j = 0;
            for (int i = 0; i < matrix.length; i++, j++) {
                matrix[i][j] = diagonalValue;
            }
            printMatrix(matrix);
        } catch (Exception e) {
            System.out.println("Something wrong in updateDiagonalMatrix");
        }
        return matrix;
    }

    public void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public String makeStrongFromMatrix(int matrix[][]) {
        String stringMatrix = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stringMatrix = stringMatrix + String.valueOf(matrix[i][j] + "  ");
            }
            stringMatrix = stringMatrix + " \n";
        }
        return stringMatrix;
    }
}
