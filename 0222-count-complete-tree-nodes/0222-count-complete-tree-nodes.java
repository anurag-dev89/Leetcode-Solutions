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

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        // If both depths are equal, the entire tree is perfect
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        }else{

            // Otherwise, count normally
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {

        int dep = 0;

        while (root != null) {
            dep++;
            root = root.left;
        }

        return dep;
    }

    private int rightDepth(TreeNode root) {

        int dep = 0;

        while (root != null) {
            dep++;
            root = root.right;
        }

        return dep;
    }
}