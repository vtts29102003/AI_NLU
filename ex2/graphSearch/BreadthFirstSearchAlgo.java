package graphSearch;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo{
	  Set<Node> visited = new HashSet<>();
      Queue<Node> queue = new LinkedList<>();
      boolean visitedUsed = false;
	@Override
	public Node execute(Node root, String goal) {
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            // Assuming getLabel() returns a unique identifier for the node
            if (current.getLabel().equals(goal)) {
                // Found the goal, track the path
                List<String> path = NodeUtils.printPath(current);
                System.out.println("BFS Path: " + path);
                return current;
            }

            for (Node node : current.getChildrenNodes()) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    node.setParent(current); // Track the parent
                    queue.add(node);
                }
            }
        }
        // Goal not found
        return null;
    }


	@Override
	public Node execute(Node root,String start, String goal) {
		if(root.getLabel().equals(start)) this.execute(root, goal);
		for (Node r : root.getChildrenNodes()) {
			if(r.getLabel().equals(start)) {this.execute(r,goal);}
			else {this.execute(r, start,goal);}
			}
		
				return null; // không tìm thấy start trong root
			}
	}
			
		
	

