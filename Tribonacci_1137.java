class Tribonacci_1137 {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        int t0 = 0, t1 = 1 , t2 = 1 , t3 =0;

        for( int i = 3; i<=n ; i++){
            t3 = t0 + t1 + t2 ;

            t0 = t1;
            t1 = t2;
            t2 = t3;
         
        }
        return t3;
    }
    public static void main(String[] args){
        Tribonacci_1137 sol = new Tribonacci_1137();

        int n=6;
        System.out.println("Tribonacci of "+ n + " is : " + sol.tribonacci(n));;
    }
}