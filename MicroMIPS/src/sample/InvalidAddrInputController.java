package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InvalidAddrInputController {
    @FXML private Button OKButton;

    @FXML
    private void exit(){
        Stage stage = (Stage) OKButton.getScene().getWindow();
        stage.close();
    }
}
