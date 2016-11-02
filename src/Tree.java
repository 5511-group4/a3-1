
import java.util.*;


/*
 * questions:
 * can nodes duplicate? assume that the nodes could be duplicated
 * 
 * */
/**
 * BSTTree
 *1.insertion
 *2. Level traversal 
 */
public class Tree {
	public Tree()
	{		
	}	
	public Tree(Node node)
	{		
		this.Root = node;
	}
	
	
	private Node  Root = null;	

	
	/**
	 * Insert the node to the tree
	 * 1.find the right place for the new node
	 * 2.update the reference for the node
	 * 3.attach the node to the tree
	 * @param node: the node needs to be inserted
	 */
	public void Insert( Node node)
	{
		boolean hasInsert = false;
		int i = node.Data;
		//1.if the node is null, return;
		if(node == null)
			return;
		//2.if the root is null, make the rout
		else if(Root == null)
		{
			Root = node;
			hasInsert = true;
		}
		else
		{
			//3.find the right place to insert the node
			//compare the node from Root
			Node current ;
			int temp = 0;
			Queue<Node> nodes = new LinkedList<Node>();
			nodes.add(Root);
			
			do{
				current = nodes.poll();

				//3.0 if the current note <  note,swap the data in the node
				if(current.Data < node.Data )
				{
					temp = current.Data; 
					current.Data = node.Data ;
					node.Data = temp;					
				}
				
				//3.1 if the current note is not full, add to current
				if(current.Left == null)
				{
					current.Left = node;
					node.Parent = current;
					current.IsInternal = true;
					hasInsert = true;

				}
				//3.2 if the current note is not full, add to current
				else if(current.Right == null)
				{
					current.Right = node;
					node.Parent = current;
					current.IsInternal = true;
					hasInsert = true;
				}
				//3.3 if the current note is full, push the both children to quene,
				else
				{
					nodes.add(current.Left);
					nodes.add(current.Right);
				}
			}while(nodes.peek() != null && hasInsert == false);
		}
		
		if(hasInsert)
			System.out.println("New Node inserted, its value is:" + i);
		else
			System.out.println("not been inserted,its value is:" + i);
			
		
	}
	
	
	//Traversal the tree in level from the root to the leaf(up to down)
	public void LevelTraversal()
	{
		//check the root
		if(Root ==null)
		{
			System.out.println("the root of the tree is null");
			return;
		}
		
		
		Node current ;
		Queue<Node> nodes = new LinkedList<Node>();
		//push the root into the Queue
		nodes.add(Root);
		
		//visit and output the node in the loop
		do{
			current = nodes.poll();
						
			if(current.IsInternal == false)
				System.out.println(current.Data + "*");
			else
				System.out.println(current.Data);
				
			
			if(current.Left != null)
			{
				nodes.add(current.Left);
			}
			//if the current note is not full, add to current
			if(current.Right != null)
			{
				nodes.add(current.Right);
			}

		}while(nodes.peek() != null);	
	}
	
	//Combine the both 2 trees
	//1.set the tree who has bigger root as the main tree, put the other into treeTmp
	//2. than always compare the root of treeTmp to the current node from main tree
	// the logic is similar with the <insert>
	public static Tree Combine( Tree t1, Tree t2)
	{
		Tree tree = null;
		Tree treeTmp = null;
		Boolean hasFinish = false;
		
		//1. if all the trees are null
		if(( t1 == null || t1.Root == null) 
				&& (t2 == null || t2.Root == null) )
			return tree;
		//2. if one of the tree is null
		else if(t2 != null && t2.Root != null && (t1 == null || t1.Root == null))			
			return t2;
		else if(t1 != null && t1.Root != null && (t2 == null || t2.Root == null))
			return t1;
		//3.if no trees are null
		else
		{
			//3.1 setup the tree which has bigger root  as main tree
			if(t1.Root.Data >= t2.Root.Data)
			{
				tree = t1;
				treeTmp = t2;
			}
			else
			{
				tree = t2;
				treeTmp = t1;
			}
			Queue<Node> nodes = new LinkedList<Node>();
			Node current = null;
			Node treeTmpHead = null;
			Node nodeTmp = null;
			//push the root into the Queue
			nodes.add(tree.Root);
			
			do{
				current = nodes.poll();
				treeTmpHead = treeTmp.Root;

				//3.2 if treeTmpHead is bigger than current node,swap the node object with current node object.
				//it means the 2 nodes will be swap with corresponding children
				if(current.Data < treeTmpHead.Data)
				{					
					
					if(current.Parent.Left == current)
						current.Parent.Left = treeTmpHead;
					else
						current.Parent.Right = treeTmpHead;
					
					treeTmpHead.Parent = current.Parent;
					
					//swap
					nodeTmp = current;
					current = treeTmpHead;					
					treeTmpHead = nodeTmp;					
					
				}
				//3.3.1 if one child is null
				else if(current.Left == null)
				{
					current.Left = treeTmpHead;
					treeTmpHead.Parent = current;
					hasFinish = true;
				}
				//3.3.2 if the current note is not full, add to current
				else if(current.Right == null)
				{
					current.Right = treeTmpHead;
					treeTmpHead.Parent = current;
					hasFinish = true;
				}
				//3.3.3 add the children to the queue
				else
				{
					nodes.add(current.Left);
					nodes.add(current.Right);
				}

			}while(nodes.peek() != null && hasFinish == false);				
			
		}			
		
		
		return tree;
	}
	
	
	
}
