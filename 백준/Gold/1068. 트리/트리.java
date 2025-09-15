import java.awt.*;
import java.io.*;
import java.util.*;

public class Main{
    static int[][] board;
    static int answer=0;
    static int deleteNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int root = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1){
                root = i;
            }
            else{
                board[num][i] = 1;
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
        if (root == deleteNode){
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(answer);

    }

    public static void dfs(int currentNode){
        boolean hasChild = false;
        for (int i = 0 ; i < board[currentNode].length; i++){
            if (i == currentNode || i == deleteNode) continue;

            if (board[currentNode][i] == 1){
                dfs(i);
                hasChild = true;
            }
        }

        if (!hasChild) answer += 1;
    }

}
