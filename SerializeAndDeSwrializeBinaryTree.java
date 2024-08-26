import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeSwrializeBinaryTree {

     //Definition for a binary tree node.
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
      }

    /**
     Serialize
     Time - o(n)
     Space o(n)

     De-Serialize
     TIme -o(n)
     space -o(n)


     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            q.add(root);
            // bfs
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                // check if polled element is null if not append to string
                if (curr != null) {
                    sb.append(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                } else {
                    sb.append("null");
                }
                sb.append(',');
                System.out.println(sb);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            // convert string into array
            String[] strArray = data.split(",");
            Queue<TreeNode> q = new LinkedList<>();
            // pull the first element and create Node.
            TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
            q.add(root);
            int i = 1;
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                // if string array ith elemnt is not null create another node.
                if (!strArray[i].equals("null")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(strArray[i]));
                    // assign it to current left.
                    curr.left = leftNode;
                    // add it to the q.
                    q.add(leftNode);

                }
                i++;
                if (!strArray[i].equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(strArray[i]));
                    curr.right = rightNode;
                    // Add it to the q.
                    q.add(rightNode);

                }
                i++;
            }
            return root;

        }
    }

}
