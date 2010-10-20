package BTree;

import java.io.*;

public class TestBinarySearchTreeNew {
	
  	public static void main(String[] args) {
   		try {
   			String s = File.separator;
   			String source = System.getProperty("user.dir") + s + "testTreeData1.txt";
			System.out.println("Read text from the file " + source);
			
			String target = System.getProperty("user.dir") + s + "testTreeResult1.txt";
			System.out.println("Test and write results to the file " + target);			
    		BinaryTree tree = new BinarySearchTree(new NaturalComparator());
    		TestBinaryTree.createTreeOfStrings(tree,source);
			TestBinaryTree.test(tree,target);
			
			source = System.getProperty("user.dir") + s + "testTreeData2.txt";
			System.out.println("Read text from the file " + source);
			
   			target = System.getProperty("user.dir") + s + "testTreeResult2.txt";
			System.out.println("Test and write results to the file " + target);   			
    		tree = new BinarySearchTree(new EntryComparator());
    		TestBinaryTree.createTreeOfEntries(tree,source);
    		TestBinaryTree.test(tree,target);
    		System.out.println("Tree" + tree);
    		
    		target = System.getProperty("user.dir") + s + "testTreeCopyResult2.txt";
			System.out.println("Test and write results to the file " + target);
			BinaryTree copy = (BinaryTree)tree.clone();
    		TestBinaryTree.test(copy,target);
    		System.out.println("Tree copy" + copy);
    	
			source = System.getProperty("user.dir") + s + "testTreeData3.txt";
			System.out.println("Read text from the file " + source);
			target = System.getProperty("user.dir") + s + "testTreeResult3.txt";
			System.out.println("Test and write results to the file " + target);
    		tree = new BinarySearchTree(new EntryComparator2());
    		TestBinaryTree.createTreeOfEntries(tree,source);
			TestBinaryTree.test(tree,target);

       }catch (IOException e) {}
  	}
}