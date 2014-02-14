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

public class MenuState extends GUIState {

	

	Cuboid MoveableSquare = new Cuboid(Color.red, 50,50,20,20);
	
	Font MenuFont = new Font("SansSerif", Font.PLAIN, 26);
	boolean HideText=true;
	int ButtonWidth = 100;
	int ButtonStartX=(Launcher.WIDTH-ButtonWidth)/2;
	@Override
	public void Render() {

		FillBackground(Color.black);
		
		
		DrawStringCentered(Color.white, MenuFont, "SUPAR AWESOME MENU", 0, 0,Launcher.WIDTH,100);
		if(!HideText)
			DrawString(Color.green, MenuFont, "hello world", 50, 50);
		if(Button(Color.white, ButtonStartX, 80, ButtonWidth, 50, "toggle text"))
			HideText=!HideText;
		if(Button(Color.white, ButtonStartX, 150, ButtonWidth, 50, "gamestate")){
			System.out.println("changing to gamestate");
			Launcher.Window.ChangeState(new GameState());
		}
			

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
		
		if (GetKeyDown(KeyEvent.VK_R))
			Launcher.Window.ChangeState(new GameState());
	}

}
