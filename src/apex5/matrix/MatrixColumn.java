package apex5.matrix;

import java.util.Random;
/*
	AUTHOR: Glynn Taylor
	CREATED: Oct 9, 2013
 */

public class MatrixColumn {
	private static Random rand = new Random();
	private static String Alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*(){}|:>?<[]\';/.,'";
	private boolean[] hasChar;
	private int CharCounter=0;
	private int SpaceCounter=0;
	
	public MatrixColumn(int length){
		hasChar = new boolean[length];
		if(rand.nextBoolean()){
			CharCounter=rand.nextInt(10);
		}else{
			SpaceCounter=rand.nextInt(10);
		}
	}
	public char getChar(int i){
		if(hasChar[i]){
			return Alphabet.charAt(rand.nextInt(Alphabet.length()));
		}else{
			return ' ';
		}
	}
	public void Update(){
		PushColumn();
		if(CharCounter>0){
			hasChar[0]=true;
			CharCounter-=1;
			if(CharCounter==0){
				SpaceCounter=rand.nextInt(10);
			}
		}else if(SpaceCounter>0){
			hasChar[0]=false;
			SpaceCounter-=1;
			if(SpaceCounter==0){
				CharCounter=rand.nextInt(10);
			}
		}else{
			if(rand.nextBoolean()){
				CharCounter=rand.nextInt(10);
			}else{
				SpaceCounter=rand.nextInt(10);
			}
		}
	}

	private void PushColumn() {
		for(int i=hasChar.length-1;i>0;i--){
			hasChar[i]=hasChar[i-1];
		}
		
	}
}

