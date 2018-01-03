package myStuff.simon;

import guiTeacher.GUIApplication;
public class SimonGameDanielE extends GUIApplication {

	
	public SimonGameDanielE(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenDanielE screen = new SimonScreenDanielE(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		SimonGameDanielE catalog = new SimonGameDanielE(800,550);
		Thread runner = new Thread(catalog);
		runner.start();
	}

}
