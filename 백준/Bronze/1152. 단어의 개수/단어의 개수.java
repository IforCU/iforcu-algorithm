import java.io.*;
import java.util.*;

public class Main {

    private static int wordCount(String s) {
        if(s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        String[] parts = s.split("\\s+");
        return parts.length;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(wordCount(line));
    }
}