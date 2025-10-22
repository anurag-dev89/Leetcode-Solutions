class MostWater_11 {
    public int maxArea(int[] height) {
        int maxcap = 0;
        int st = 0;
        int end = height.length -1;

        while (st < end) {
            if (height[st] < height[end]){
             maxcap = Math.max( maxcap, height[st] * (end-st));
                st++;
            } else {
             maxcap = Math.max( maxcap, height[end] * (end-st));            
                end--;

            }
        }
        return maxcap;
    }
    public static void main(String[] args) {
        MostWater_11 sol = new MostWater_11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(height));
    }
}