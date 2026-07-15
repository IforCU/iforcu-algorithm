import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] scores = new int[4][N];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
                scores[3][j] += scores[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            int max = i == 3 ? 3000 : 1000;
            int[] count = new int[max + 1];

            for (int j = 0; j < N; j++) {
                count[scores[i][j]]++;
            }

            int higher = 0;

            for (int j = max; j >= 0; j--) {
                int people = count[j];
                count[j] = higher + 1;
                higher += people;
            }

            for (int j = 0; j < N; j++) {
                sb.append(count[scores[i][j]]);

                if (j < N - 1) {
                    sb.append(' ');
                }
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}