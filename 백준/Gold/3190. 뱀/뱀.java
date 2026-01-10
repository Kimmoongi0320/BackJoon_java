import java.util.*;
import java.io.*;

public class Main {


    static class Direction{
        String command;
        int[] dir;
        Direction(String command, int[] dir){
            this.command = command;
            this.dir = dir;
        }
    }

    static class Command{
        int time;
        String dir;
        public Command(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int currentDir = 0;
        List<Direction> directions = new ArrayList<>();
        directions.add(new Direction("R",new int[]{0,1}));
        directions.add(new Direction("U",new int[]{-1,0}));
        directions.add(new Direction("L",new int[]{0,-1}));
        directions.add(new Direction("D",new int[]{1,0}));

        int[][] board = new int[n][n];

        for(int i = 0; i< k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x-1][y-1] = 2; // 사과는 2로 표현
        }

        board[0][0] = 1; // 뱀의 몸은 1
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        int l = Integer.parseInt(br.readLine());

        List<Command> commands = new ArrayList<>();
        for(int i = 0; i< l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            commands.add(new Command(time, dir));
        }

        int commandIdx = 0;
        int totalCommandCount = commands.size();

        int time = 0;
        int headX = 0;
        int headY = 0;
        while(true){
            time++;
            Direction currentDirection = directions.get(currentDir);

            int nextHeadX = headX +  currentDirection.dir[0];
            int nextHeadY = headY + currentDirection.dir[1];

            if(nextHeadX < 0 || nextHeadY < 0 || nextHeadX >= n || nextHeadY >= n ||board[nextHeadX][nextHeadY] == 1){
                break;
            } else if (board[nextHeadX][nextHeadY] == 2) {
                snake.addFirst(new int[]{nextHeadX, nextHeadY});
                board[nextHeadX][nextHeadY] = 1;
            }else{
                snake.addFirst(new int[]{nextHeadX, nextHeadY});
                board[nextHeadX][nextHeadY] = 1;
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            headX = nextHeadX;
            headY = nextHeadY;

            if (commandIdx < totalCommandCount && time == commands.get(commandIdx).time){
                if(Objects.equals(commands.get(commandIdx).dir, "L")){
                    currentDir = (currentDir + 1)%4;
                }else{
                    currentDir = (currentDir + 3) % 4;
                }
                commandIdx++;
            }

        }

        System.out.println(time);
    }
}