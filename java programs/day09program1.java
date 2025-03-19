// A security team is setting up surveillance cameras in a multi-floor building.
// Each floor has a certain number of cameras, and every camera is assigned
// a resolution value (in megapixels). The placement follows a hierarchical
// structure, similar to a tree:
// - Floor 0 (Ground Floor) has a single main camera (root camera).
// - From the next floor onward, each camera can have at most two sub-cameras,
// one on the left side and one on the right side.
// - If a camera does not have a sub-camera at a position, it is represented as
// -1.

// The goal is to identify the camera with the highest resolution on each floor
// to
// ensure optimal security coverage.

// Input Format:
// -------------
// A single line of space separated integers, the resolution values of cameras

// Output Format:
// --------------
// A list of integers, where eech integer represents the maximum resolution
// camera
// on that floor.

// Sample Input-1:
// ---------------
// 2 4 3 6 4 -1 9

// Sample Output-1:
// ----------------
// [2, 4, 9]

// Sample Input-2:
// ---------------
// 3 4 7 7 3 8 4

// Sample Output-2:
// ----------------
// [3, 4, 8]

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

public class day09program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        List<Integer> l1 = new ArrayList<>();
        for (String s : inp) {
            l1.add(Integer.parseInt(s));
        }
        TreeNode root = builtTree(l1);
        List<Integer> ans = MaxLev(root);
        System.out.println(ans);
        sc.close();
    }

    public static TreeNode builtTree(List<Integer> vals) {
        if (vals == null || vals.size() == 0 || vals.get(0) == -1)
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

    public static List<Integer> MaxLev(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.data);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            res.add(max);
        }
        return res;
    }

    
}