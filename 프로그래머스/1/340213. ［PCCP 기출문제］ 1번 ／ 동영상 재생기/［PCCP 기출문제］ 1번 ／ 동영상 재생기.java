class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int cur = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        int videoEnd = toSec(video_len);
        
        cur = skipOp(cur, opStart, opEnd);
        
        for (String command : commands) {
            if (command.equals("next")) {
                cur = Math.min(cur + 10, videoEnd);
            } else {
                cur = Math.max(cur - 10, 0);
            }
            cur = skipOp(cur, opStart, opEnd);
        }
        
        return toStr(cur);
    }
    
    int toSec(String time) {
        return Integer.parseInt(time.substring(0,2)) * 60 
             + Integer.parseInt(time.substring(3,5));
    }
    
    int skipOp(int cur, int opStart, int opEnd) {
        if (cur >= opStart && cur <= opEnd) return opEnd;
        return cur;
    }
    
    String toStr(int sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }
}