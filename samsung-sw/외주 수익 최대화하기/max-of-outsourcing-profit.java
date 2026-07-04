import java.io.*;
import java.util.*;

public class Main {
    static int maxProfit = 0;
    static Task[] tasks;
    static int N;

    static class Task{
        int day;
        int money;
        Task(int day, int money) {
            this.day = day;
            this.money = money;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tasks = new Task[N];
        for(int i = 0; i < N; i++) {
            // i = 날짜  0 i + day <= N이 성립되어야함 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(day, money);
        }

        backTracking(0,0);

        System.out.println(maxProfit);
    }

    static void backTracking(int idx, int profit){
        if(idx > N) return;
        if(profit > maxProfit) maxProfit = profit; 
        for(int i = idx ; i < N; i++) {
            if(i + tasks[i].day <= N) {
                backTracking(i + tasks[i].day, profit + tasks[i].money);
            }
        }
    }
}