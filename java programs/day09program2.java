//day9program2
// Balbir Singh is working with Binary Trees.
// The elements of the tree are given in level-order format.

// Balbir is observing the tree from the right side, meaning he
// can only see the rightmost nodes (one node per level).

// You are given the root of a binary tree. Your task is to determine
// the nodes visible from the right side and return them in top-to-bottom order.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// A list of integers representing the node values visible from the right side

// Sample Input-1:
// ---------------
// 1 2 3 4 -1 -1 5

// Sample Output-1:
// ----------------
// [1, 3, 5]

// Sample Input-2:
// ---------------
// 3 1 4 5 2

// Sample Output-2:
// ----------------
// [3, 4, 2]

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

public class day09program2 {
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

    public static List<Integer> right_view(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode flag = null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                flag = curr;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            res.add(flag.data);
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
        System.out.println(right_view(root));
    }
}