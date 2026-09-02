class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer>curr=new HashMap<>();
        curr.put(0,1);
        for(int i=0;i<n;i++){
            Map<Integer,Integer> nm=new HashMap<>();
            for(int val:curr.keySet()){
                int x=val+nums[i];int y=val-nums[i];
                nm.put(x,nm.getOrDefault(x,0)+curr.get(val));
                nm.put(y,nm.getOrDefault(y,0)+curr.get(val));
            }
            curr=nm;
        }
        int count=0;
        for(int val:curr.keySet()){
            if(val==target){
                count+=curr.get(val);
            }
        }return count;
    }
}
