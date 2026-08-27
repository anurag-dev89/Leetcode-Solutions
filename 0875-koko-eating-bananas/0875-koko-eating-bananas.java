class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=piles[0];

        for(int i = 0;  i < piles.length; i++){
            right=Math.max(right,piles[i]);
        }
        
        int ans=right;
        
        while(left <= right){
            int mid =  left+(right-left)/2;
            long hr=0;

            for(int i=0; i<piles.length; i++){
                hr += (piles[i]+mid-1)/mid;
            }
            if(hr <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1; 
            }   
        }
        return ans;
    }
}