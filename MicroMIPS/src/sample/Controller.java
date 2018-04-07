package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private Button loadButton;
    @FXML
    private Button resetButton;
    @FXML
    private TextArea codingArea;
    @FXML
    private TableView opcodeTable;
    @FXML
    private TableColumn colInstruction;
    @FXML
    private TableColumn colHexOpcode;
    @FXML
    private TableColumn colBit31to26;
    @FXML
    private TableColumn colBit25to21;
    @FXML
    private TableColumn colBit20to16;
    @FXML
    private TableColumn colBit15to11;
    @FXML
    private TableColumn colBit10t06;
    @FXML
    private TableColumn colBit5to0;

    private String[] savedCode;

    @FXML
    public void processCode() {
        savedCode = codingArea.getText().split("\\n");
    }
}
