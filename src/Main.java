import java.io.*;
import java.util.ArrayList;

public class Main {
    public static StringBuilder log = new StringBuilder();
    public static ArrayList<File> directoryList = new ArrayList();
    public static ArrayList<File> fileList = new ArrayList();

    public static void main(String[] args) {

        newDirectory("C://Users//Александра//Desktop//Games//src");
        newDirectory("C://Users//Александра//Desktop//Games//res");
        newDirectory("C://Users//Александра//Desktop//Games//savegames");
        newDirectory("C://Users//Александра//Desktop//Games//temp");
        newDirectory("C://Users//Александра//Desktop//Games//src//main");
        newDirectory("C://Users//Александра//Desktop//Games//src//main//java");
        newDirectory("C://Users//Александра//Desktop//Games//src//test");
        newFile("C://Users//Александра//Desktop//Games//src//main//Main.java");
        newFile("C://Users//Александра//Desktop//Games//src//main//Utils.java");
        newDirectory("C://Users//Александра//Desktop//Games//res//drawables");
        newDirectory("C://Users//Александра//Desktop//Games//res//vectors");
        newDirectory("C://Users//Александра//Desktop//Games//res//icons");
        newFile("C://Users//Александра//Desktop//Games//temp//temp.txt");

        makeDirectory(directoryList);
        makeFile(fileList);

        String logString = log.toString();

        try {
            FileWriter t = new FileWriter("C://Users//Александра//Desktop//Games//temp//temp.txt", true);
            t.write(logString);
            t.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void newDirectory(String path) {
        File directory = new File(path);
        log.append("Создан каталог ").append(directory.getAbsolutePath()).append(System.lineSeparator());
        ;
        directoryList.add(directory);
    }

    public static void newFile(String path) {
        File file = new File(path);
        log.append("Создан файл ").append(file.getAbsolutePath()).append(System.lineSeparator());
        ;
        fileList.add(file);
    }

    public static void makeDirectory(ArrayList<File> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).mkdir();
        }
    }

    public static void makeFile(ArrayList<File> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                list.get(i).createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка создания файла " + list.get(i).getName());
            }
        }
    }


}