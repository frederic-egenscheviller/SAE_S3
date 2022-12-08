package fr.univ_amu.iut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Class used as a controller of home, home_logged, practice_menu giving them the switchTo methods
 */
public class SwitchController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private static String data;

    /**
     * Method used to switch between the scenes
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void switchToPane(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource() ;
        data = (String) node.getUserData();
        root = FXMLLoader.load(getClass().getResource(data));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1280, 720);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Find the breach");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method used to switch between the scenes where the player can play
     *
     * @param event
     */
    @FXML
    public void switchToPlay(ActionEvent event) {
        Node node = (Node) event.getSource() ;
        String userData = ((String)(node.getUserData()));       //userData = id,pageFxml
        String[] userDataArray = userData.split(",");     // ["id","pageFxml"]
        new PlayController(parseInt(userDataArray[0]), userDataArray[1] ,event);
    }
}