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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
            Approach : 
            1.Make two ArrayLists to keep the track of the overall answer and to keep the current answer of the level.
            2.Make two Queues a main and a helper queue.
            ->The Main Queue stores the element of the current level we need to traverse and insert in our current ArrayList.
            ->The Helper Queue stores the children of the node currently in the main queue.
            3.Keep inserting the nodes from the main queue to the current list and after this swap both the queues the main and the helper.

            Keep continuing until the main queue has elements:
                remove the node from the main and store it.
                add the value of current node in the cur list.
                add the children of node in helper queue if exists.
                when the main queue is empty :
                    add the cur list into ans
                    refresh cur list 
                    swap the helper into the main 
                    refresh the helper
        */
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> main = new ArrayDeque<>();
        Queue<TreeNode> helper = new ArrayDeque<>();

        main.add(root);

        while(main.size()>0){
            TreeNode t = main.remove();
            cur.add(t.val);
            if(t.left!=null) helper.add(t.left);
            if(t.right!=null) helper.add(t.right);   
            if(main.size()==0){
                ans.add(cur);
                cur = new ArrayList<>();
                main = helper;
                helper = new ArrayDeque<>();
            }
        }
        return ans;
    }
}
