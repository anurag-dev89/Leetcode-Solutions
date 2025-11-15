import java.util.LinkedList;
import java.util.List;

public class AtoAform {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            ans.addFirst(k % 10);
            k /= 10;
        }

        return ans;
    }
    public static void main(String[] args) {
        AtoAform sol = new AtoAform();

        int[] num = {2, 7, 4};
        int k = 181;

        System.out.println("Resulting array form: " + sol.addToArrayForm(num, k));
    }
}
