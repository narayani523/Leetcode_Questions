class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        int c=0;
        int minl=Integer.MAX_VALUE;
        int sindex=0;
        int[] freq=new int[256];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }
        while(r<s.length()){
            if(freq[s.charAt(r)]>0){
                c=c+1;
                
            }
            freq[s.charAt(r)]--;
            while(c==t.length()){
                if((r-l+1)<minl){
                    minl=r-l+1;
                    sindex=l;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0){
                    c--;
                }
                l++;
            }
            r++;
        }
        if (minl == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(sindex, sindex + minl);
    }
}