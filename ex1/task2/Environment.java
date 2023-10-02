package task2;

import java.awt.Event;
import java.util.Random;

import javax.tools.DocumentationTool.Location;
// nếu ô hiện tại đang dơ, sẽ invoked suck
// nếu ô hiện tại đang sạch, sẽ di chuyển random up, down, left,right.
// môi trường này bao gồm trạng thái hiện tại của vị trí 
// TÍNH HIỆU SUẤT:
// cho hành động suck thì một lần suck được 500 points
// nếu agent không thể di chuyển -100 điểm
// cho các hành động khác: -10 điểm mỗi hành động
public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A"; //vị trí a và vị trí b và c,d
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";
	//trạng thái của vị trí, nếu nó dơ thì nó sẽ excute, còn nếu nó sạch nó sẽ dynamic ation
	public enum LocationState {
		CLEAN, DIRTY
	}
	private int score = 0;
	private EnvironmentState envState;
	private boolean isDone = false;// maybe dirty
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState,Environment.LocationState locCState,Environment.LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState,locCState,locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		//action 1
		if(action.equals(SUCK_DIRT)) {
			this.score +=500;
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		}
		//action 2
		else {
			if(action.equals(MOVE_UP)) {
				switch (envState.getAgentLocation()) {
		    case LOCATION_C:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_B);
		        break;
		    case LOCATION_D:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_A);
		        break;
		    case LOCATION_A:
		    case LOCATION_B:
		        this.score -= 100;
		        break;
		}}
			else if(action.equals(MOVE_RIGHT)) {
				switch (envState.getAgentLocation()) {
		    case LOCATION_A:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_B);
		        break;
		    case LOCATION_D:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_C);
		        break;
		    case LOCATION_C:
		    case LOCATION_B:
		        this.score -= 100;
		        break;	
		}}
			else if(action.equals(MOVE_DOWN)) {
				switch (envState.getAgentLocation()) {
		    case LOCATION_A:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_D);
		        break;
		    case LOCATION_B:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_C);
		        break;
		    case LOCATION_C:
		    case LOCATION_D:
		        this.score -= 100;
		        break;
		}}
			else if(action.equals(MOVE_LEFT)) {
				switch (envState.getAgentLocation()) {
		    case LOCATION_B:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_A);
		        break;
		    case LOCATION_C:
		        this.score -= 10;
		        envState.setAgentLocation(LOCATION_D);
		        break;
		    case LOCATION_A:
		    case LOCATION_D:
		        this.score -= 100;
		        break;}}
		}
		return envState; 
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		return new Percept(envState.getAgentLocation(),envState.getLocationState(envState.getAgentLocation()));
	}

	public void step() {
		envState.display();
		System.out.println(this.score);
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);
		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
			 if    (es.getLocationState(LOCATION_A) == LocationState.CLEAN
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN)) 
			isDone = true;// if both squares are clean, then agent do not need to do any action
			es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {	
			step();
			System.out.println("-------------------------");
		}
		System.out.println("Score: " + this.score);	
	}

	public void stepUntilDone() {
		int i = 0;
		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
