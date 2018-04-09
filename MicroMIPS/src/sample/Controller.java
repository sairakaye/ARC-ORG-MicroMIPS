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
    private TableView<OpcodeTableItem> opcodeTable;
    @FXML
    private TableColumn<OpcodeTableItem, String> colInstruction;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colHexOpcode;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colBit31to26;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colBit25to21;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colBit20to16;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colBit15to11;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colBit10t06;
    @FXML
    private TableColumn<OpcodeTableItem, String>  colBit5to0;

    private String[] savedCode;

    private ArrayList<Instruction> instructions = new ArrayList<Instruction>();

    @FXML
    private void processCode() {
        boolean error = false;
        savedCode = codingArea.getText().split("\\n");

        /* This will be use for error handling in code
        for (String code: savedCode) {

        }



        if (!error) {
            makeInstructions();
        } else {
            // display here the error dialog
        }
        */
        makeInstructions();

        ArrayList<OpcodeTableItem> opcodeTableItems = new ArrayList<>();

        for (Instruction i: instructions) {

        }

    }

    @FXML
    public void clear() {
        codingArea.clear();
        instructions.clear();
    }

    private void makeInstructions() {

        for(String line : savedCode) {
            String[] temp = line.split("\\s+");

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
