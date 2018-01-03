package myStuff.simon;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDanielE extends ClickableScreen implements Runnable {
	private TextLabel text;
	private ButtonInterfaceDanielE[] button;
	private ProgressInterfaceDanielE progress;
	private ArrayList<MoveInterfaceDanielE> move;
	
	private int roundNumber; 
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenDanielE(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}

}
