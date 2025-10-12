import java.util.*;

public class CombSum_39 {

    public void solve(int index,int[] arr,int target,List<List<Integer>> ans,List<Integer> temp){
        int i=0;
        if(index==arr.length){     
            if(target==0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(arr[index]<=target){
            temp.add(arr[index]);
            solve(index,arr,target-arr[index],ans,temp);
            temp.remove(temp.size()-1);
        }   
        solve(index+1,arr,target,ans,temp);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int i=0;
        solve(i,candidates,target,ans,temp);
        return ans;
    }
    // 👇 Main function for testing in VS Code
    public static void main(String[] args) {
        CombSum_39 solve = new CombSum_39();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = solve.combinationSum(candidates, target);
        System.out.println(ans);
    }
}
