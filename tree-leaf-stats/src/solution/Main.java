package solution;

import java.util.Random;

public class Main {
    public static void main(String[]args){

        System.out.println("Making full binary tree with 1023 random nodes:");
        BinaryTree testBinaryTree = new BinaryTree();
        int desiredNodes = 1023;
        int desiredLayers = (int)(Math.log(desiredNodes+1)/Math.log(2));
        testBinaryTree.insertEvenly(desiredLayers);

        int leafCount = testBinaryTree.leafCounter(testBinaryTree.root);
        int leafDepthSum = testBinaryTree.sumDepthsOfLeaves(testBinaryTree.root, 0);
        int leafDepthAve = testBinaryTree.sumDepthsOfLeaves(testBinaryTree.root, 0)
                / testBinaryTree.leafCounter(testBinaryTree.root);
        int leafMaxDepth = testBinaryTree.getMaxLeafDepth(testBinaryTree.root, 0);
        System.out.println("Leaf Count is " + leafCount);
        System.out.println("Depth sum of leaves is " + leafDepthSum);
        System.out.println("Average depth of leaves is " + leafDepthAve );
        System.out.println("The max depth was " + leafMaxDepth);

        System.out.println("\nMaking sorted binary tree with 1023 nodes: ");
        testBinaryTree = new BinaryTree();
        Random rand = new Random();
        int counter = 0;
        while(counter<1023){
            testBinaryTree.insertSortedNode(rand.nextDouble()*1000);
            counter++;
        }
        leafCount = testBinaryTree.leafCounter(testBinaryTree.root);
        leafDepthSum = testBinaryTree.sumDepthsOfLeaves(testBinaryTree.root, 0);
        leafDepthAve = testBinaryTree.sumDepthsOfLeaves(testBinaryTree.root, 0)
                / testBinaryTree.leafCounter(testBinaryTree.root);
        leafMaxDepth = testBinaryTree.getMaxLeafDepth(testBinaryTree.root, 0);
        System.out.println("Leaf Count is " + leafCount);
        System.out.println("Depth sum of leaves is " + leafDepthSum);
        System.out.println("Average depth of leaves is " + leafDepthAve );
        System.out.println("The max depth was " + leafMaxDepth);

    }
}
