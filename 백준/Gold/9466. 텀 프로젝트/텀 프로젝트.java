import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int teamSuccessCount;
    static int[] wish;
    static int[] teamSuccess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            wish = new int[n+1];
            teamSuccess = new int[n+1];
            teamSuccessCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i < n+1; i++){
                wish[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < n+1; i++){
                if(teamSuccess[i] == 0){
                    dfs(i,1);
                }
            }

            System.out.println(n-teamSuccessCount);
        }



    }

    public static void dfs(int member,int count){
        teamSuccess[member] = 1;

        int wantMember = wish[member];

        if(teamSuccess[wantMember] == 0){
            dfs(wantMember,count+1);
        }else if(teamSuccess[wantMember] == 1){
            int node = wantMember;

            while(node!=member){
                teamSuccessCount++;
                node = wish[node];
            }
            teamSuccessCount++;
        }

        teamSuccess[member] = 2;
    }


}

