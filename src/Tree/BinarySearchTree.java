package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private int value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int value){
        this.value = value;
    }

    public void insert(BinarySearchTree root, BinarySearchTree node){
        if (root == null)
            root = node;
        if (root.value == node.value)
            System.out.println("Node exist!");
        if (root.value > node.value){
            if (root.left == null)
                root.left = node;
            else
                insert(root.left, node);
        }else{
            if (root.right == null)
                root.right = node;
            else
                insert(root.right, node);
        }
    }

    public boolean find(BinarySearchTree root, BinarySearchTree node){
        if (root == null)
            return false;
        if (root.value == node.value)
            return true;
        boolean result = false;
        if (root.value > node.value)
            result = find(root.left, node);
        else
            result = find(root.right, node);
        return result;
    }

    public BinarySearchTree delete(BinarySearchTree root, int val){
        if (root == null)
            return null;
        if (root.value > val)
            root.left = delete(root.left, val);
        else if (root.value < val)
            root.right = delete(root.right, val);
        else{
            if (root.left != null && root.right != null){
                BinarySearchTree temp = root;
                BinarySearchTree minRight = minimum(temp.right);
                root.value = minRight.value;
                delete(root.right, minRight.value);
            }
            else if (root.left != null)
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = null;
        }
        return root;
    }

    public BinarySearchTree lca(BinarySearchTree root, int a, int b){
        if (root == null)
            return null;

        if (root.value > a && root.value > b)
            return lca(root.left, a, b);
        else if (root.value < a && root.value < b)
            return lca(root.right, a, b);

        System.out.println(root.value);
        return root;
    }
    public BinarySearchTree buildBalanced(int[] arr, int right, int left){
        if (right > left)
            return null;
        int mid = (right + left) / 2;
        BinarySearchTree root = new BinarySearchTree(arr[mid]);
        root.left = buildBalanced(arr, right, mid - 1);
        root.right = buildBalanced(arr, mid + 1, left);
        return root;
    }

    public void printınOrder(BinarySearchTree root){
        if(root == null)
            return;
        printınOrder(root.left);
        System.out.print(root.value + " ");
        printınOrder(root.right);
    }

    public boolean isBST(BinarySearchTree root, int min, int max){
        if (root == null)
            return true;

        return (root.value > min &&
                root.value < max &&
                isBST(root.left, min, root.value) &&
                isBST(root.right, root.value, max));
    }

    public BinarySearchTree minimum(BinarySearchTree root){
        if (root.left == null)
            return root;
        else
            return minimum(root.left);
    }

    public void printTree(BinarySearchTree root){
        Queue<BinarySearchTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinarySearchTree temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    public int depth(BinarySearchTree root){
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
