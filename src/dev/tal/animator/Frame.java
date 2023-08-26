package dev.tal.animator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dev.tal.animator.object.MovementFrame;
import dev.tal.animator.object.Vector2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField txtFps;
	public static List<MovementFrame> movementFrame;
	public static int lastFrame = 0;
	public static TimerListener timerListener;
    
	public static RunThread threading;
	public static int Speed = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					movementFrame = new ArrayList<MovementFrame>();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 315, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\talhababa\\Desktop\\icons8-super-mario-16.png"));
		lblNewLabel_1.setBounds(10, 192, 66, 14);
		panel.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lblNewLabel_1.setBounds((int)spinner.getValue(), lblNewLabel_1.getY(), 66, 14);
			}
		});
		spinner.setBounds(0, 0, 66, 20);
		spinner.setValue(lblNewLabel_1.getX());
		panel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(234, 0, 81, 20);
		spinner_1.setValue(lblNewLabel_1.getY());
		spinner_1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lblNewLabel_1.setBounds(lblNewLabel_1.getX(), (int) spinner_1.getValue(), 66, 14);
			}
		});
		panel.add(spinner_1);
		
		JButton btnNewButton = new JButton("Add Frame");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				movementFrame.add(new MovementFrame(lblNewLabel_1, new Vector2D(lblNewLabel_1.getX(), lblNewLabel_1.getY())));
				
				JOptionPane.showMessageDialog(null, "Added a frame");

			}
		});
		btnNewButton.setBounds(329, 180, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRemoveFrame = new JButton("Remove Frame");
		btnRemoveFrame.setBounds(329, 146, 141, 23);
		contentPane.add(btnRemoveFrame);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_1.setBounds(10, 192, 66, 14);
				timerListener = new TimerListener();
				threading = new RunThread(60, timerListener);
				threading.start();
			}
		});
		btnPlay.setBounds(329, 11, 141, 23);
		contentPane.add(btnPlay);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(329, 40, 141, 23);
		contentPane.add(btnStop);
		
		txtFps = new JTextField();
		txtFps.setToolTipText("f");
		txtFps.setText("FPS");
		txtFps.setBounds(329, 74, 141, 20);
		contentPane.add(txtFps);
		txtFps.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Speed: 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(165, 239, 93, 23);
		contentPane.add(lblNewLabel);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lblNewLabel.setText("Speed: " + slider.getValue());
				Speed = slider.getValue();
			}
		});
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setValue(1);
		slider.setBounds(20, 239, 141, 23);
		contentPane.add(slider);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
