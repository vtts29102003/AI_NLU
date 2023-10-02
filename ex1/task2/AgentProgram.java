package task2;

import java.util.Random;

import task1.Environment.LocationState;

public class AgentProgram {
	public AgentProgram () {
		
	}
	/**
	 * excute dựa vào vị trí hiện tại và trạng thái của angent
	 * @param p
	 * @return
	 */
	public Action execute(Percept p) {// location, status
		Random r1 = new Random();
		if(p.getLocationState().equals(Environment.LocationState.DIRTY)) {
			 return Environment.SUCK_DIRT;
		}
		else if(p.getAgentLocation()!=null) {
			switch (r1.nextInt(3)) {
			case 0:
				return Environment.MOVE_UP;
			case 1:
				return Environment.MOVE_RIGHT;
			case 2:
				return Environment.MOVE_DOWN;
			case 3:
				return Environment.MOVE_LEFT;
		}}
		return NoOpAction.NO_OP;
	}
}