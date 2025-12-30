import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        int value;
        List<Node> next = new ArrayList<>();
        int count = 0;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(nodes[from] == null && nodes[to] == null){
                Node fromNode = new Node(from);
                Node toNode = new Node(to);

                fromNode.next.add(toNode);
                toNode.count++;
                nodes[from] = fromNode;
                nodes[to] = toNode;
            }else  if(nodes[from] == null){
                Node fromNode = new Node(from);
                Node toNode = nodes[to];

                fromNode.next.add(toNode);
                toNode.count++;
                nodes[from] = fromNode;
            }else  if(nodes[to] == null){
                Node fromNode = nodes[from];
                Node toNode = new Node(to);

                fromNode.next.add(toNode);
                toNode.count++;
                nodes[to] = toNode;

            }else{
                Node fromNode = nodes[from];
                Node toNode = nodes[to];

                fromNode.next.add(toNode);
                toNode.count++;
            }

        }

        Queue<Node> queue = new LinkedList<>();

        for(int i = 1; i < n+1; i++){
            Node node = nodes[i];
            if(node == null){
                queue.add(new Node(i));
            }else if(node.count == 0){
                queue.add(node);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(Node next : node.next){
                next.count--;

                if(next.count == 0){
                    queue.add(next);
                }
            }

            sb.append(node.value).append(" ");
        }

        System.out.println(sb);
    }
}