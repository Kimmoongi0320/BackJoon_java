import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String,Integer> symbols = Map.of(
                "+",1,
                "-",1,
                "*",2,
                "/",2,
                "(",3,
                ")",3

        );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            String currentSymbol = String.valueOf(input.charAt(i));

            if(!symbols.containsKey(currentSymbol)){
                sb.append(currentSymbol);
            }else{
                if(stack.isEmpty()){
                    stack.push(currentSymbol);
                }else if(currentSymbol.equals(")")){

                    while (!stack.isEmpty() && !stack.peek().equals("(")){
                        String nextSymbol = stack.pop();
                        sb.append(nextSymbol);
                    }
                    stack.pop();
                }else {
                    if(symbols.get(stack.peek()) <  symbols.get(currentSymbol) ){
                        stack.push(currentSymbol);
                    }else{
                        while(!stack.isEmpty() && !stack.peek().equals("(") && symbols.get(stack.peek()) >= symbols.get(currentSymbol)){
                            String beforeSymbol = stack.pop();
                            sb.append(beforeSymbol);
                        }
                        stack.push(currentSymbol);
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}