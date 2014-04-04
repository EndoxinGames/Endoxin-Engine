package com.MinotaurGames.exceptions;

public class IllegalGeometryException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IllegalGeometryException(){
		super("The specified coordinates are not compatible");
	}
	
}
