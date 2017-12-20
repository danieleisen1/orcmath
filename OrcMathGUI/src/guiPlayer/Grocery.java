package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Grocery extends AnimatedComponent {
	
	private String description;
	private double price;
	
	public Grocery(String description, double price) {
		super(40, 40, 100, 100);
		this.description = description;
		this.price = price;
		
		/*addSequence("resources/spritestrip.jpg", 150, 0, 0, 267, 256, 6);
		Thread animation = new Thread(this);
		animation.start();*/
		update();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String s = description+ "," + price; 
		return s;
	}
	
	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.CYAN);
		super.update(g);
	}

}
