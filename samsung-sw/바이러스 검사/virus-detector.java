import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] CUST = new long[n];

        for(int i = 0; i < n; i++) {
            CUST[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());

        long LDR = Long.parseLong(st.nextToken());
        long MBR = Long.parseLong(st.nextToken());

        long answer = 0;

        for(long num : CUST) {
            long rest = num - LDR;
            answer++;
            if(rest > 0) {
                long share  = rest / MBR;
                long remain = rest % MBR;
                if(remain > 0) share++;

                answer += share;
            }
        }

        System.out.println(answer);
    }
}