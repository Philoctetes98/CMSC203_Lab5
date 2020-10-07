import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	//  declare five buttons, a label, and a textfield
	Button buttonOne, buttonTwo, buttonThree,
	buttonFour, buttonFive, buttonSix;
	Label label;
	TextField textfield;
	//  declare two HBoxes
	HBox hboxOne, hboxTwo;
	//declare VBox
	VBox vbox;
	
	//student Task #4:
	DataManager dataMan;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	public FXMainPane() {
		//  instantiate the buttons, label, and textfield
		buttonOne = new Button("Hello");
		buttonTwo = new Button("Howdy");
		buttonThree = new Button("Chinese");
		buttonFour = new Button("French");
		buttonFive = new Button("Clear");
		buttonSix = new Button("Exit");
		
		label = new Label("Feedback: ");
		textfield = new TextField();
		
	    //  instantiate the HBoxes
		HBox hboxOne = new HBox();
		HBox hboxTwo = new HBox();
		// instantiate the VBox
		VBox vbox = new VBox();
		
		//  instantiate the DataManager instance
		dataMan = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(buttonOne, new Insets(10));
		HBox.setMargin(buttonTwo, new Insets(10));
		HBox.setMargin(buttonThree, new Insets(10));
		HBox.setMargin(buttonFour, new Insets(10));
		HBox.setMargin(buttonFive, new Insets(10));
		HBox.setMargin(buttonSix, new Insets(10));
		hboxOne.setAlignment(Pos.CENTER);
		hboxTwo.setAlignment(Pos.CENTER);
		
		//  add the label and textfield to one of the HBoxes
		hboxOne.getChildren().addAll(buttonOne, buttonTwo,
				buttonThree, buttonFour, buttonFive, buttonSix);
		//  add the buttons to the other HBox
		hboxTwo.getChildren().addAll(label,textfield);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hboxOne,hboxTwo);
		
		//Register the events
		buttonOne.setOnAction(new ButtonHandler());
		buttonTwo.setOnAction(new ButtonHandler());
		buttonThree.setOnAction(new ButtonHandler());
		buttonFour.setOnAction(new ButtonHandler());
		buttonFive.setOnAction(new ButtonHandler());
		buttonSix.setOnAction(new ButtonHandler());
	}
    //  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{
		//implements the handle method
		public void handle(ActionEvent event) {
			//if the user selects the hello button
			if (event.getTarget() == buttonOne)
			{
				textfield.setText(dataMan.getHello());
			}
			//if the user selects the howdy button
			else if (event.getTarget() == buttonTwo)
			{
				textfield.setText(dataMan.getHowdy());
			}
			//if the user selects the hello in Chinese button
			else if (event.getTarget() == buttonThree)
			{
				textfield.setText(dataMan.getChinese());
			}
			//if the user selects the hello in French button
			else if (event.getTarget() == buttonFour)
			{
				textfield.setText(dataMan.getFrench());
			}
			//if the user selects the clear button
			else if (event.getTarget() == buttonFive)
			{
				textfield.setText("");
			}
			//if the user decides to exit the platform
			else if (event.getTarget() == buttonSix)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
