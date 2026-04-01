import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-i - 1; j++) System.out.print(" "); 
            for(int k = N-i - 1; k < N; k++) System.out.print("*");
            System.out.println();
        }
    }
}