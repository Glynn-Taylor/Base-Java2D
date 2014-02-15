package user.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import user.entity.mob.Cuboid;
import apex5.states.GUIState;
import apex5.states.Launcher;

/*
 AUTHOR: Glynn Taylor
 CREATED: Oct 8, 2013
 */

public class DefaultState extends GUIState {

	Cuboid MoveableSquare = new Cuboid(Color.red, 50,50,20,20);
	Font StandardFont = new Font("SansSerif", Font.PLAIN, 13);

	@Override
	public void Render() {

		FillBackground(Color.black);
		
		DrawString(Color.green, StandardFont, "hello world, I'm a square!", 50, 50);
		
		DrawEntity(MoveableSquare);
		
		
	}

	

	@Override
	public void Update() {
		
		if (isKeyDown(KeyEvent.VK_W))
			MoveableSquare.Move(0, -1);
		
		if (isKeyDown(KeyEvent.VK_A))
			MoveableSquare.Move(-1, 0);
		
		if (isKeyDown(KeyEvent.VK_S))
			MoveableSquare.Move(0, 1);
		
		if (isKeyDown(KeyEvent.VK_D))
			MoveableSquare.Move(1, 0);
		
		if (GetKeyDown(KeyEvent.VK_R))
			Launcher.Window.ChangeState(new MenuState());
	}



	

}
