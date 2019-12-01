package Tree;

public class TreeApp {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(40);
        BinarySearchTree tree20 = new BinarySearchTree(20);
        BinarySearchTree tree10 = new BinarySearchTree(10);
        BinarySearchTree tree30 = new BinarySearchTree(30);
        BinarySearchTree tree50 = new BinarySearchTree(50);
        BinarySearchTree tree60 = new BinarySearchTree(60);
        BinarySearchTree tree45 = new BinarySearchTree(45);
        BinarySearchTree tree5 = new BinarySearchTree(5);
        BinarySearchTree tree15 = new BinarySearchTree(15);
        BinarySearchTree tree31 = new BinarySearchTree(31);
        BinarySearchTree tree32 = new BinarySearchTree(32);
        BinarySearchTree tree33 = new BinarySearchTree(33);
        tree.insert(tree, tree20);
        tree.insert(tree, tree10);
        tree.insert(tree, tree30);
        tree.insert(tree, tree50);
        tree.insert(tree, tree60);
        tree.insert(tree, tree45);
        tree.insert(tree, tree5);
        tree.insert(tree, tree15);
        tree.insert(tree, tree31);
        tree.insert(tree, tree32);
        tree.insert(tree, tree33);
        tree.printTree(tree);
        System.out.println();
        System.out.println(tree.find(tree, tree20));
        //tree.delete(tree, 50);
        tree.printTree(tree);
        System.out.println();
        tree.lca(tree, 10, 60);
        tree.lca(tree, 10, 30);
        tree.lca(tree, 5, 33);
        tree.printınOrder(tree);
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        BinarySearchTree balancedTree = tree.buildBalanced(array,0, 8);
        System.out.println();
        balancedTree.printTree(balancedTree);
        System.out.println();
        balancedTree.printınOrder(balancedTree);
        System.out.println(balancedTree.isBST(balancedTree, 0, 99999));
        System.out.println(sum(1000));
        System.out.println(factorial(5));
        System.out.println(fibo(6));
        System.out.println(powerOfTen(5));
        System.out.println(decimalToBinary(10));
        System.out.println(balancedTree.depth(balancedTree));
    }

    static int sum(int x){
        if (x == 0)
            return 0;
        return x + sum(x - 1);
    }

    static int factorial(int x){
        if (x < 2)
            return 1;
        return x * factorial(x - 1);
    }

    static int fibo(int x){
        if (x < 1)
            return 1;

        if (x < 2)
            return 1;
        return fibo(x - 1) + fibo(x - 2);
    }
    static int powerOfTen(int x){
        if (x == 0)
            return 1;
        return 10 * powerOfTen(x - 1);
    }

    static String decimalToBinary(int x){
        if (x < 2)
            return String.valueOf(x);
        return decimalToBinary(x/2) + (x % 2);
    }
}
