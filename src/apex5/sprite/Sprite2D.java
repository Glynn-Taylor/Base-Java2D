package apex5.sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.color.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sprite2D {
	//final int[][] SpriteSheet;
	final BufferedImage SpriteSheet;
	protected Map<String, Integer> AnimationMap;
	protected ArrayList<Animation> Anims;
	protected int CurrentAnim = 0;
	protected Animation Playing;

	/*public Sprite2D(Image spriteS, SpriteData sd) {
		Anims = sd.getAnims();
		AnimationMap = sd.getAnimMap();
		SpriteSheet = spriteS;

		Playing = Anims.get(0);
	}*/
	public Sprite2D(BufferedImage bi) {
		init();
		//SpriteSheet=getSheet(bi);
		SpriteSheet=bi;
	}
	public Sprite2D(BufferedImage b, String[] animNames, int collumns, int speed) {
		init();
		int tw=b.getWidth()/collumns;
		int th=b.getHeight()/animNames.length;
		for(int y=0;y<animNames.length;y++){
			Anims.add(new Animation(tw, th, speed, collumns, y*th));
			AnimationMap.put(animNames[y],y);
		}
		Playing = Anims.get(0);
		SpriteSheet=b;
	}
	private void init() {
		Anims = new ArrayList<Animation>();
		AnimationMap = new HashMap<String, Integer>();
		
	}
	/*private int[][] getSheet(BufferedImage bi){
		int[][] sheet = new int[bi.getHeight()][bi.getWidth()];
		for(int y=0;y<bi.getHeight();y++){
			for(int x=0;x<bi.getWidth();x++){
				sheet[y][x]=bi.getRGB(x, y);
			}
		}
		return sheet;
	}*/
	public void Tick(){
		Playing.Tick();
	}
	/*public void Render(int x, int y, int w, int h, int[][] screen) {
		for(int sy=y;sy<y+h;sy++){
			for(int sx=x;sx<x+w;sx++){
				screen[y+sy][x+sx]=SpriteSheet[Playing.getTY()+(sy-y)][Playing.getLX()+(sx-x)];
			}
		}
	}*/

	public void setAnimation(String animName) {
		try {
			CurrentAnim = AnimationMap.get(animName);
		} catch (Exception e) {
			System.out.println("ERROR: Not a valid animation name!");
		}
	}
	public void render(Graphics dbg, int x, int y, int w, int h) {
		dbg.drawImage(SpriteSheet, x, y, x+w, x+h, Playing.getLX(), Playing.getBY(), Playing.getRX(), Playing.getTY(), null);
		
	}

}
