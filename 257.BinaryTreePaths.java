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
    public List<String> binaryTreePaths(TreeNode root) {
        /*
            Approach : 
            Call the function recursively for the left subtree and gather the path until we reach a null.
            Do the same for the right subTree and gather the path.
            After getting the result add it into the main answer.
        */
        List<String> ans = new ArrayList<>();
        if(root==null) return ans;
        if(root.left==null&&root.right==null){
            ans.add(root.val+"");
            return ans;
        }
        //Getting the left and the right answer
        List<String> leftAns = binaryTreePaths(root.left);
        List<String> rightAns = binaryTreePaths(root.right);

        for(String str : leftAns){
            ans.add(root.val+"->"+str);
        }
        for(String str : rightAns){
            ans.add(root.val+"->"+str);
        }
        return ans;
    }
}
