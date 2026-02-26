import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int len = N * M;
        int sum = 0;
        map = new int[N * M];

        count = new int[257];
        Arrays.fill(count, Integer.MAX_VALUE);
        int min = 257;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i * M + j] = val;
                if(min > val) min = val;
                sum += val;
            }
        }

        int max = (B + sum) / len;
        if (max > 256) max = 256;

        for(int i = min; i <= max; i++) {
            int upCount = 0;
            int downCount = 0;
            for(int j = 0; j < len; j++) {
                if(map[j] == i) continue;
                if(map[j] > i) upCount += map[j] - i;
                else downCount += i - map[j]; 
            }
            count[i] = upCount * 2 + downCount;
        }

        int time = Integer.MAX_VALUE;
        int height = 257;
        for(int i = 256; i >= 0; i--) {
            if(time > count[i]) {
                time = count[i];
                height = i;
            }
        }

        System.out.println(time +" "+height);
    }
}