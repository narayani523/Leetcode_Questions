class Solution {
    public boolean canAliceWin(int n) {
        int turn =10;
        int c=0;
        while(n>=turn){
            n=n-turn;
            c++;
            turn--;
        }
        if(c%2==0){
            return false;
        }
        return true;
    }
}