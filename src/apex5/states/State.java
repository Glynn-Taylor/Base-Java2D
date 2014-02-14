package apex5.states;

import java.awt.Graphics;
import java.util.Random;


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

	protected boolean isKeyDown(int c){
		return Launcher.Window.IsKeyDown(c);
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
