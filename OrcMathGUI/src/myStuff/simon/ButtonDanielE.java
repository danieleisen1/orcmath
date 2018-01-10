package myStuff.simon;

import java.awt.Color;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonDanielE extends Button implements ButtonInterfaceDanielE {
	
	private Action buttonAction;
	private Color buttonColor;

	public ButtonDanielE(int x, int y, int w, int h, String text, Action action) {
		super(x+20, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAction(Action action) {
		this.buttonAction = action;

	}

	@Override
	public void highlight() {
		this.setBackground(Color.BLUE);
		update();

	}

	@Override
	public void dim() {
		this.setBackground(this.buttonColor);
		update();

	}

	@Override
	public void setColor(Color color) {
		buttonColor = color;
		this.setBackground(color);
		update();
	}

	
}
