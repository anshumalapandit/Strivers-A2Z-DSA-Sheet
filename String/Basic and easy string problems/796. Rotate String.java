class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String newS=s+s;
        if(newS.contains(goal)){
            return true;
        }
        return false;
    }
}
