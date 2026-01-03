import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }

        int sum = 0;

        int head = 0;
        int tail = 0;

        int answer = 0;

        while(tail <= primes.size()){
            if(sum == n){
                answer++;
            }

            if(sum >= n){
                sum -= primes.get(head);
                head++;
            } else {
                if(tail < primes.size()){
                    sum += primes.get(tail);
                    tail++;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int num){
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


}