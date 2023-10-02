package task2; 

import java.util.HashMap;
import java.util.Map;

import task1.Environment.LocationState;
/**
 *  trạng thái môi trường
 * @author uyent
 *
 */
public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;  //tạo ra vị trí agentlocation hiện tại là null

	public EnvironmentState(Environment.LocationState locAState, Environment.LocationState locBState,Environment.LocationState locCState,Environment.LocationState locDState) {
		this.state.put(Environment.LOCATION_A, locAState);
		this.state.put(Environment.LOCATION_B, locBState);
		this.state.put(Environment.LOCATION_C, locCState);
		this.state.put(Environment.LOCATION_D, locDState);
	}

	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public task2.Environment.LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, task2.Environment.LocationState locationState) {
		this.state.put(location, locationState);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}