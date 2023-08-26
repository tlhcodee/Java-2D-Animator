package dev.tal.animator.object;

import javax.swing.JLabel;

import dev.tal.animator.Frame;

public class MovementFrame {

	private Vector2D toGo;
	private JLabel objectRef;
	
	public MovementFrame(JLabel objectRef, Vector2D toGo) {
		this.objectRef = objectRef;
		this.toGo = toGo;
	}
	
	public void applyPatch() {
		int cX = objectRef.getX();
		int cY = objectRef.getY();
		
		if(cX < toGo.getX()) {
			objectRef.setBounds(cX + Frame.Speed, cY, 66, 14);
		} else if(cX > toGo.getX()) {
			objectRef.setBounds(cX - Frame.Speed, cY, 66, 14);
		}
		
		if(cY < toGo.getY()) {
			objectRef.setBounds(cX, cY + Frame.Speed, 66, 14);
		} else if(cY > toGo.getY()) {
			objectRef.setBounds(cX, cY - Frame.Speed, 66, 14);
		}
	}
	
	public boolean isDone() {
		return objectRef.getX() == toGo.getX() && objectRef.getY() == toGo.getY();
	}


	public Vector2D getToGo() {
		return toGo;
	}

	public void setToGo(Vector2D toGo) {
		this.toGo = toGo;
	}

	public JLabel getObjectRef() {
		return objectRef;
	}

	public void setObjectRef(JLabel objectRef) {
		this.objectRef = objectRef;
	}
	
	
}
