class palindrome {
  public boolean isPalindrome(int x) {
    
      if (x < 0) return false;

      int n = x;
      int rev = 0;

        while (n > 0) {
          int d = n % 10; 
          rev = rev * 10 + d; 
          n = n / 10;                    
        }
      return x == rev;

  }
}

public class Palindrome_9 {
  public static void main(String[] args) {
        palindrome  sol = new palindrome ();
        int number = 121;
        boolean result = sol.isPalindrome(number);
        System.out.println("Is " + number + " a palindrome? " + result);
  }
}