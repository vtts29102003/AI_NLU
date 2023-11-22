package student;

import lab6.Node;

public interface IInformedSearchAlgo {
	public Node execute(Node root, String goal);

	public Node execute(Node root, String start, String goal);

}
