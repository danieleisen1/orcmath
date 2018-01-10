package myStuff.simon;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDanielE extends ClickableScreen implements Runnable {

	public ArrayList<MoveInterfaceDanielE> array;
	public ProgressInterfaceDanielE progress;
	
	
	public int roundNum;
	public int sequenceLength;
	public int sequenceWin;
	public boolean input;
	
	
	public ButtonInterfaceDanielE[] allButtons;
	
	public int oldButton;
	Color[] colors;
	
	public TextLabel displayRound;
	public SimonScreenDanielE(int width, int height) {
		super(width, height);
		
		
		
		Thread app = new Thread(this);
		app.start();
	}
	

	public void run() {
		input = false;
		sequenceWin++;
		roundNum++;
		array.add(getRandomMove());
		progress.setNum(roundNum, array.size());
		simonInput();
		displayRound.setText("Your turn");
		sequenceLength=0;
		input = true;
		
	}
	
	public void simonInput(){
		ButtonInterfaceDanielE b;
		for(int i = 0; i < array.size(); i++) {
			b = array.get(i).getTheButton();
			b.setBright("bright");
			try {
				Thread.sleep((int)(1000*roundNum));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.setBright("dim");
		}
		
	}
	
	 
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		array = new ArrayList<MoveInterfaceDanielE>();
		oldButton = -1;
		allButtons = new ButtonInterfaceDanielE[4];
		colors = new Color[4];
		colors[0] = Color.BLUE;
		colors[1] = Color.YELLOW;
		colors[2] = Color.RED;
		colors[3] = Color.GREEN;
	
		roundNum = 0;
		sequenceLength = 0;
		sequenceWin= 3;
		input = true;
		
		
		displayRound = new TextLabel(50,30,200,100,"TIME TO PLAY SIMON FOLLOW MY STEPS!!");
		viewObjects.add(displayRound);
		
		for (int i = 0;i <allButtons.length;i++) {
			
			final ButtonInterfaceDanielE button = getButton(50,i*70+70,60,60);
			allButtons[i] = button;
			button.setColor1(colors[i]);
			button.setAction(new Action() {
				
				@Override
				public void act() {
					if (input) {
						Thread light  = new Thread(new Runnable() {
							
							@Override
							public void run() {
								button.setBright("bright");
								input = false;
								try {
									Thread.sleep(800);
								}catch(InterruptedException e ) {
									e.printStackTrace();
								}
								input = true;
								button.setBright("dim");
							}
						});
						light.start();
						if(button == array.get(sequenceLength).getTheButton()) { // correct input
							sequenceLength++;
						} else{ // wrong input
							progress.lose();
							input = false;
						}
						if(sequenceLength == array.size()){ // got all correct
						    Thread nextRound = new Thread(SimonScreenDanielE.this); 
						    nextRound.start(); 
						}
					}
					
				}
			});
		}
		
		progress = getProgressBar();
		progress.setNum(roundNum,sequenceWin);
		array.add(getRandomMove());
		array.add(getRandomMove());

		for (int i = 0;i <allButtons.length;i++) {
			System.out.println(allButtons[i]);
			viewObjects.add(allButtons[i]);
		}
		viewObjects.add(progress);
	}

	private MoveInterfaceDanielE getRandomMove() {
		int randomInt = (int)(Math.random()*allButtons.length);
		while (randomInt == oldButton) {
			randomInt = (int)(Math.random()*allButtons.length);
		}
		return new MoveDanielE(allButtons[randomInt]);
	}


	private ProgressInterfaceDanielE getProgressBar() {
		return new ProgressDanielE();
	}

	


	private ButtonInterfaceDanielE getButton(int x,int y,int w, int h) {
		ButtonDanielE button = new ButtonDanielE(x,y,w,h,"",null);
		return button;
	}



}