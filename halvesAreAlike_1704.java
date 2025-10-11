import java.util.*;

class halvesAreAlike_1704 {
    public boolean halvesAreAlike(String s) {
        
        String vow="aeiouAEIOU";

        int n=s.length();

        int mid=n/2;

        int cnt1=0 ,cnt2=0;

        for(int i=0 ; i<mid ;i++){
            if(vow.indexOf(s.charAt(i))!= -1)

            cnt1++;
        }

        for(int i=mid ; i<n ;i++){
            if(vow.indexOf(s.charAt(i))!= -1)

            cnt2++;
        }
        return cnt1==cnt2;
    }
    public static void main(String[] args) {
        halvesAreAlike_1704 sol = new halvesAreAlike_1704();

        System.out.println(sol.halvesAreAlike("book"));
        System.out.println(sol.halvesAreAlike("textbook"));
    }
}