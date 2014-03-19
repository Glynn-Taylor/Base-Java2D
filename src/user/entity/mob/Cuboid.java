package user.entity.mob;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import apex5.entity.Entity;

public class Cuboid extends Entity{
	Color colour;
	public Cuboid(Color c, int x, int y, int w, int h){
		colour=c;
		Position= new Point(x, y);
		Width=w;
		Height=h;
	}
	@Override
	public void Render(Graphics2D screenGraphics) {
		screenGraphics.setColor(colour);
		screenGraphics.fillRect(Position.x, Position.y, Width, Height);
		
	}
	public void Move(int x, int y){
		Position.x+=x;
		Position.y+=y;
	}

}
