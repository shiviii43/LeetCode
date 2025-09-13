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
    public TreeNode balanceBST(TreeNode root) {
        /*
            Approach : 
            We are given a BST so the InOrder Traversal will be sorted.
            We know how to make a BST from a given sorted array and the BST made by this algorithm is always balanced.
            1.Make a Sorted Array of the elements of the Tree.
            2.Now that we have a sorted array start making a BST using it.
        */

        ArrayList<Integer> li = new ArrayList<>();
        inOrder(root,li);
        root = makeBST(li,0,li.size()-1);
        return root;
    }
    public void inOrder(TreeNode root, List<Integer> li){
        if(root==null) return;
        inOrder(root.left,li);
        li.add(root.val);
        inOrder(root.right,li);
    }
    public TreeNode makeBST(List<Integer> li, int low, int high){
        if(low>high) return null;
        int mid = low+(high-low)/2;
        TreeNode node = new TreeNode(li.get(mid));
        node.left = makeBST(li,low,mid-1);
        node.right = makeBST(li,mid+1,high);
        return node;
    }
}
