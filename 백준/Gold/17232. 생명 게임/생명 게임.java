import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, K, a, b;
    static int[][] grid;
    static int[][] prefix;

    static int[][] simulation() {
        buildPrefix();
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int count = numberCount(i, j);
                if (grid[i][j] == 1) {
                    temp[i][j] = (count >= a && count <= b) ? 1 : 0;
                } else {
                    temp[i][j] = (count > a && count <= b) ? 1 : 0;
                }
            }
        }
        return temp;
    }

    static void buildPrefix() {
        prefix = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += grid[i][j];
                prefix[i+1][j+1] = prefix[i][j+1] + rowSum;
            }
        }
    }

    static int numberCount(int r, int c) {
        int r1 = r - K, c1 = c - K, r2 = r + K, c2 = c + K;
        int total = rectSum(r1, c1, r2, c2);
        total -= grid[r][c];
        return total;
    }

    static int rectSum(int r1, int c1, int r2, int c2) {
        int rr1 = Math.max(0, r1);
        int cc1 = Math.max(0, c1);
        int rr2 = Math.min(N-1, r2);
        int cc2 = Math.min(M-1, c2);
        if (rr1 > rr2 || cc1 > cc2) return 0;
        return prefix[rr2+1][cc2+1] - prefix[rr1][cc2+1] - prefix[rr2+1][cc1] + prefix[rr1][cc1];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] ch = s.toCharArray();

            for(int j = 0; j < M; j++) {
                if(ch[j] == '*') grid[i][j] = 1;
                else grid[i][j] = 0; 
            }
        }

        for(int i = 0; i < T; i++) {
            grid = simulation();
        }

        for (int[] ch : grid) {
            for (int c : ch) {
                System.out.print(c == 1 ? '*' : '.');
            }
            System.out.println();
        }

    }
}