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
    public TreeNode sortedArrayToBST(int[] nums) {
        /* 
            Note : If we will start inserting in the BST from the first element in the array then it will lead to a skewed tree.
            
            Recursive Approach ->
            For the array simply make a start and end to find a mid element, make a Node of the value at mid as the root.
            Now for this root we need to find the left and right child, for that recusively call the same function for:
                left child => low=0 and high=mid-1
                right child=> low=mid+1 and high=nums.length-1

        */

        return createBST(nums,0,nums.length-1);
    }
    public TreeNode createBST(int[] nums, int low, int high){
        if(low>high){
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left = createBST(nums,low,mid-1);
        root.right = createBST(nums,mid+1,high);
        return root;
    }
}
