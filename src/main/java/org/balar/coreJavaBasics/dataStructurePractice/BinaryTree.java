package org.balar.coreJavaBasics.dataStructurePractice;

public class BinaryTree {
    BinaryTreeNode root;
    
    BinaryTree(int data) {
        root = new BinaryTreeNode(data);
    }
    
    void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        display(root);
        inOrder(root.right);
    }
    
    private void display(BinaryTreeNode root) {
        System.out.print(root.data + "-->");
    }
    
    void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        display(root);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        display(root);
        
    }
}
