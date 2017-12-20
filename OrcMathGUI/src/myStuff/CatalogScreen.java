package myStuff;

import java.util.List;

import guiPlayer.CatalogMaker;
import guiPlayer.Grocery;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField priceField;
	private TextField descriptionField;
	private Button addButton;
	private CatalogMaker catalog;
	private TextArea textArea;
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog =  new CatalogMaker();
		priceField = new TextField(80,40,200,30,"Text goes here.","Type");
		descriptionField = new TextField(40,40,200,30,"Text goes here.","Description");
		viewObjects.add(priceField);
		viewObjects.add(descriptionField);

		addButton = new Button(100,100,20,20,"Add",new Action() {
			
			@Override
			public void act() {
				descriptionField.setText("You clicked the button.");	
				addButtonClicked();
			}
		});
		viewObjects.add(addButton);
		textArea = new TextArea(300,300,300,300,"TEXT AREA");
		viewObjects.add(textArea);
	}

	public void addButtonClicked() {
		Grocery g = new Grocery(priceField.getText(),Integer.parseInt(descriptionField.getText()));
		String s = textArea.getText() + g + "\n";
		textArea.setText(s);
		catalog.addNewItem(descriptionField, priceField);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
