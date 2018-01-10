package myStuff.simon;

public class MoveDanielE implements MoveInterfaceDanielE {

	
	ButtonInterfaceDanielE button;
	
	public MoveDanielE(ButtonInterfaceDanielE button) {
		this.button = button;
	}
	
	public ButtonInterfaceDanielE getButton() {
		return button;
	}

	@Override
	public ButtonInterfaceDanielE getTheButton() {
		// TODO Auto-generated method stub
		return null;
	}

}