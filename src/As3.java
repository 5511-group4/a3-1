

public class As3 {
	public static void main(String[] args){
		//Build the tree
		Tree t1  = new  Tree();
		Tree t2  = new  Tree();
		Tree t  = new  Tree();
		System.out.println("0. prepare the data");
		System.out.println("0.1 insert data into t1.....");
		t1.Insert(new Node(9));		
		t1.Insert(new Node(1));
		t1.Insert(new Node(6));	
		t1.Insert(new Node(3));		

		t1.Insert(new Node(5));
		t1.Insert(new Node(11));
			
		t1.Insert(new Node(7));
		t1.Insert(new Node(8));		

		t1.Insert(new Node(10));		
		
		t1.Insert(new Node(12));
		t1.Insert(new Node(2));
		t1.Insert(new Node(13));
		t1.Insert(new Node(4));

		System.out.println("0.2 insert data into t2 .....");	
			
		t2.Insert(new Node(1));
		t2.Insert(new Node(2));
		t2.Insert(new Node(3));		
		t2.Insert(new Node(4));
		t2.Insert(new Node(5));
		t2.Insert(new Node(6));			
		t2.Insert(new Node(7));
		t2.Insert(new Node(8));		
		t2.Insert(new Node(9));	
		t2.Insert(new Node(10));		
		t2.Insert(new Node(11));
		t2.Insert(new Node(12));	
		t2.Insert(new Node(13));
		
		
		
		System.out.println("1. level Traversal");
		System.out.println("the nodes with * are external nodes, others are internal nodes.");
		
		System.out.println("1.1 level Traversal  t1 £¬.....");
		t1.LevelTraversal();
		
		//TraversalInOrderRL
		System.out.println("1.2 level Traversal  t2 .....");
		t2.LevelTraversal();
		
		
		System.out.println("according to the output above, all the nodes which value greater than 7 are the internal nodes.");
		System.out.println("1. level Traversal  t .....");
		t = Tree.Combine(t1, t2);
		t.LevelTraversal();
		System.out.println("according to the output above, all the nodes which value greater than 7 are the internal nodes.");
		//test3
	   }
}
