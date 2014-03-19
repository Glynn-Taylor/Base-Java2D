package apex5.states;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import apex5.launcher.Launcher;


public abstract class State  {
	
	private int w, h;
	protected Random r;
	protected Graphics dbg;
	protected int[] ScreenBuffer;
	//protected int[] ScreenBuffer;
	
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


	public void init(Graphics dbg, BufferedImage dbImage) {
		r = new Random();
		w = Launcher.WIDTH;
		h = Launcher.HEIGHT;
		this.dbg=dbg;
		ScreenBuffer=((DataBufferInt) dbImage.getRaster().getDataBuffer()).getData();
	}

	public void run() {
			Update();
			Render();
	}

}
