package user.entity;

import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Entity {
	protected Point Position;
	protected int Width, Height;
	protected float Rotation;
	
	public abstract void Render(Graphics2D screenGraphics);
}
