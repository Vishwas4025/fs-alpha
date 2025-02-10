
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class day8program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] charArr = s.split(" ");
        int[] nums = new int[charArr.length];
        for(int i=0; i<nums.length; i++) nums[i]=Integer.parseInt(charArr[i]);
        for(int i=0; i<nums.length; i++) System.out.print(nums[i]+" ");

        Node root0 = new Node(nums[0]);
        Node root1 = new Node(nums[0]);
        createTree(root0, nums);
        createTree(root1, nums);

    }

    public static void createTree(Node root, int[] nums){
        Node[] nodes = new Node[nums.length];
        nodes[0] = root;
        for(int i=1; i<nums.length; i++) nodes[i] = new Node(nums[i]);
        for(int i=0; i<nums.length; i++){
            
        }
    }
}