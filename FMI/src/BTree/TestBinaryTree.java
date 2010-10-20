package BTree;

import java.io.*;

public class TestBinaryTree {
	
	public static void createTreeOfStrings(BinaryTree tree,String source)
															throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(source));
		for(int i = 1; i <= 10; i++)
			tree.add(in.readLine());
		
		in.close();
 	}
 	
 	public static void createTreeOfEntries(BinaryTree tree,String source)
 															throws IOException {
 		BufferedReader in = new BufferedReader(new FileReader(source));
 		
  		for(int i = 1; i <= 10; i++) {
  			String line = in.readLine();
			int index = line.indexOf('@');
			String word = line.substring(0,index);
			String digit = line.substring(index + 1);
			Entry m = new Entry(word);
			m.setValue(Integer.valueOf(digit));
   			tree.add(m);
   		}
   		
   		in.close();
 	}
 	
  	public static void test(BinaryTree tree,String target) throws IOException {
  		PrintWriter out;
  		out = new PrintWriter(new BufferedWriter(new FileWriter(target)));
  		
		out.println("     Testing...");
   		out.println("Height of the tree: " + tree.height());
			
		out.println("     Tree breadth-first traversal:");
      	java.util.Iterator it = tree.treeBreadthFirstIterator();
		BTreeBreadthFirstIterator itw = (BTreeBreadthFirstIterator)it;
		for(int i = 0; i < itw.numberOfLevels(); i++) {
			java.util.Iterator currentLevelIt = itw.getData(i).iterator();
			out.println("     Level #: " + i);
			while(currentLevelIt.hasNext())
				out.println(currentLevelIt.next());
		}
		
    	out.println("     Tree inorder traversal:");
    	it = tree.treeInorderIterator();
		while(it.hasNext())
			out.println(it.next());
			
		out.println("     Tree preorder traversal:");
		it = tree.treePreorderIterator();
		while(it.hasNext())
			out.println(it.next());

   		out.println("     Tree postorder traversal:");
		it = tree.treePostorderIterator();
		while(it.hasNext())
			out.println(it.next());
		
		out.println("Done!");
		out.close();
 	}

  	public static void main(String[] args) {
   		try {
   			String s = File.separator;
   			String source = System.getProperty("user.dir") + s + "testTreeData1.txt";
			System.out.println("Read text from the file " + source);
			
			String target = System.getProperty("user.dir") + s + "testTreeResult1.txt";
			System.out.println("Test and write results to the file " + target);			
    		BinaryTree tree = new BinaryTree();
    		createTreeOfStrings(tree,source);
			test(tree,target);
			System.out.println(tree.contains("Word10") ? "Yes" : "No");
			System.out.println(tree.contains("Word99") ? "Yes" : "No");
						
			source = System.getProperty("user.dir") + s + "testTreeData2.txt";
			System.out.println("Read text from the file " + source);		
   			target = System.getProperty("user.dir") + s + "testTreeResult2.txt";
			System.out.println("Test and write results to the file " + target);   			
    		tree = new BinaryTree();
    		createTreeOfEntries(tree,source);
			test(tree,target);
			
			source = System.getProperty("user.dir") + s + "testTreeData3.txt";
			System.out.println("Read text from the file " + source);
			target = System.getProperty("user.dir") + s + "testTreeResult3.txt";
			System.out.println("Test and write results to the file " + target);
    		tree = new BinaryTree();
    		createTreeOfEntries(tree,source);
			test(tree,target);

       }catch (IOException e) {}
  	}
}