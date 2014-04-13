package com.EndoxinGames.engine.exceptions;

public class LocalizionNotInitializedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LocalizionNotInitializedException(){
		super("The localization handler was called before it was initialized.");
	}
}
