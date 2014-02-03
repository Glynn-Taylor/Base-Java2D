package apex5.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

public abstract class State  {
	
	private int w, h;
	protected Random r;
	protected Graphics dbg;

	protected int getW() {

		return w;

	}

	protected int getH() {

		return h;
	}

	

	public abstract void Render();

	public abstract void Update();


	public void init(Graphics dbg) {
		r = new Random();
		w = Launcher.WIDTH;
		h = Launcher.HEIGHT;
		this.dbg=dbg;
	}

	public void run() {
			Update();
			Render();
	}

}
