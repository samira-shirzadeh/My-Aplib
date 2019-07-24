package nl.uu.cs.aplib.MainConcepts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Imagine a use-case where an agent is analyze or even control an environment.
 * For example, this environment can be a computer game, or a set of physical 
 * objects.
 * 
 * This class provides a template to implement an interface between the agent 
 * and the environment that it must control. To implement such an interface 
 * you will have to provide a concrete subclass of this class. This interface
 * should provide a representation of the relevant part of the environment's
 * actual state. Towards the agent, this class provides methods to refresh
 * the state representation held by an instance of this class, and for the
 * agent to send commands to the actual environment.
 * 
 * @author wish
 *
 */
public class Environment {
	
		
	public Environment() { }
	
	/**
	 * Inspect the actual environment and reflects its actual state into this abstract representation.
	 */
	public void refresh() { }
	
	/**
	 * This will start the actual environment, if it is not started yet, and else it
	 * will restart it (reseting to its initial state).
	 */
	public void restart() {  }
	
	
	/**
	 * Send the specified command to an object in the environment.
	 * 
	 * @param id  The unique ID of the object to which the command is directed.
	 * @param command The name of the command.
	 * @param args The arguments to be passed along with the command.
	 * @return true if the command is successfully executed; false if the environment rejects it. 
	 * 
	 * The method may also throws a runtime exception.
	 */
	protected String sendCommand_(String id, String command, String arg) {
		throw new UnsupportedOperationException() ;
	}
		

}
