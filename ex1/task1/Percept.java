package task1 ; 
/**
 * percept sự cảm nhận gồm vị trí hiện tại của agent và trạng thái môi trường mà agent đang đứng
 * @author uyent
 *
 */
public class Percept {
	private String agentLocation;// vị trí của agent
	private Environment.LocationState state; //trạng thái môi trường của angent hiện tại

	public Percept(String agentLocation, Environment.LocationState state) {
		this.agentLocation = agentLocation;
		this.state = state;
	}

	public Environment.LocationState getLocationState() {
		return this.state;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}
}