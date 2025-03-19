//day9program3
// A software development company is designing a smart home automation
// system that uses sensor networks to monitor and control different devices
// in a house. The sensors are organized in a hierarchical structure, where each
// sensor node has a unique ID and can have up to two child nodes (left and
// right).

// The company wants to analyze the left-most sensors in the system to determine
// which ones are critical for detecting environmental changes. The hierarchy of
// the sensors is provided as a level-order input, where missing sensors are
// represented as -1.

// Your task is to build the sensor network as a binary tree and then determine
// the left-most sensor IDs at each level.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// A list of integers representing the left-most sensor IDs at each level

// Sample Input-1:
// ---------------
// 1 2 3 4 -1 -1 5

// Sample Output-1:
// ----------------
// [1, 2, 4]

// Sample Input-2:
// ---------------
// 3 2 4 1 5

// Sample Output-2:
// ----------------
// [3, 2, 1]


import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class day09program3 {
    public static TreeNode buildTree(List<Integer> vals) {
        if (vals == null || vals.isEmpty() || vals.get(0) == -1)
            return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (i < vals.size()) {
            TreeNode curr = q.poll();
            if (i < vals.size() && vals.get(i) != -1) {
                curr.left = new TreeNode(vals.get(i));
                q.add(curr.left);
            }
            i++;
            if (i < vals.size() && vals.get(i) != -1) {
                curr.right = new TreeNode(vals.get(i));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> left_view(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return null;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    res.add(curr.data);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        List<Integer> vals = new ArrayList<>();
        for (String s : input) {
            vals.add(Integer.parseInt(s));
        }
        TreeNode root = buildTree(vals);
        System.out.println(left_view(root));
    }
}