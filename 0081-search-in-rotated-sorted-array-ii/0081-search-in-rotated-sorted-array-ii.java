class Solution {
    public boolean search(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        boolean ans= false;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            //the only problem
            if(arr[start]==arr[mid]&& arr[end]==arr[mid]){
                start=start+1;
                end=end-1;
                continue;
            }
            //if lest half is sorted 
            if(arr[start]<=arr[mid]){
                //check if target lies in left sorted half
                if(arr[start]<=target && arr[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                //check if target lies in left sorted half
                if(arr[mid]<target && arr[end]>=target){
                    start=mid+1;;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return ans;
    }
}