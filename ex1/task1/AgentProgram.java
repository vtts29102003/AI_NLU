package task1;

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
		if(p.getLocationState() == Environment.LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}
		else if(p.getAgentLocation() == Environment.LOCATION_A) {
			return Environment.MOVE_RIGHT;
		}
		else if(p.getAgentLocation() == Environment.LOCATION_B) {
			return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;
		
	}
}