import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //최종 상태 배열
        boolean[] end = new boolean[n];

        String StartStatus = br.readLine();
        String EndStatus = br.readLine();


        for (int i = 0 ; i < n;  i++){
            if (EndStatus.charAt(i) == '1'){
                end[i] = true;
            }else{
                end[i] = false;
            }
        }
        // 첫 번째 버튼을 누른 경우
        boolean[] resultA = new boolean[n];
        // 첫 번째 버튼을 안 누르는 경우
        boolean[] resultB = new boolean[n];

        for (int i = 0 ; i < n;  i++){
            if (i <= 1){
                if (StartStatus.charAt(i) == '1'){
                    resultA[i] = false;
                    resultB[i] = true;
                }else{
                    resultA[i] = true;
                    resultB[i] = false;
                }
            }else{
                if (StartStatus.charAt(i) == '1'){
                    resultA[i] = true;
                    resultB[i] = true;
                }else{
                    resultA[i] = false;
                    resultB[i] = false;
                }
            }
        }

        int answerA = 1;
        int answerB = 0;
        for (int i = 1; i < n; i++){
            if (end[i-1] != resultA[i-1]){
                answerA++;
                resultA[i-1] = !resultA[i-1];
                resultA[i] = !resultA[i];
                if (i < n - 1) {
                    resultA[i + 1] = !resultA[i + 1];
                }
            }
            if (end[i-1] != resultB[i-1]){
                answerB++;
                resultB[i-1] = !resultB[i-1];
                resultB[i] = !resultB[i];
                if (i < n - 1) {
                    resultB[i + 1] = !resultB[i + 1];
                }
            }
        }

        if (resultA[n - 1] == end[n - 1] && resultB[n - 1] == end[n - 1]) {
            System.out.println(Math.min(answerA, answerB));
        } else if (resultA[n - 1] == end[n - 1]) {
            System.out.println(answerA);
        } else if (resultB[n - 1] == end[n - 1]) {
            System.out.println(answerB);
        } else {
            System.out.println(-1);
    }
    }

    }
