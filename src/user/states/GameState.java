package user.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import user.entity.mob.Cuboid;

import apex5.states.GraphicalState;
import apex5.states.Launcher;

/*
 AUTHOR: Glynn Taylor
 CREATED: Oct 8, 2013
 */

public class GameState extends GraphicalState {

	Cuboid MoveableSquare = new Cuboid(Color.red, 50,50,20,20);
	Font StandardFont = new Font("SansSerif", Font.PLAIN, 13);

	@Override
	public void Render() {

		FillBackground(Color.black);
		
		DrawEntity(MoveableSquare);
		
		DrawString(Color.green, StandardFont, "hello world", 50, 50);

	}

	

	@Override
	public void Update() {
		
		if (Launcher.Window.IsKeyDown(KeyEvent.VK_W))
			MoveableSquare.Move(0, -1);
		
		if (Launcher.Window.IsKeyDown(KeyEvent.VK_A))
			MoveableSquare.Move(-1, 0);
		
		if (Launcher.Window.IsKeyDown(KeyEvent.VK_S))
			MoveableSquare.Move(0, 1);
		
		if (Launcher.Window.IsKeyDown(KeyEvent.VK_D))
			MoveableSquare.Move(1, 0);
		
		if (Launcher.Window.IsKeyDown(KeyEvent.VK_R))
			Launcher.Window.ChangeState(new GameState());
	}

}
