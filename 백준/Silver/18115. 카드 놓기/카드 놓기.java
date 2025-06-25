import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        List<Integer> cards = new LinkedList<>();

        List<Integer> rules = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int rule = Integer.parseInt(st.nextToken());
            rules.add(rule);
        }
        Collections.reverse(rules);

        int num = 1;
        for (int rule: rules){
            if (rule == 1){
                cards.add(0,num);
            } else if (rule == 2) {
                cards.add(1,num);
            }else {
                cards.add(num);
            }
            num++;
        }
        StringBuilder sb = new StringBuilder();
        for (int card: cards){
            sb.append(card).append(" ");
        }

        System.out.println(sb);

    }


}
