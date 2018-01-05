package myStuff.simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceDanielE extends Clickable {

	void setColor(Color blue);
	void setAction(javax.swing.Action action);
	void highlight();
	void dim();


}