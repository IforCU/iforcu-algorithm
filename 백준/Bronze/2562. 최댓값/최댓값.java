import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int index = 0;
        for(int i = 0; i < 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > max) {
                max = temp;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index + 1);
    }
}