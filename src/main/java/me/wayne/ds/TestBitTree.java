package me.wayne.ds;

public class TestBitTree {

    public static void test() {
        BitTree bitTree = createBitTree();

        System.out.println("preOrder : ");
        Traverse.preOrder(bitTree);
        System.out.println();
        Traverse.nonRecursionPreOrder(bitTree);
        System.out.println();

        System.out.println("inOrder : ");
        Traverse.inOrder(bitTree);
        System.out.println();
        Traverse.nonRecursionInOrder(bitTree);
        System.out.println();

        System.out.println("postOrder : ");
        Traverse.postOrder(bitTree);
        System.out.println();
    }

    private static BitTree createBitTree() {
        BitTree tree = new BitTree();
        tree.value = 7;

        BitTree four = new BitTree();
        four.value = 4;
        tree.left = four;

        BitTree three = new BitTree();
        three.value = 3;
        four.left = three;

        BitTree five = new BitTree();
        five.value = 5;
        four.right = five;

        BitTree six = new BitTree();
        six.value = 6;
        five.right = six;

        BitTree ten = new BitTree();
        ten.value = 10;
        tree.right = ten;

        BitTree eight = new BitTree();
        eight.value = 8;
        ten.left = eight;

        BitTree eleven = new BitTree();
        eleven.value = 11;
        ten.right = eleven;

        BitTree night = new BitTree();
        night.value = 9;
        eight.right = night;

        return tree;
    }
}
