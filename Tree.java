package edu.olemiss.csci211;

import java.util.Iterator;


/**  A General Tree class. This class is well suited for bottom-up construction of trees. It only 
 * supports adding child nodes and subtrees to the root node of this tree, but that allows for
 * arbitrarily complex trees to be built. We can just build the subtrees first, and then add them to 
 * the parent node.
 * 
 * @author rhodes, Sean Staz
 *
 * @param <T>
 */

//Sean Staz
//CSci 211
//12-02-13

public class Tree<T> implements Iterable<T>
{
	protected class Node
	{
		T data; 
		UnorderedList<Node> children = new SinglyLinkedList<Node>();
	}
	
	Node root;
	
	/**
	 * Create an empty tree.
	 */
	public Tree()
	{
		root = new Node();
	}

	/** Create a tree with the given element contained by the root node.
	 * 
	 * @param element
	 */
	public Tree(T element)
	{
		root = new Node();
		root.data = element;
	}
	

	/** Add a new node containing the given element as a child of the root node of this
	 * tree.
	 * 
	 * @param element value to be added.
	 */
	public void addLeaf(T element)
	{
		Node n = new Node();
		n.data=element;
		
		root.children.addToRear(n);
	}

	/** Add the root node of the given tree as a child of the root node of this tree. The 
	 * argument tree becomes a subtree of this tree.
	 * 
	 * @param tree the tree to be added.
	 */
	public void addSubtree(Tree<T> tree)
	{
		root.children.addToRear(tree.root);
	}

	/** Given a target to find in the tree, this method finds all occurrences of the target in the tree, and
	 * returns a list containing the paths leading from the root to each occurrence of the target. Each path 
	 * is represented as a string that concatenates the nodes, using the specified separator between nodes.
	 * For example, 
	 * /flim/flam/foo 
	 * /flim/bam/boom/foo
	 *
	 * @param target
	 * @param separator
	 * @return
	 */
	public List<String> locate(T target, String separator)
	{
		//Write me. 85% A helper method would be useful.
		
		return null;
	}
	
	/** Print a representation of the tree to standard output. Each node is printed on a separate line, and
	 * each level of the tree is indented by four spaces from the previous level.
	 * 
	 */
	public void print() 
	{	
		//Write me. 75%
		
		printHelper(root, "    ");
	}
	
	public String printHelper(Node n, String Space) 
	{
		System.out.print(Space);
		System.out.println(n.data);
		
		for(Node node: n.children)
		{
			printHelper(node, Space + "    "); 
		} 
	
		return null; 
	}
	
	/** Print a string representation of the tree. The entire tree is represented in a single line of text, and
	 * square brackets are used to indicate nesting of subtrees.
	 */
	public String toString()
	{
		return toStringHelper(root);
	}
	
	protected String toStringHelper(Node n)
	{
		String r = "[" + n.data;
		
		for(Node node:n.children)
		{			
			r = r + toStringHelper(node);
		}

		return r+"]";
	}
	
	/**  
	 * Return a preorder iterator for this tree.
	 */
	public Iterator<T> iterator() 
	{		
		return preOrder();
	}

	/**  
	 * Return a preorder iterator for this tree.
	 */	
	public Iterator<T> preOrder()
	{
		//Write me. 100%
		
		return null;
	}
}
