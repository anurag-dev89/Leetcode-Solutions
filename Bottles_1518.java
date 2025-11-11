class Bottles_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while(numBottles >= numExchange){

            int newBottles = numBottles / numExchange;

            int remBottles = numBottles % numExchange;

            ans = ans + newBottles;

            numBottles = newBottles + remBottles;
        }
        return ans;
    }
    public static void main(String[] args) {
        Bottles_1518 sol = new Bottles_1518();

        int numBottles = 9;
        int numExchange = 3;

        System.out.println("Total bottles drunk: " + sol.numWaterBottles(numBottles, numExchange));
    }
}