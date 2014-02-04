package apex5.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import user.entity.Entity;
import user.entity.mob.Cuboid;

import apex5.matrix.MatrixGrid;

public abstract class GraphicalState extends State {

	final Font DefaultFont = new Font("Arial", Font.PLAIN, 13);
	
	private void RenderString(Color c, Font font, String text, int x, int y) {
		dbg.setColor(c);
		setHints();
		dbg.setFont(font);
		dbg.drawString(text, x, y);
	}
	protected void DrawString(String text, int x, int y) {
		RenderString(Color.black, DefaultFont, text, x, y);
	}
	protected void DrawString(Color c, String text, int x, int y) {
		RenderString(c, DefaultFont, text, x, y);
	}
	protected void DrawString(Color c, Font font, String text, int x, int y) {
		RenderString(c, font, text, x, y);
	}
	protected void DrawString(Color c, Font font, int text, int x, int y) {
		RenderString(c, font, Integer.toString(text), x, y);
	}
	protected void DrawString(Color c, Font font, float text, int x, int y) {
		RenderString(c, font, Float.toString(text), x, y);
	}
	protected void DrawRectangle(Color c, int x, int y, int width, int height){
		dbg.setColor(c);
		dbg.fillRect(x, y, width, height);
	}
	protected void DrawRectangleBorder(Color c, int x, int y, int width, int height){
		dbg.setColor(c);
		dbg.drawRect(x, y, width, height);
	}
	protected void Draw(Color c, int x, int y, int x2, int y2){
		dbg.setColor(c);
		dbg.drawLine(x, y, x2, y2);
	}
	protected void DrawStrings(Color c, Font font, String[] text, int x, int y,
			int xOffset, int yOffset) {
		for (int i = 0; i < text.length; i++) {
			DrawString(c, font, text[i], x + i * xOffset, y + i * yOffset);
		}
	}

	protected void FillBackground(Color c) {

		dbg.setColor(c);
		setHints();
		dbg.fillRect(0, 0, getW(), getH());
	}

	MatrixGrid MtrxGrid = new MatrixGrid(60, 120);

	protected void FloodMatrix(Color c) {

		dbg.setColor(c);
		setHints();
		MtrxGrid.Draw((Graphics2D) dbg);
	}

	private String Alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*(){}|:>?<[]\';/.,'";

	protected void StaticMatrix(Color c) {
		dbg.setColor(c);
		setHints();
		for (int y = 0; y < 50; y++) {
			String s = "";
			for (int x = 0; x < 150; x++) {
				if (r.nextDouble() > 0.6) {
					s += Alphabet.charAt(r.nextInt(Alphabet.length()));
				} else {
					s += " ";
				}
			}
			dbg.drawString(s, 0, y * 13);

		}

	}

	protected void DrawStars(Color c) {

		dbg.setColor(c);
		for (int i = 0; i < 1000; i++) {

			int x = Math.abs(r.nextInt()) % getW();
			int y = Math.abs(r.nextInt()) % getH();
			dbg.drawLine(x, y, x, y);
		}
	}

	private void setHints() {
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		((Graphics2D) dbg).setRenderingHints(rh);
	}
	protected void DrawEntity(Entity ent) {
		ent.Render((Graphics2D) dbg);
		
	}
}
