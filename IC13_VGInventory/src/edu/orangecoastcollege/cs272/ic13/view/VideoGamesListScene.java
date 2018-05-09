package edu.orangecoastcollege.cs272.ic13.view;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import edu.orangecoastcollege.cs272.ic13.model.VideoGame;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

// TODO: Implement the Initializable interface
public class VideoGamesListScene {

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<VideoGame> allVideoGamesLV;
	@FXML
	private ComboBox<String> publishersCB;
	@FXML
	private ComboBox<String> platformsCB;
	
	// TODO: Override the initialize method (let Eclipse generate the method for you)
	// In this method:
	// 1) Set the items of the allVideoGamesLV to all video games from the controller
	// 2) Set the items of the platformsCB to the distinct platforms from the controller
	// 3) Set the items of the publishersCB to the distinct publishers from the controller	
	
	@FXML
	public boolean addGameToInventory()
	{
		//TODO: Complete this method
		// 1) Get the selected video game from the allVideoGamesLV (use getSelectedItem())
		// 2) Use the controller to add the selected game to the inventory
		// 3) Return the result (as a boolean)

		return false;
	}
	
	@FXML
	public void viewInventory()
	{
		//TODO: Complete this method
		// 1) Use the ViewNavigator to load the VIEW_INVENTORY_SCENE with the title �User�s Video Games� 
	}

}
