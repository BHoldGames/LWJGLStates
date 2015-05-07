package nl.bartholdbos.state;

public abstract class State{
	
	private boolean is3D;
	private GameClass game;
	
	public abstract void init();
	
	public abstract void input();
	
	public abstract void update();
	
	public abstract void render();
	
	public State(boolean is3D){
		this.is3D = is3D;
	};
	
	public boolean is3D(){
		return is3D;
	}
	
	void init(GameClass game){
		this.game = game;
		init();
	}
	
	public GameClass getGame(){
		return game;
	}
	
	public void init2D(){
		game.init2D();
	}
	
	public void init3D(){
		game.init3D();
	}
}