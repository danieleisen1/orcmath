package myStuff.simon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

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
		setRoundNumber(0);
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
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 4;	
		button = new ButtonInterfaceDanielE[numberOfButtons-1];
		Color button1 = new Color(0,0,0);
		Color button2 = new Color(45,54,120);
		Color button3 = new Color(68,100,32);
		Color button4 = new Color(32,32,32);
		Color button5 = new Color(200,200,200);
		Color button6 = new Color(144,23,43);
		
		for(int i = 0; i < numberOfButtons;i++)
		{
			final ButtonInterfaceDanielE b = getAButton();
			button[i] = b;
			  b.setColor(Color.blue); 
			   b.setX(5);
			   b.setY(8);
			 
			   b.setAction(new Action(){

				   public void act(){
					   if(acceptingInput)
					   {
						   Thread blink = new Thread(new Runnable(){

							   public void run(){
									b.highlight();
									try {
									Thread.sleep(800);
									} catch (InterruptedException e) {
									e.printStackTrace();
									}
									b.dim();
							   }

							   });
						   blink.start();
					   }
				   }

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void addPropertyChangeListener(PropertyChangeListener listener) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public Object getValue(String key) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void putValue(String key, Object value) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void removePropertyChangeListener(PropertyChangeListener listener) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void setEnabled(boolean b) {
					// TODO Auto-generated method stub
					
				}

				   });
		
			   if(b == move.get(sequenceIndex).getButton()) {
				   sequenceIndex++;
			   }
			   else {
				   progress.gameOver();
			   }
			   if(sequenceIndex == move.size()){ 
				    Thread nextRound = new Thread(SimonScreenDanielE.this); 
				    nextRound.start(); 
			   }
		}

			   
	}
		private ButtonInterfaceDanielE getAButton() 
		{
			return null;
			
		}
		@Override
		public void run() {
			text.setText("");
		    nextRound();
		}

		private void nextRound() {
			acceptingInput= false;
			setRoundNumber(getRoundNumber() + 1);
			randomMove();
			
		}



		public int getRoundNumber() {
			return roundNumber;
		}



		public void setRoundNumber(int roundNumber) {
			this.roundNumber = roundNumber;
		}		


}
