package myStuff.simon;

import java.util.ArrayList;

import guiTeacher.GUIApplication;
import guiTeacher.components.TextLabel;

public class SimonGameDanielE extends GUIApplication {
	
	private static SimonGameDanielE game;
	private SimonGameDanielE screen;

	private TextLabel textlabel;
	private ButtonInterfaceDanielE[] buttonInterface;
	private ProgressInterfaceDanielE progressInterface;
	private ArrayList<MoveInterfaceDanielE> arrayList;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonGameDanielE(int width, int height) {
		
		super(width,height);
		
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	//Write the main method
	//Write the initScreen method
	//Write the constructor

	@Override
	public void initScreen() {

	screen = new SimonGameDanielE(getWidth(),getHeight());
	
	}
	public static void main(String args[]) {
		game = new SimonGameDanielE(200,200);
		Thread runner = new Thread(game);
		runner.start();
		
		
	}
	
	

}