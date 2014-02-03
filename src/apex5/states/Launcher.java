package apex5.states;

/*
 AUTHOR: Glynn Taylor
 CREATED: Oct 8, 2013
 */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import user.states.GameState;
import apex5.launcher.Input;
import apex5.launcher.StatePanel;

public class Launcher extends Input {

	public static int WIDTH = 700;
	public static int HEIGHT = 500;
	public static Launcher Window;
	//public static boolean RUNNING =true;
	
	
	public Launcher() {
		setTitle("Java Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window=this;
		StatePanel panel = new StatePanel();
		panel.addKeyListener(this);
		add(panel);
		StateHandler=panel;
		addWindowListener(this);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setLocation((int)(screenSize.width/2-(double)WIDTH/2), (int)(screenSize.height/2-(double)HEIGHT/2));
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Launcher();
			}
		});
	}
	public void ChangeState(State s){
		StateHandler.SwitchState(s);
	}
	public boolean IsKeyDown(int keycode){
		return keys[keycode];
	}
	public void NextState(){
		
	}
}
