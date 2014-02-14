package apex5.launcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Input extends JFrame implements WindowListener, KeyListener,
		MouseListener, MouseMotionListener {
	protected StatePanel StateHandler;
	protected boolean[] keys = new boolean[KeyEvent.KEY_LAST + 1];
	protected boolean[] keyUsed = new boolean[keys.length];
	public int MouseX;
	public int MouseY;
	public boolean mouseDown;

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
		// requestFocus();

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		StateHandler.requestFocus();

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		StateHandler.requestFocus();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// toFront();
		// System.out.println("Aahhhhh");
	}

	//private String keyMask = "abcdefghijklmnopqrstuvwxyz0123456789";

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = false;
			keyUsed[code] = false;
		}

	}
	
	public boolean getKeyDown(int k) {

		if (keys[k]&&!keyUsed[k]) {
			keyUsed[k] = true;
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;

	}

	public boolean popMouseDown() {
		if (mouseDown) {
			mouseDown = false;
			return true;
		}
		return false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MouseX = e.getX();
		MouseY = e.getY();

	}

	

}
