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
    // Method Convert tree into preorder string
    public String preorderTraversal(TreeNode node){
        if(node == null){
            return null;
        }
        // StringBuilder stores the preorder sequence
        StringBuilder sb = new StringBuilder("^");
        // Add current node with a unique prefix
        sb.append(node.val);

        // Visit left subtree
        sb.append(preorderTraversal(node.left));
        // Visit right subtree
        sb.append(preorderTraversal(node.right));

        return sb.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Serialize both trees
        String fullTree = preorderTraversal(root);
        String subTree = preorderTraversal(subRoot);

        // Check subTree exists inside fullTree
        return fullTree.contains(subTree);
    }
}