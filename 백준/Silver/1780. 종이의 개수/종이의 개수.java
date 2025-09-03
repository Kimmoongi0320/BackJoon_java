import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr;
    static int one=0;
    static int zero=0;
    static int minus=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());;
            for (int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        divide(0,0,n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    public static void divide(int startX, int startY,int size){
        int num = arr[startX][startY];

        for (int i = startX; i < startX+size; i++){
            for (int j = startY; j < startY+size; j++){
                if (arr[i][j] != num){
                    int newSize = size/3;
                    for (int k = 0; k< 3; k++){
                        for (int l = 0; l < 3; l++){
                            divide(startX + k*newSize, startY + l*newSize, newSize);
                        }
                    }
                    return;
                }
            }
        }

        if (num == 0){
            zero++;
        }else if (num == 1){
            one++;
        }else if (num == -1){
            minus++;
        }
    }
}