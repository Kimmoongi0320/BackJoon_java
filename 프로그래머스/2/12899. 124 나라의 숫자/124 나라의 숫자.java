class Solution {
    public String solution(int n) {

        return convertNum(n);
    }
    
    public String convertNum(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int remainder = n%3;
            if(remainder == 0){
                sb.append("4");
                n = n/3 - 1;
            }else{
                sb.append(remainder);
                n /= 3;
            }
        }
        String result = sb.reverse().toString();
        return result;
    }
    

}