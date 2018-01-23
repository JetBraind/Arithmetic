package tree;

import tree.binarytree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(15);
        tree.insert(20);
        tree.insert(5);
        tree.insert(10);
        tree.insert(14);
        tree.insert(9);
        tree.delete(15);
    }
}
