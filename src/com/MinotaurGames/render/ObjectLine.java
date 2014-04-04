package com.MinotaurGames.render;

public class ObjectLine {
	ObjectVertex A;
	ObjectVertex B;
	
	public ObjectLine(ObjectVertex a, ObjectVertex b) {
		A = a;
		B = b;
	}
	
	public void moveA(double dx, double dy, double dz) {
		A.changePosition(dx, dy, dz);
	}
	
	public void moveB(double dx, double dy, double dz) {
		B.changePosition(dx, dy, dz);
	}
	
	public double getLength() {
		double dx = A.X - B.X;
		double dy = A.Y - B.Y;
		double dz = A.Z - B.Z;
		double length = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
		return length;
	}
	
	public void reverse() {
		ObjectVertex newA = B;
		ObjectVertex newB = A;
		A = newA;
		B = newB;
	}
}
