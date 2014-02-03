package apex5.launcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import apex5.states.State;

public class Input extends JFrame implements WindowListener, KeyListener{
	protected State CurrentState;
	protected State PreviousState=null;
	protected boolean[] keys = new boolean[65536];
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		requestFocus();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		//requestFocus();
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		CurrentState.requestFocus();
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		CurrentState.requestFocus();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		//toFront();
		//System.out.println("Aahhhhh");
	}

	private String keyMask = "abcdefghijklmnopqrstuvwxyz0123456789";
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode(); 
		if (code>0 && code<keys.length) {
			keys[code] = true;
		}
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode(); 
		if (code>0 && code<keys.length) {
			keys[code] = false;
		}
		
	}

}
