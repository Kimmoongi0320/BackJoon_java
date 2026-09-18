import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        List<String[]> distributeFile = new ArrayList<>();
        
        for(String file : files){
            int idx = 0;
            String[] distribute = new String[3];
            for(int i = idx; i < file.length(); i++){
                if(Character.isDigit(file.charAt(i))){
                    distribute[0] = file.substring(0,i).toLowerCase();
                    idx = i;
                    break;
                }
            }
            
            distribute[1] = file.substring(idx, file.length());
            for(int i = idx; i < file.length(); i++){
                if(!Character.isDigit(file.charAt(i))){
                    distribute[1] = file.substring(idx,i);
                    break;
                }
            }
            
            distribute[2] = file;
            distributeFile.add(distribute);
        }
        distributeFile.sort((a,b)->{
            if(a[0].equals(b[0])) return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            else return a[0].compareTo(b[0]);
        });
        String[] answer = new String[distributeFile.size()];
        
        for(int i = 0; i < distributeFile.size(); i++){
            answer[i] = distributeFile.get(i)[2];
        }
        return answer;
    }
}