import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        char lastNum= num.charAt(0);

        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 1; i < num.length(); i++){
            char currentNum = num.charAt(i);
            if (currentNum != lastNum){
                if (lastNum == '0'){
                    zeroCount += 1;
                    lastNum = '1';
                }else {
                    oneCount += 1;
                    lastNum = '0';
                }
            }
        }
        if (num.charAt(num.length()-1) == '1'){
            oneCount++;
        }else zeroCount++;

        System.out.print(Integer.min(zeroCount,oneCount));

    }


}
