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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
          Approach : 
          TC : O(N)
          SC : O(N)
          Handle the edge case of having root as null.
            1.Make two ArrayLists one to store the curAns and one to store overall main answer.
            2.Make two Stack a main stack which stores the nodes of the current level and a helper stack that stores the nodes of the next level.
            3.Use a level pointer or a variable to maintain which direction traversal has to be done, left->right or right->left, or in which direction we have to insert elements in the helper stack.
            4.If the main is empty then the current levels traversal has been completed, insert the current answer into the main answer then refresh the current answer, after it refresh the level and then refresh the helper stack after swaping it with the main stack.
            5.Continue this until we have a empty stack even after swapping with the helper stack.

        */
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curAns = new ArrayList<>();

        //Edge case 
        if(root==null) return ans;
        Stack<TreeNode> main = new Stack<>();
        Stack<TreeNode> helper = new Stack<>();
        main.push(root);
        int level=0;
        while(main.size()!=0){
            TreeNode t = main.pop();
            curAns.add(t.val);

            if(level==0){
                //left then right
                if(t.left!=null) helper.push(t.left);
                if(t.right!=null) helper.push(t.right);
            }
            if(level==1){
                //Right then left
                if(t.right!=null) helper.push(t.right);
                if(t.left!=null) helper.push(t.left);
            }
            if(main.size()==0){
                ans.add(curAns);
                curAns = new ArrayList<>();
                level=1-level;
                main=helper;
                helper=new Stack<>();
            }
        }
        return ans;
    }
}
