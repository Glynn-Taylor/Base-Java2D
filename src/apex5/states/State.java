package apex5.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

public abstract class State extends JPanel implements Runnable {
	protected Thread StateThread;

	private int w, h;
	private boolean running = false;;
	protected Random r;
	protected Graphics dbg;
	private Image dbImage = null;

	private Graphics2D g2;

	protected int getW() {

		return w;

	}

	protected int getH() {

		return h;
	}

	private void RenderPanel() {
		if (dbImage == null) {
			dbImage = createImage(w, h);
			if (dbImage == null) {

				System.out.println("dbImage is null: " + Integer.toString(w)
						+ ":" + Integer.toString(h));
				return;

			} else {

				dbg = dbImage.getGraphics();
				g2 = (Graphics2D) dbg;
			}
		}
		Render();
		PaintPanel();

	}

	protected abstract void Render();

	public abstract void Update();

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
		// Dimension size = getSize();
		// Insets insets = getInsets();
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
		long currentTime = System.currentTimeMillis();
		long totalTime = System.currentTimeMillis();
		int ticks = 0;
		running = true;

		while (running) {

			Update();
			RenderPanel();

			try {
				Thread.sleep(10);
			} catch (Exception e) {

			}
			ticks += 1;
			totalTime = System.currentTimeMillis();
			if (totalTime - currentTime > 1000) {
				currentTime = totalTime;
				// FPS=ticks;
				ticks = 0;
			}
		}
		Launcher.Window.NextState();

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
}
