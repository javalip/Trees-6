import java.util.Stack;

/**
 *
 * Time o(n) - but can say nodes between high and low with optimization
 * Spaceo(n) - ut can say nodes between high and low with optimization
 */

public class RangeSumOfBinaryTree {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        inorder(root, low, high);
        return sum;

    }

    private void inorder(TreeNode root, int l, int h) {
        // base
        if (root == null) {
            return;
        }
        // logic
        if (root.val > l) {
            inorder(root.left, l, h);

        }
        if (root.val >= l && root.val <= h) {
            sum = sum + root.val;
        }
        if (root.val < h) {
            inorder(root.right, l, h);
        }
    }
    // Also works for preorder
    private void preorder(TreeNode root, int l, int h) {
        // base
        if (root == null) {
            return;
        }
        if (root.val >= l && root.val <= h) {
            sum = sum + root.val;
        }
        // logic
        if (root.val > l) {
            preorder(root.left, l, h);

        }

        if (root.val < h) {
            preorder(root.right, l, h);
        }
    }
    // Iterative Solution
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum =0;
        Stack<TreeNode> s = new Stack<>();
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root =s.pop();
            if(root.val>=low && root.val<=high){
                sum=sum+root.val;
            }
            root = root.right;

        }
        return sum;
    }
}
