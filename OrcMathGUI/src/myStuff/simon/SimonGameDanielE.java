package myStuff.simon;

import guiTeacher.GUIApplication;

public class SimonGameDanielE extends GUIApplication {
	
	public static SimonGameDanielE sample;
	public static SimonScreenDanielE simon;
	
	public SimonGameDanielE(int width, int height) {
		super(width,height);
		setVisible(true);
	}
	 
	public static void main(String[] args){
		sample = new SimonGameDanielE(1000, 1000);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	
	
	public void initScreen() {
		// TODO Auto-generated method stub
		simon = new SimonScreenDanielE(getWidth(), getHeight());
		setScreen(simon);
	}

}