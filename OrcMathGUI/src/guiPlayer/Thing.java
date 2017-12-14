package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Thing extends Component {

	public Thing(int x, int y, int w, int h) {
		super(40, 40, 40, 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.CYAN);
	}

}
