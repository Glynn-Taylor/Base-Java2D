package apex5.matrix;

import java.awt.Graphics2D;
/*
	AUTHOR: Glynn Taylor
	CREATED: Oct 9, 2013
 */

public class MatrixGrid {

	public MatrixColumn[] Columns;
	int Height =0;
	public MatrixGrid(int columns, int clmheight){
		Columns = new MatrixColumn[columns];
		for(int i=0;i<columns;i++){
			Columns[i]=new MatrixColumn(clmheight);
		}
		Height=clmheight;
	}
	public void Draw(Graphics2D g2d){
		
		Update();
		/*for(int y=0;y<Height;y++){
			String s="";
			for(int x=0;x<Columns.length;x++){
				s+=Columns[x].getChar(y);
			}
			g2d.drawString(s, 0, y*13);
		}*/
		
		/*AffineTransform orig = g2d.getTransform();
		AffineTransform at = new AffineTransform();
	    at.setToRotation(-Math.PI / 2.0, Launcher.WIDTH / 2.0, Launcher.HEIGHT / 2.0);
	    g2d.setTransform(at);
	    for(int x=0;x<Columns.length;x++){
	    	String s="";
	    	for(int y=0;y<Height;y++){
	    		s+=Columns[x].getChar(y);
	    	}
	    	g2d.drawString(s, 0, x*13-100);
		}
	    g2d.setTransform(orig);*/
		
		for(int y=0;y<Height;y++){
		
		for(int x=0;x<Columns.length;x++){
			g2d.drawString(Columns[x].getChar(y)+"", x*20, y*13);
			
		}
		
	}
	   
	}
	private void Update(){
		for(int i=0;i<Columns.length;i++){
			Columns[i].Update();
		}
	}
	
}

