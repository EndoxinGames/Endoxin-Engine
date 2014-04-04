package com.MinotaurGames.exceptions;

public class FileMissingException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FileMissingException(){
		super("The file could not be read");
	}
	
}
