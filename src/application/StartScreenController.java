package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartScreenController extends Main {
	public static Car car;
	@FXML
	private ImageView img_car;
	@FXML
	private Button btn_start;

	// Event Listener on Button.onMouseClicked
	@FXML
	public void gasDefaultPressed(MouseEvent event) {
		//transmission type, horsepower, torque, max speed, weight, width in cm, height in cm, tire diameter in cm, fuel capacity, consumption rate
		car = new GasolineCar(new ManualTransmission(), 300, 420, 260, 1245, 181, 131, 670, 78, 7.85);
        Image ferrariImage = new Image(getClass().getResourceAsStream("/Silverhand_Porche.jpg"));
        img_car.setImage(ferrariImage);
        img_car.setVisible(true);
        btn_start.setVisible(true);
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void electricDefaultPressed(MouseEvent event) {
	    // horsepower, torque, max speed, weight, width in cm, height in cm, tire diameter in cm, battery capacity, consumption rate
	    car = new ElectricCar(710, 950, 402, 1995, 204, 132, 69, 100, 10.0);
	    Image teslaImage = new Image(getClass().getResourceAsStream("/quadra_v.jpg"));
	    img_car.setImage(teslaImage);
	    img_car.setVisible(true);
	    btn_start.setVisible(true);
	}
	// Event Listener on Button[#btn_start].onMouseClicked
	@FXML
	public void startBtnClicked(MouseEvent event) throws Exception {
		// Load the main scene from an FXML file
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
	    Parent root = loader.load();
	    Scene scene_main = new Scene(root, 1150, 700);

	    // Get the primary stage and set the new scene
	    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    primaryStage.setScene(scene_main);
	}
}
