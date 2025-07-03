import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int answer = 0;

        while (Integer.bitCount(n) > k) {
            n++;
            answer++;
        }

        System.out.println(answer);
    }
}
