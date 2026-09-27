class Solution {
    public int[][] insert(int[][] intervals, int[] newinterval) {
        List<int[]> res=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        //left non overlapping part
        while(i<n && intervals[i][1] < newinterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newinterval[1]){
            newinterval[0]=Math.min(intervals[i][0],newinterval[0]);
            newinterval[1]=Math.max(intervals[i][1],newinterval[1]);
            i++;
        }
        res.add(newinterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);


    }
}