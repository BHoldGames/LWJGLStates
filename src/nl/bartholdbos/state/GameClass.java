package nl.bartholdbos.state;

import java.util.HashMap;

public abstract class GameClass {
	
	private String currentState;
	private HashMap<String, State> states = new HashMap<String, State>();
	
	protected abstract void init2D();
	
	protected abstract void init3D();
	
	public void addState(String name, State state){
		states.put(name, state);
	}
	
	public boolean setState(String name){
		if(states.get(name) != null){
			currentState = name;
			states.get(name).init(this);
			
			return true;
		}else{
			return false;
		}
	}
	
	public State getState(String name){
		return states.get(name);
	}
	
	protected void call(){
		State state;
		
		if((state = states.get(currentState)) != null){
			if(state.is3D()){
				init3D();
			}else{
				init2D();
			}
			state.input();
			state.update();
			state.render();
		}
	}
}