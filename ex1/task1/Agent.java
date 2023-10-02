package task1;
/*
 * đây là lớp agent gồm có chương trình cho agent
 */
public class Agent {
	private AgentProgram program;

	public Agent() {
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	/** phương thức thực thi của agent
	 * 
	 * @param p
	 * @return
	 */
	public Action execute(Percept p) {
		if (program != null) {
			return program.execute(p);
		}
		return NoOpAction.NO_OP;
	}
}
