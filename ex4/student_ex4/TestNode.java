package student_ex4;

import java.util.Arrays;
import java.util.List;



public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\Eclipse\\eclipse-workspace\\AI\\ex4\\PuzzleMap.txt", "D:\\Eclipse\\eclipse-workspace\\AI\\ex4\\PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
	//	Node tmp = new Node(initialState);
	//	System.out.println(initialState.equals(tmp));
		Node goalState = p.getGoalState();
		System.out.println("InitialState \n" + initialState);
		System.out.println("Init H : "+initialState.getH() + "\n");
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
		System.out.println("GoalState \n" + goalState);
		Node re = p.moveWhiteTile(initialState, 'r');
//
		System.out.println("Move \n"  + re);
		System.out.println(re.getH() + "\n");
		
	
		//System.out.println(initialState);
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

		 //System.out.println(p.getInitialState());
		// System.out.println(p.getGoalState());
		
		 List<Node> children = p.getSuccessors(initialState);
	//	 System.out.println("Size: "+children.size());
		// for (Node child : children) {
		//System.out.println(child.getH()+" "+p.computeH(child) );
		// }
	}
}
