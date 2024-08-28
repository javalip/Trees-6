import java.util.*;
/**
 * Level order traversal.
 * use two qs. one for tree node and one associated with col number for it.
 * everytime we go left subtract one from current col number.
 * everytime we go right add one to col number.
 * that way we keep same col number for all the elements that are vertically
 * aligned.
 * use hashmap to keep col number as key and all the nodes associated with that
 * col number as
 * values i na list.
 * at the end iterate through hashmap and create list of all values and return.
 * Time complexity o(n)
 * space complexity o(n) -
 */

public class VerticalOrderTraversal {
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        q.add(root);
        col.add(0);
        // start bfs
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int currCol = col.poll();
            min = Math.min(min, currCol);
            max = Math.max(max, currCol);
            if (!map.containsKey(currCol)) {
                map.put(currCol, new ArrayList<>());
            }
            map.get(currCol).add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
                col.add(currCol - 1);
            }
            if (curr.right != null) {
                q.add(curr.right);
                col.add(currCol + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            List<Integer> values = map.get(i);
            result.add(values);
        }
        return result;
    }
}
