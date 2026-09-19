/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //store max diameter
    int diameter = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        //calc height
        height(root);
        
        //return max diameter
        return diameter;
    }
    //fun to calc height
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        //calc right sub tree
        int right = height(root.right);

        //calc left sub tree
        int left = height(root.left);

        //update max diameter
        diameter = Math.max(diameter,left + right);
        
        //return height
        return 1 + Math.max(left, right);
    }
}