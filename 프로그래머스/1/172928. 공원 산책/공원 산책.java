import java.util.*;

class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int r = 0, c = 0;
        int h = park.length;
        int w = park[0].length();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        
        for(String route : routes) {
            String[] arr = route.split(" ");
            char dir = arr[0].charAt(0);
            int dist = Integer.parseInt(arr[1]);
            
            int dr = 0, dc = 0;
            
            if(dir == 'N') dr = -1;
            else if(dir == 'S') dr = 1;
            else if(dir == 'W') dc = -1;
            else if(dir == 'E') dc = 1;
            
            int nr = r;
            int nc = c;
            boolean ok = true;

            for (int i = 0; i < dist; i++) {
                nr += dr;
                nc += dc;

                if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                r = nr;
                c = nc;
            }
            
        }
        
        return new int[]{r, c};
    }
}