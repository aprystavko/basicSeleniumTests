package workWithFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileOperation {

    public void printFileInConsole(String filepath) {
        try (FileInputStream file = new FileInputStream(filepath)) {
            System.out.println("Размер файла: " + file.available() + " байт(а)");
            System.out.println("Содержимое файла: ");
            int i = -1;
            while ((i = file.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateFile(String fileInputData, String filepath) {
        try {
            FileOutputStream file = new FileOutputStream(filepath);
            byte b[] = fileInputData.getBytes();
            file.write(b);
            file.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}






