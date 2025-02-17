import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String tiles = br.readLine();
        List<Integer> counts = new ArrayList<>();
        int paper = tiles.indexOf("P");
        int scissors = tiles.indexOf("S");
        int rock = tiles.indexOf("R");

        counts.add(findCount('P',paper,tiles));
        counts.add(findCount('S',scissors,tiles));
        counts.add(findCount('R',rock,tiles));
        System.out.println(counts.stream().min(Integer::compareTo).get());

    }
    public static int findCount(char startCommand, int startIdx,String tiles){
        Character[] command;
        if (startCommand == 'P'){
            command = new Character[]{'P','R','S'};
        } else if (startCommand == 'R') {
            command = new Character[]{'R','S','P'};
        }else {
            command = new Character[]{'S','P','R'};
        }

        int count =startIdx;
        int place = 1;
        Stack<Character> stack = new Stack<>();
        for(int i = startIdx + 1; i < tiles.length(); i++){
            if(tiles.charAt(i) == command[place%3]){
                place++;
                stack.push(tiles.charAt(i));
            }else{
                count+=1;
            }
        }
        while(!stack.isEmpty() && stack.peek() != command[2]){
            count++;
            stack.pop();
        }
        return count;
    }
}


//SRPSRPRSPRSRP