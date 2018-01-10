package myStuff.simon;

import java.awt.Color;
import java.awt.Graphics2D;

import com.itextpdf.text.Font;

import guiTeacher.components.Component;

public class ProgressDanielE extends Component implements ProgressInterfaceDanielE {
	public ProgressDanielE(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	private int roundNum;
	private int sequenceNum;
	private boolean lose;
	
	
	public ProgressDanielE() {
		super(250,50,400,200);

	}

	@Override
	public void lose() {
		lose = true;
		update();
	} 

	@Override 
	public void update(Graphics2D g) {
			clear();
			clear();
			if(lose){
				g.setColor(Color.blue);
				g.drawString("Game Over.", 0, 50);
			}
			else{
				g.setColor(Color.blue);
				g.drawString("Round: "+roundNum, 30, 35);
				g.drawString("Sequence: "+sequenceNum, 30, 20);
			}

	}

	@Override
	public void setNum(int roundNum, int sequenceNum) {
		this.roundNum = roundNum;
		this.sequenceNum = sequenceNum;
		update();
	}
	
}