// In Marketing Job, each agent will mentor atmost two sub-agents. 
// At the end, all mentor agents and sub agents, will be treated as agents only.

// Now, you are given the sales data of two months as a tree, tree contains the 
// count of the items sold by each agent, few agents might join the job and 
// few might left the job.

// You are given the sales data as month-1 and month-2.
// Your task is to find get the combined report of two months data.

// Implement the class Solution:
//    1. public TreeNode combinedReport(TreeNode root1, TreeNode root2): 
//     returns the root node of the combined data.

// NOTE:
// 	- In the tree '-1', indicates no sales(null).

// Input Format:
// -------------
// Line-1: space separated integers, sales data of month-1
// Line-2: space separated integers, sales data of month-2

// Output Format:
// --------------
// Print list of integers, with combined sales data.


// Sample Input-1:
// ---------------
// 2 5 2 -1 -1 -1 4
// 1 2 3 4 5

// Sample Output-1:
// ----------------
// 3 7 5 4 5 4


// Sample Input-2:
// ---------------
// 1 2 3 4
// 1

// Sample Output-2:
// ----------------
// 2 2 3 4

import java.util.*;

class TreeNode {
    Integer val;
    TreeNode left, right;
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class day15program2{
    public TreeNode combinedReport(TreeNode root1, TreeNode root2){
        // Implement the logic
        if(root1==null && root2!=null){
            return root2;
        }
        else if(root1!=null && root2==null){
            return root1;
        }
        else if(root1==null && root2==null){
            return null; 
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = combinedReport(root1.left, root2.left);
        node.right = combinedReport(root1.right, root2.right);
        return node;
    }
    public List<Integer> levelOrder(TreeNode root){
        List<Integer> al = new ArrayList<>();
        if(root==null){
            return al;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            al.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return al;
    }
}