import java.io.FileNotFoundException;

import com.MinotaurGames.engine.Window;
import com.MinotaurGames.localization.Localization;


public class Main {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String VERSION = "InDev";
	public static final String TITLE = "Labyrinthine v" + VERSION;
	/*
	 * Languages:
	 *	English
	 *	Pirate
	 *	日本語
	 *	
	 */
	public static final String LANG = "日本語";
	
	public static void main(String[] args) {
		try {
			Localization.init(LANG);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
