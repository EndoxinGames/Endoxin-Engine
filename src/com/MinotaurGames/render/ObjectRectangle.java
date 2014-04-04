package com.MinotaurGames.render;

import com.MinotaurGames.exceptions.IllegalGeometryException;

public class ObjectRectangle extends ObjectGeometric {
	ObjectLine A;
	ObjectLine B;
	ObjectLine C;
	ObjectLine D;
	
	public ObjectRectangle(ObjectLine a, ObjectLine b, ObjectLine c) throws IllegalGeometryException {
		if(checkLegality(a, b, c)) {
			A = a;
			B = b;
			C = c;
			D = d;
		} else {
			throw new IllegalGeometryException();
		}
	}
	
	public ObjectRectangle(ObjectVertex a, ObjectVertex b, ObjectVertex c) {
		A = new ObjectLine(a, b);
		B = new ObjectLine(b, c);
		C = new ObjectLine(c, a);
	}

	private boolean checkLegality(ObjectLine a, ObjectLine b, ObjectLine c) {
		if(a.B == b.B) {b.reverse();}
		if(a.B == b.A) {
			if(b.B == c.B) {c.reverse();}
			if(b.B == c.A) {
				if(c.B == a.A) {
					return true;
				}
			}
		}
		return false;
	}
}
