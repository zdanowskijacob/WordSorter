import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Scanner;


public class WordSorter {

    static int countLines(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        long num = Files.lines(path).count();
        return (int)num;
    }

    static String[] readLines(String fileName) throws IOException {

        int numLines = countLines(fileName);
        String linesTab[] = new String[numLines];
        File file = new File(fileName);
        Scanner sc = new Scanner(file,"UTF-8");

        int readLineNo = 0;
        while(sc.hasNext())
            linesTab[readLineNo++] = sc.nextLine();
        sc.close();
        return linesTab;
    }

    static void sorter(String fileName) throws IOException {

        String[] lines = readLines(fileName);
        Arrays.sort(lines);
        for(String str: lines) {

            String[] words = str.split(" ");
            Arrays.sort(words);
            for(String word: words)
                System.out.print(word + ",");
            System.out.println();
        }
    }
    public static void main(String[] args) {

        try {
            sorter("data.txt");
        } catch (IOException ex) {
            System.out.println("Brak pliku.");
        }

    }

}
