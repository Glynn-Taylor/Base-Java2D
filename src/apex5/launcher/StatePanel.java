package apex5.launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import user.states.DefaultState;
import apex5.states.State;

@SuppressWarnings("serial")
public class StatePanel extends JPanel implements Runnable {

	protected Thread StateThread;
	private static int UPDATE_LOCK=60;
	private int w, h;
	private boolean running = false;;
	protected Random r;
	protected Graphics dbg;
	private BufferedImage dbImage = null;

	private State CurrentState;
	@SuppressWarnings("unused")
	private Graphics2D g2;

	protected int getW() {

		return w;

	}

	protected int getH() {

		return h;
	}

	private void RenderPanel() {
		if (dbImage == null) {
			dbImage = (BufferedImage) createImage(w, h);
			if (dbImage == null) {

				System.out.println("dbImage is null: " + Integer.toString(w)
						+ ":" + Integer.toString(h));
				return;

			} else {

				dbg = dbImage.getGraphics();
				g2 = (Graphics2D) dbg;
				CurrentState.init(dbg, dbImage);
			}
		}

		CurrentState.Render();
		PaintPanel();

	}

	private void PaintPanel() {
		{
			Graphics g;
			try {
				g = this.getGraphics();

				if ((g != null) && (dbImage != null))

					g.drawImage(dbImage, 0, 0, null);

				g.dispose();

			} catch (Exception e)

			{
				System.out.println("Graphics context error: " + e);
			}
		}

	}

	protected void init() {
		CurrentState = new DefaultState();
		r = new Random();
		// w = size.width - insets.left - insets.right;
		// h = size.height - insets.top - insets.bottom;
		w = Launcher.WIDTH;
		h = Launcher.HEIGHT;
		setDoubleBuffered(true);
		setBackground(Color.white);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerTick = 1000000000.0 / (double)UPDATE_LOCK;
		int frames = 0;
		long lastTimer = System.currentTimeMillis();
		//long currentTime = System.currentTimeMillis();
		//long totalTime = System.currentTimeMillis();
		int ticks = 0;
		running = true;

		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			while (unprocessed >= 1) {
				ticks++;
				CurrentState.Update();
				unprocessed -= 1;
				shouldRender = true;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				RenderPanel();
			}
			

			if (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}

	}

	public void addNotify()

	{
		super.addNotify();
		startGame();
	}

	private void startGame()

	{

		if (StateThread == null || !running) {
			init();
			StateThread = new Thread(this);

			StateThread.start();
		}
	}

	public void Stop() {
		running = false;

	}

	public void SwitchState(State s) {
		CurrentState=s;
		CurrentState.init(dbg,dbImage);
		
	}

}
