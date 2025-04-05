// /*
// Imagine you are a librarian organizing books on vertical shelves in a grand library. The books are currently scattered across a tree-like structure, where each book (node) has a position determined by its shelf number (column) and row number (level).

// Your task is to arrange the books on shelves so that:
// 1. Books are placed column by column from left to right.
// 2. Within the same column, books are arranged from top to bottom (i.e., by row).
// 3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

// Example 1:
// Input:
// 3 9 20 -1 -1 15 7
// Output: 
// [[9],[3,15],[20],[7]]

// Explanation:
//          3
//        /   \
//       9     20
//           /    \
//          15     7

// Shelf 1: [9]
// Shelf 2: [3, 15]
// Shelf 3: [20]
// Shelf 4: [7]

// Example 2:
// Input:
// 3 9 8 4 0 1 7
// Output: 
// [[4],[9],[3,0,1],[8],[7]]

// Explanation:
//           3
//        /     \
//       9       8
//     /   \   /   \
//    4     0 1     7

// Shelf 1: [4]
// Shelf 2: [9]
// Shelf 3: [3, 0, 1]
// Shelf 4: [8]
// Shelf 5: [7]

// Library Organization Rules:
// 1. Each column represents a shelf from left to right.
// 2. Books on the same shelf are arranged from top to bottom.
// 3. If books share the same position, they are arranged left to right in order of appearance.

// */


import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        left = null;
        right = null;
    }
}

public class day19program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] input = s.split(" ");
        int [] arr = new int[input.length];
        for(int i=0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        TreeNode root = buildTree(arr);
        List<List<Integer>> result = verticalTraversal(root);
        System.out.print(result);
    }
    
    public static TreeNode buildTree(int[] arr){
        int n = arr.length;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<n){
            TreeNode node = q.poll();
            if(arr[i] != -1){
                node.left = new TreeNode(arr[i]);
                q.add(node.left);
            }
            i++;
            if(i<n && arr[i] != -1 ){
                node.right = new TreeNode(arr[i]);
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
    
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        TreeMap<Integer,TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0,0, map);
        for(int col : map.keySet()){
            List<Integer> list = new ArrayList<>();
            for(int row : map.get(col).keySet()){
                List<Integer> al = map.get(col).get(row);
                for(int val : al){
                    list.add(val);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void traversal(TreeNode node, int row, int col,  TreeMap<Integer,TreeMap<Integer, List<Integer>>> map) {
        if(node==null){
            return;
        }
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new ArrayList<Integer>());
        map.get(col).get(row).add(node.val);
        traversal(node.left, row+1,col-1, map);
        traversal(node.right, row+1,col+1, map);
    }
}







