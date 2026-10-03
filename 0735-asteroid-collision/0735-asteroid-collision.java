class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        ArrayList<Integer> list=new ArrayList<>();
        int[] survive=new int[n];
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                list.add(asteroids[i]);
            }
            else{
                int curr=Math.abs(asteroids[i]);
                boolean destroyed=false;
                while(!list.isEmpty() && list.get(list.size()-1)>0){
                    int idx=list.size()-1;
                    int top=Math.abs(list.get(idx));
                    if(top<curr){
                        list.remove(idx);
                    }
                    else{
                        if(top==curr){
                            list.remove(idx);
                        }
                        destroyed=true;
                        break;
                    }
                }
                 if(destroyed==false){
                list.add(asteroids[i]);
            }
            }
           
        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}