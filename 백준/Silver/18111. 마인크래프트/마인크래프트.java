import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long sum = 0L;

        int[] freq = new int[257];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                freq[val]++;
                sum += val;
            }
        }

        long[] prefCount = new long[257];
        long[] prefSum = new long[257];
        prefCount[0] = freq[0];
        prefSum[0] = (long) freq[0] * 0;
        for (int h = 1; h <= 256; h++) {
            prefCount[h] = prefCount[h - 1] + freq[h];
            prefSum[h] = prefSum[h - 1] + (long) freq[h] * h;
        }

        long bestTime = Long.MAX_VALUE;
        int bestHeight = 0;
        long totalCount = prefCount[256];

        for (int h = 0; h <= 256; h++) {
            long countBelow = (h > 0) ? prefCount[h - 1] : 0L;
            long sumBelow = (h > 0) ? prefSum[h - 1] : 0L;
            long needBlocks = (long) h * countBelow - sumBelow;

            long countAbove = totalCount - prefCount[h];
            long sumAbove = prefSum[256] - prefSum[h];
            long removeBlocks = sumAbove - (long) h * countAbove; 

            if (removeBlocks + B < needBlocks) continue; 

            long timeNeeded = removeBlocks * 2 + needBlocks;
            if (timeNeeded < bestTime || (timeNeeded == bestTime && h > bestHeight)) {
                bestTime = timeNeeded;
                bestHeight = h;
            }
        }

        System.out.println(bestTime + " " + bestHeight);
    }
}