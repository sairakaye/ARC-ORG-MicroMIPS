package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

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

    private ArrayList<Instruction> instructions = new ArrayList<Instruction>();

    @FXML
    private void processCode() {
        savedCode = codingArea.getText().split("\\n");

        for (String code: savedCode) {

        }


        makeInstructions();
    }

    @FXML
    public void clear() {
        codingArea.clear();
        instructions.clear();
    }

    private void makeInstructions() {

        for(String line : savedCode) {
            String[] temp = line.split(" ");

            switch (temp[0]) {
                case "LD":
                    instructions.add(new LD(line));
                    break;

                case "SD":
                    instructions.add(new SD(line));
                    break;

                case "DADDIU":
                    instructions.add(new DADDIU(line));
                    break;

                case "DADDU":
                    instructions.add(new DADDU(line));
                    break;

                case "BC":
                    // TODO fix implementation of this
                    instructions.add(new BC(line));
                    break;

                case "BEQC":
                    // TODO fix implementation of this and create BEQC class
                    break;

                case "XORI":
                    instructions.add(new XORI(line));
                    break;
            }
        }

    }
}
