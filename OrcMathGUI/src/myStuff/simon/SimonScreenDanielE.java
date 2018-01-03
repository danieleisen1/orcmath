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
		addButtons();
		for(ButtonInterfaceDanielE b: button){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		text = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceDanielE>();
		//add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(text);
	}

	private MoveInterfaceDanielE randomMove() {
		 int bIndex = (int)(Math.random()*button.length);
		    while(bIndex == lastSelectedButton){
		        bIndex = (int)(Math.random()*button.length);
		    }
		    return getMove(bIndex);
	}

	private MoveInterfaceDanielE getMove(int bIndex) {
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	
	private ProgressInterfaceDanielE getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 0;
		button = new ButtonInterfaceDanielE[numberOfButtons];
		color = new Color[]
				//Left off at Part 2 # 2
	}

}
