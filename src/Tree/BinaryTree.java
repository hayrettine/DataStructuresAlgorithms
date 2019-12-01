package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
        TreeNode(int value){
            this.value = value;
        }
    }

    public static void levelOrderTraversal(TreeNode start){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.value + " ");
            if(temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    public static void spiralOrderTraversal(TreeNode start){
        Stack<TreeNode> evenQueue = new Stack<>();
        Stack<TreeNode> oddQueue = new Stack<>();
        evenQueue.add(start);
        boolean even = true;
        while(even && !evenQueue.isEmpty() || !oddQueue.isEmpty()){
            if (even) {
                while (!evenQueue.isEmpty()) {
                    TreeNode temp = evenQueue.pop();
                    System.out.print(temp.value + " ");
                    if (temp.right != null)
                        oddQueue.add(temp.right);
                    if (temp.left != null)
                        oddQueue.add(temp.left);
                }
            }else {
                while (!oddQueue.isEmpty()) {
                    TreeNode temp = oddQueue.pop();
                    System.out.print(temp.value + " ");
                    if (temp.left != null)
                        evenQueue.add(temp.left);
                    if (temp.right != null)
                        evenQueue.add(temp.right);
                }
            }
                even = !even;
            }
        }

        static void leaf(TreeNode start){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(start);
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null)
                    System.out.print(temp.value + " ");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }

        static void allPaths(TreeNode start, int[] path, int index){
            if (start == null)
                return;
            path[index] = start.value;
            index++;

            if (start.left == null && start.right == null){
                printPath(path, index);
                return;
            }
            allPaths(start.left, path, index);
            allPaths(start.right, path, index);
        }

        static void printPath(int[] arr, int len){
        for (int i = 0; i < len; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        }

        static void findLevel(TreeNode root, int val, int level){
        if (root == null)
            return;

        if (root.value == val){
            System.out.println(level);
            return;
        }
        findLevel(root.right, val, level + 1);
        findLevel(root.left, val, level + 1);
        }
        static int maxOfTree(TreeNode start){
        if (start.right == null)
            return start.value;
        return maxOfTree(start.right);
        }

        static TreeNode lca(TreeNode start, int a, int b){
        if (start == null)
            return null;
        if (start.value == a || start.value == b)
            return start;

        TreeNode left = lca(start.left, a, b);
        TreeNode right = lca(start.right, a, b);

        if (left != null && right != null)
            return start;
        if (left == null)
            return right;
        else
            return left;
        }

    public static void main(String[] args) {

        TreeNode treeNode = createTree();
        levelOrderTraversal(treeNode);
        System.out.println();
        spiralOrderTraversal(treeNode);
        System.out.println();
        leaf(treeNode);
        System.out.println();
        System.out.println("All paths: ");
        allPaths(treeNode, new int[10000], 0);
        System.out.println();
        findLevel(treeNode, 10, 1);
        System.out.println(maxOfTree(treeNode));
        System.out.println();
        System.out.println(lca(treeNode, 45, 70).value);
    }

    static TreeNode createTree(){
        TreeNode root = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);
        TreeNode node45 = new TreeNode(45);
        TreeNode node65 = new TreeNode(65);

        root.left = node20;
        root.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        node50.left = node45;

        node70.left = node65;

        return root;
    }
}
