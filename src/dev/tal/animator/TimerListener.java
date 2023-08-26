package dev.tal.animator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dev.tal.animator.object.MovementFrame;

public class TimerListener implements ActionListener {
	public MovementFrame currentFrame;
	public int size;
	
	public TimerListener() {
    	if(Frame.movementFrame.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Create an frame before going in");
    	}
    	size = 0;
    	currentFrame = Frame.movementFrame.get(size);
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(currentFrame.isDone()) {
    		size++;
    		if(size < Frame.movementFrame.size() && Frame.movementFrame.get(size) != null) {
    			currentFrame = Frame.movementFrame.get(size);
    		} 
    	} else {
    		currentFrame.applyPatch();
    	}
    }
}