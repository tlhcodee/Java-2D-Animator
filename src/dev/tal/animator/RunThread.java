package dev.tal.animator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import dev.tal.animator.object.MovementFrame;


@SuppressWarnings("serial")
public class RunThread extends Timer{
    public static MovementFrame currentFrame;
    public static int size = 0;
    public static long lastFrame;
    
    public RunThread(int delay, TimerListener listener) {
		super(delay, listener);
    	if(Frame.movementFrame.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Create an frame before going in");
    		this.stop();
    	}
    	currentFrame = Frame.movementFrame.get(0);
	}
}
