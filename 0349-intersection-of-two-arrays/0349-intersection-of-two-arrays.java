class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        ArrayList<Integer> ans =new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j] && !ans.contains(nums1[i])){
                    ans.add(nums1[i]);
                }
            }
        }
        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}