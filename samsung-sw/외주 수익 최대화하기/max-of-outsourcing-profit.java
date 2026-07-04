import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] day = new int[N];
        int[] money = new int[N];

        for(int i = 0; i < N; i++) {
            // i = 날짜  0 i + day <= N이 성립되어야함 
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            int next = i + day[i];

            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i] + money[i]);
            }
        }

        System.out.println(dp[N]);
    }

}