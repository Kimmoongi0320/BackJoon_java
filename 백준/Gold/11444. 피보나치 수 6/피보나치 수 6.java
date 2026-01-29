import java.util.*;
import  java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.print(divide(n)[0][1]);

    }

    static long[][] multiplyMatrix(long[][] mat, long[][] mat2){
        long[][] result = new long[2][2];

        result[0][0] = (mat[0][0]*mat2[0][0] + mat[0][1]*mat2[1][0])%1000000007;
        result[0][1] = (mat[0][0]*mat2[0][1] + mat[0][1]*mat2[1][1])%1000000007;
        result[1][0] = (mat[1][0]*mat2[0][0] + mat[1][1]*mat2[1][0])%1000000007;
        result[1][1] = (mat[1][0]*mat2[0][1] + mat[1][1]*mat2[1][1])%1000000007;

        return result;
    }

    static long[][] divide(long times){
        if(times == 1){
            return new long[][] {{1,1},{1,0}};
        }
        long[][] mat = divide(times / 2);

        long[][] answer = multiplyMatrix(mat,mat);
        if((times % 2) == 1){
            return multiplyMatrix(answer, new long[][] {{1,1},{1,0}});
        }else{
            return answer;
        }
    }
}


