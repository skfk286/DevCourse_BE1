package learn.baekjoon.p4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 섬의 개수
 */
public class Main_4963_섬의개수 {
    public static final int[] di = {-1, -1, -1, 0, 1, 1,  1,  0};
    public static final int[] dj = {-1,  0,  1, 1, 1, 0, -1, -1};

    public static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        String tmp = "";
        while((tmp = bf.readLine())!= null){
            int n = Integer.parseInt(tmp.split(" ")[0]);
            int m = Integer.parseInt(tmp.split(" ")[1]);
            System.out.println("n: + " +n + ", m: " + m);
            int[][] map = new int[m][n];
            visit = new boolean[m][n];

            int i = 0;
            while((tmp = bf.readLine())!= null){

                String[] tmpSplit = tmp.split(" ");
                for(int j = 0; j < tmpSplit.length; j++) {
                    map[i][j] = Integer.parseInt(tmpSplit[j]);
                }
                i++;

                if(m == i) break;
            }

            /**
             * 이 위치에서 갯수를 카운트 하고 출력하면 된다.
             */
            for(int row = 0; row < m ; row++) {
                for(int col = 0; col < n; col++) {

                }
            }

            System.out.println(searchLandCount(map));

            System.out.println("---------------------");
            System.out.println(Arrays.deepToString(map));
            System.out.println("---------------------");
        }
    }

    public static int searchLandCount(int[][] map, int nowi, int nowj) {
        int answer = 0;

        int land = 0;
        for(int i = 0; i < 8; i++) {
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];

            if(map[nowi][nowj] == 1 && !visit[nowi][nowj]) {
                visit[nowi][nowj] = true;
                land++;

                searchLandCount(map, nexti, nextj);

            }
        }

        if(land > 0)
            answer++;

        return answer;
    }
}
