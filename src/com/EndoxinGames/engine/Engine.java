package com.EndoxinGames.engine;
import java.io.FileNotFoundException;

import com.EndoxinGames.engine.localization.Localization;

public class Engine {
	
	public static boolean isRunning;
	
	public static EngineSettings settings;
	
	public static GameManager gameManager;
	
	public Engine(EngineSettings settings) {
		isRunning = false;
		Engine.settings = settings;
		gameManager = new GameManager();
		try {
			Localization.init(settings.LANG);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		if(isRunning){
			return;
		}
		run();
	}
	
	public void stop(){
		isRunning = false;
	}
	
	public void render(){
		gameManager.render();
		Window.render();
	}
	
	public void run(){
		isRunning = true;
		
		int frames = 0;
		long frameCounter = 0;
		
		final double FRAME_TIME = 1.0 / settings.FRAME_CAP;
		
		boolean doRender = false;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		
		while(isRunning){
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > FRAME_TIME)
			{
				doRender = true;
				unprocessedTime -= FRAME_TIME;
				
				if(Window.isCloseRequested()){
					stop();
				}
				
				Time.setDelta(FRAME_TIME);
				
				gameManager.input();
				gameManager.update();
				if(frameCounter >= Time.SECOND){
					printFPS(frames);
					frames = 0;
					frameCounter = 0;
				}
			}
			
			if(doRender){
				render();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		cleanUp();
	}
	
	private void printFPS(int frames) {
		if(settings.doPrintFPS) {
			System.out.println(frames);
		}
	}
	
	public void cleanUp(){
		Window.dispose();
	}
	
	public static void main(String[] args) {
		EngineSettings settings = new EngineSettings();
		Engine engine = new Engine(settings);
		Window.createWindow(settings.WIDTH, settings.HEIGHT, settings.TITLE);
		engine.start();
	}
	
}
