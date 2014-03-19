package apex5.states;

import java.awt.Color;

import apex5.launcher.Launcher;

public abstract class GUIState extends GraphicalState {

	protected boolean Button(Color c, int x, int y, int width, int height, String s){
		dbg.setColor(c);
		dbg.fillRect(x, y, width, height);
		DrawStringCentered(Color.black, DefaultFont, s, x, y, width, height);
		if(Launcher.Window.mouseDown)
		if(Launcher.Window.MouseX>x&&Launcher.Window.MouseX<x+width){
			if(Launcher.Window.MouseY>y&&Launcher.Window.MouseY<y+height){
				return Launcher.Window.popMouseDown();
			}
		}
		return false;
	}
	protected boolean mouseInside(int x, int y, int width, int height){
		if(Launcher.Window.MouseX>x&&Launcher.Window.MouseX<x+width){
			if(Launcher.Window.MouseY>y&&Launcher.Window.MouseY<y+height){
				return true;
			}
		}
		return false;
	}
	
	protected boolean GetKeyDown(int vk) {
		return Launcher.Window.getKeyDown(vk);
	}
	
}