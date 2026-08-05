import java.util.Scanner;

class Palin {
    public boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }

        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}

public class Palindrome_125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        Palin obj = new Palin();
        System.out.println("Palindrome: " + obj.isPalindrome(s));

        sc.close();
    }
}