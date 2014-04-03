package com.MinotaurGames.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.MinotaurGames.localization.Localization;
import com.MinotaurGames.localization.LocalizationNotPresentException;
import com.MinotaurGames.localization.LocalizionNotInitializedException;

public class Window {
	
	public static void createWindow(int width, int height, String title){
		Display.setTitle(title);
		try {
			Display.setTitle(Localization.localize("test", 1));
		} catch (LocalizionNotInitializedException e1) {
			e1.printStackTrace();
		} catch (LocalizationNotPresentException e) {
			e.printStackTrace();
		}
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void render(){
		Display.update();
	}
	
	public static boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public static int getWidth(){
		return Display.getDisplayMode().getWidth();
	}
	
	public static int getHeight(){
		return Display.getDisplayMode().getHeight();
	}
	
	public static String getTitle(){
		return Display.getTitle();
	}
	
}
