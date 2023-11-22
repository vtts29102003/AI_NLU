package student;

import java.awt.geom.NoninvertibleTransformException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import lab6.Node;





public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{
	 
	@Override
	public Node execute(Node root, String goal) {
		//làm sao để nó chạy thêm một lần nữa ghi gọi phương thức. 
	
		double newPathCost = 0; // là quãng đường đến node a và có path cost gần hơn
		  Set<Node> visited = new HashSet<>(); // intili
		  PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1.getH(),o2.getH());
				}
			});
		// TODO Auto-generated method stub
		frontier.add(root); // thêm vào trong frontier.
		while(!frontier.isEmpty()) {  
			Node current = frontier.poll(); //node current là node được chọn và đã so sánh
			if(current.getLabel().equals(goal)) { // nếu node này là điểm dích thì sẽ dừng lại và in ra
				  List<String> out = NodeUtils.printPath(current);
	                System.out.println("GreedyBestFrist: " + out);
	                System.out.println("Chi phí đường đi: "  + current.getH());
				return current;
			}
			else { // Còn nếu Node này không phải là đích thì nó sẽ tiếp tục duyệt các node con của nó 
				visited.add(current);
				List<Edge> edge = current.getChildren(); // lấy ra danh sách các cạnh cùng với node
				for (Edge e : edge) { //
					Node n = e.getEnd(); // sau đó lấy ra các node sau cạnh đó vậy ta đã lấy được các node con của nó.
					 newPathCost = current.getLabel().equals(root.getLabel()) ?   n.getH():  + n.getH() + current.getH(); 
					if(!visited.contains(n) && !frontier.contains(n)) { //kiểm tra cái node con này có nằm trong visited không nếu có thì sẽ không chạy
						frontier.add(n);
						n.setParent(current); // lưu dấu đường đi cho nó
						n.setH(newPathCost); 
					}
					else if(frontier.contains(n) && newPathCost < n.getH() ) {
					     // Nếu đã tồn tại trong frontier và có chi phí mới thấp hơn, cập nhật chi phí
                        frontier.remove(n);  // Loại bỏ phiên bản cũ
                        n.setH(newPathCost);
                        n.setParent(current);
                        frontier.add(n);  // Thêm phiên bản mới với chi phí cập nhật
					}
				}
			}
		}
		return null;	
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if(root.getLabel().equals(start)) this.execute(root, goal);
		for (Node r : root.getChildrenNodes()) {
			if(r.getLabel().equals(start)) {this.execute(r, goal);}
			else { this.execute(r, start,goal);}
		}

        // Goal not found
        return null;}
	}


