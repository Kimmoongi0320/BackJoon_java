import java.util.*;
import java.io.*;

public class Main {
    static int l;
    static int c;
    static char[] arr;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        used = new boolean[c];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        backTracking(0,0);
    }

    static void backTracking(int start, int length){
        if(length == l){
            StringBuilder answer = new StringBuilder();
            int vowel = 0;
            int consonant = 0;

            for(int i = 0 ; i < c; i++){
                if(used[i]){
                    char currentChar = arr[i];
                    answer.append(currentChar);

                    if(currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') vowel++;
                    else consonant++;
                }
            }

            if(vowel >= 1 && consonant >= 2){
                System.out.println(answer);
            }
            return;
        }

        for(int i = start; i < c; i++){
            used[i] = true;
            backTracking(i+1, length+1);
            used[i] = false;
        }
    }

}