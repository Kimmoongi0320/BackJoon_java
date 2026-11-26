import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
    static int l,r,c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // D,S.L.R => 0,1,2,3
        Map<Integer,String> maps = new HashMap<>();
        maps.put(0,"D");
        maps.put(1,"S");
        maps.put(2,"L");
        maps.put(3,"R");


        int t =  Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start =  Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Set<Integer> used = new HashSet<>();
            used.add(start);
            Queue<Integer> nums = new ArrayDeque<>();
            Queue<String> commands = new ArrayDeque<>();
            nums.add(start);
            commands.add("");

            String answer = null;
            while(!nums.isEmpty()) {
                int num =  nums.poll();
                String command =  commands.poll();

                if(num == end){
                    answer = command;
                    break;
                }

                for(int i= 0; i < 4; i++){
                    String c = maps.get(i);
                    int newNum = num;

                    if(c.equals("D")){
                        newNum = (newNum*2) % 10000;
                    }else if(c.equals("S")){
                        newNum--;
                        if(newNum < 0) newNum =9999;
                    }else if(c.equals("L")){
                        int l = newNum / 1000;
                        int left = newNum % 1000;
                        newNum = left*10 + l;

                    }else{
                        int r = newNum % 10;
                        int left = newNum / 10;
                        newNum = r*1000 + left;
                    }

                    if(!used.contains(newNum)){
                        used.add(newNum);
                        nums.add(newNum);
                        commands.add(command+maps.get(i));
                    }

                }
            }

            System.out.println(answer);
        }

    }


}