package com.MinotaurGames.render;

public class ObjectVertex {
	public double X;
	public double Y;
	public double Z;
	
	public ObjectVertex() {
		X = 0;
		Y = 0;
		Z = 0;
	}
	
	public ObjectVertex(double x, double y, double z) {
		X = x;
		Y = y;
		Z = z;
	}
	
	public void setPosition(double x, double y, double z) {
		X = x;
		Y = y;
		Z = z;
	}
	
	public void changePosition(double dx, double dy, double dz) {
		X = X + dx;
		Y = Y + dy;
		Z = Z + dz;
	}
}
