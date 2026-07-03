import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        // A = 0, B = 1, C = 2, D = 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] car = new int[n+1];
        int[] carTime = new int[n+1];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int time = Integer.parseInt(st.nextToken());
            carTime[i] = time;
            String location = st.nextToken();
            car[i] = (location.charAt(0) - 'A');
        }

        car[n] = 0;
        carTime[n] = (int) 1e9 + 5;

        Queue<Integer>[] cars = new LinkedList[4];
        for(int i = 0; i < 4; i++) {
            cars[i] = new LinkedList<>();
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ans.add(-1);
        }



        int time = -1;

        for(int i = 0; i <= n; i++) {

            while(time < carTime[i] && (!cars[0].isEmpty() || !cars[1].isEmpty() || !cars[2].isEmpty() || !cars[3].isEmpty() )){
                
                List<Integer> avail = new ArrayList<>();
                for(int d = 0; d < 4; d++) {
                    if(!cars[d].isEmpty() && cars[(d+3) % 4].isEmpty()) avail.add(d);
                }
                if(avail.isEmpty()) break;

                for(int d : avail) {
                    int idx = cars[d].poll();
                    ans.set(idx, time);
                }

                time++;
            }

            time = carTime[i];
            cars[car[i]].add(i);
        }

        for(int i = 0 ; i < n; i++) {
            System.out.println(ans.get(i));
        }
    }
}