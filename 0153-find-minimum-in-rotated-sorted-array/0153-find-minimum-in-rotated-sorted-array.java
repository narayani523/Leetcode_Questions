class Solution {
    public int findMin(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int min=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high])//array or this part of array is sorted so onlyy one min
            {
                if(min>arr[low]){
                    min=arr[low];
                }
                break;
            }
            if(arr[low]<=arr[mid])//left half is sorted
            {
                if(min>arr[low]){
                    min=arr[low];
                }
                low=mid+1;
            }
            else//right half is sorted
            {
                if(min>arr[mid]){
                    min=arr[mid];
                }
                high=mid-1;
            }
        }
        return min;
    }
}