import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        List<Integer> nums = new ArrayList<>();

        for (int i = 0 ; i < n; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        nums.sort((a,b)->Integer.compare(a,b));

        //만약 처음 추의 무게가 1이 아닌경우 답은 1
        if (nums.get(0) != 1){
            System.out.print(1);
            return;
        }
        //현재 측정 가능한 무게의 범위, 초기는 아무것도 없으니 0~0 측정 가능
        int[] currentRange = new int[]{0,0};

        for (int i = 0; i < n ; i++){
            int currentWeight = nums.get(i);
            // 무게 추가 후 측정 가능한 무게 범위
            int[] afterRange = new int[]{currentRange[0]+currentWeight,currentRange[1]+currentWeight};

            if (currentRange[1] == 0) currentRange = new int[]{0,currentWeight};
            //만약 무게의 범위가 겹치거나 연속되면 두개의 범위를 합친것이 최종 측정 가능한 무게 범위
            else if (afterRange[0]-1 <= currentRange[1]) currentRange = new int[]{currentRange[0],afterRange[1]};
            else if(afterRange[0] > currentRange[1]){
                //만약 겹치지 않는 다면 측정할수 없는 무게 범위가 있다는 의미, 따라서 최소 값은 이전 범위의 최댓값 + 1
                System.out.print(currentRange[1]+1);
                return;
            }
        }

        System.out.print(currentRange[1]+1);

    }
}