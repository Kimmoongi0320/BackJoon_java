import java.util.*;
import  java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numAnswer = 0;
        String StringAnswer = "";

        for(int i = 0 ; i< 2; i++){
            String num =  br.readLine();
            StringAnswer = StringAnswer + num;
            numAnswer += Integer.parseInt(num);
        }

        int lastNumber = Integer.parseInt(br.readLine());
        System.out.println(numAnswer-lastNumber);
        System.out.println(Integer.parseInt(StringAnswer)-lastNumber);
    }


}
