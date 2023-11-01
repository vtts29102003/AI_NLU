package UniformSearch_graphsearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniFormSearch_garphsearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
        Set<Node> visited = new HashSet<>();
        frontier.add(root); // thêm root vào.
// vòng lặp cho đến khi nào frontier empty
        while (!frontier.isEmpty()) {
            Node current = frontier.poll(); //lấy ra current từ frontier
            if (current.getLabel().equals(goal)) {
                List<String> out = NodeUtils.printPath(current);
                System.out.println("UniFormSearch: " + out);
                System.out.println("Chi phí đường đi: " + current.getPathCost());
                return current; // nếu là đích thì return current
            } else {
                visited.add(current);
                List<Edge> children = current.getChildren(); // danh sách con của children
                for (Edge child : children) {
                    Node n = child.getEnd(); // lấy end trong cạnh đó ra
                    double newPathCost = current.getPathCost() + child.getWeight();

                    if (!visited.contains(n) && !frontier.contains(n)) { // nếu cái con không nằm trong visited
                        frontier.add(n); // thì thêm frontier vào, add lúc này theo cái là chi phí nhỏ hơn thì adsd
                        n.setPathCost(newPathCost); // setPathcost
                        n.setParent(current);
                    } else if (frontier.contains(n) && newPathCost < n.getPathCost()) {
                        // Nếu đã tồn tại trong frontier và có chi phí mới thấp hơn, cập nhật chi phí
                        frontier.remove(n);  // Loại bỏ phiên bản cũ
                        n.setPathCost(newPathCost);
                        n.setParent(current);
                        frontier.add(n);  // Thêm phiên bản mới với chi phí cập nhật
                    }
                }
            }
        }
        return null; // Không tìm thấy đường đi đến mục tiêu
    }


	@Override
	public Node execute(Node root, String start, String goal) {
		 // Tìm nút bắt đầu trong cây và thực hiện tìm kiếm từ nút đó đến mục tiêu
        Node startNode = findNode(root, start);
        if (startNode != null) {
            return execute(startNode, goal);
        } else {
            System.out.println("Không tìm thấy nút bắt đầu: " + start);
            return null;
        }
    }

    // Phương thức để tìm một nút với nhãn cụ thể trong cây
    private Node findNode(Node root, String label) {
        if (root == null || root.getLabel().equals(label)) {
            return root;
        }

        for (Node child : root.getChildrenNodes()) {
            Node found = findNode(child, label);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
