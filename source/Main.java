import com.MinotaurGames.engine.Window;
import com.MinotaurGames.localization.Localization;


public class Main {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String VERSION = "0.0.1";
	public static final String TITLE = "Laberynthine v" + VERSION;
	
	public static void main(String[] args) {
		Localization.init("English");
		Window.createWindow(WIDTH, HEIGHT, TITLE);
	}
	
	public void start(){
		run();
	}
	
	public void stop(){
		
	}
	
	public void render(){
		Window.render();
	}
	
	public void run(){
		while(true){
			if(!Window.isCloseRequested()){
				break;
			}
			render();
		}
	}
	
	public void cleanUp(){
		Main game = new Main();
		game.start();
	}
	
}
