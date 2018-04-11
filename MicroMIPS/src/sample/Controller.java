package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private Button loadButton;

    @FXML private Button resetButton;

    @FXML private TextArea codingArea;

    @FXML private ListView register_list;

    @FXML private TableView<OpcodeTableItem> opcodeTable;

    @FXML private TableColumn<OpcodeTableItem, String> colInstruction;

    @FXML private TableColumn<OpcodeTableItem, String>  colHexOpcode;

    @FXML private TableColumn<OpcodeTableItem, String>  colBit31to26;

    @FXML private TableColumn<OpcodeTableItem, String>  colBit25to21;

    @FXML private TableColumn<OpcodeTableItem, String>  colBit20to16;

    @FXML private TableColumn<OpcodeTableItem, String>  colBit15to11;

    @FXML private TableColumn<OpcodeTableItem, String>  colBit10t06;

    @FXML private TableColumn<OpcodeTableItem, String>  colBit5to0;

    private String[] savedCode;

    private HashMap<String, String> registers;

    private ObservableList<String> values;

    private HashMap<Integer, Instruction> instructions;

    private int NPC;

    @FXML
    private void showCyclePane() {
        values = FXCollections.observableArrayList();
        for (int i = 0; i < 32; i++)
            registers.put("R" + i, "0000000000000000");

        for (int i = 0; i < registers.size(); i++)
            values.add("R" + i + " = 0000000000000000");

        register_list.setItems(values);
    }

    @FXML
    private void processCode() {
        boolean isValid = false;
        savedCode = codingArea.getText().split("\\n");

        for (String code: savedCode) {
            if (code.contains("DADDIU"))
                isValid = checkingDADDIU(code);
            else if (code.contains("XORI"))
                isValid = checkingXORI(code);
        }

        /*

        if (!error) {
            makeInstructions();
        } else {
            // display here the error dialog
        }

        makeInstructions();

        ArrayList<OpcodeTableItem> opcodeTableItems = new ArrayList<>();

//        for (Instruction i: instructions) {
//
//        }
*/
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
                    instructions.put(NPC, new LD(line));
                    break;

                case "SD":
                    instructions.put(NPC, new SD(line));
                    break;

                case "DADDIU":
                    instructions.put(NPC, new DADDIU(line));
                    break;

                case "DADDU":
                    instructions.put(NPC, new DADDU(line));
                    break;

                case "BC":
                    // TODO fix implementation of this
                    instructions.put(NPC, new BC(line));
                    break;

                case "BEQC":
                    // TODO fix implementation of this and create BEQC class
                    break;

                case "XORI":
                    instructions.put(NPC, new XORI(line));
                    break;
            }
            NPC += 4;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NPC = 0;
        registers = new HashMap<>();
    }

    public boolean checkingDADDIU(String codeLine) {
        ArrayList<String> codeParts = new ArrayList<String>();
        String[] splitter = codeLine.split(",");
        StringBuilder errorMessage = new StringBuilder();

        try {
            if (splitter[0].contains(":")) {
                // label
                codeParts.add(splitter[0].substring(0, splitter[0].indexOf(":")));

                // rt
                String[] checker2 = splitter[0].substring(splitter[0].indexOf(":") + 1).trim().split("\\s+");

                if (checker2[0].equalsIgnoreCase("DADDIU")) {
                    codeParts.add(checker2[0]);

                    if (checker2[1].startsWith("R")) {
                        codeParts.add(checker2[1]);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {
                String[] checker2 = splitter[0].trim().split("\\s+");

                if (checker2[0].equalsIgnoreCase("DADDIU")) {
                    codeParts.add(checker2[0]);
                    if (checker2[1].startsWith("R")) {
                        codeParts.add(checker2[1]);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            // for rs
            if (splitter[1].trim().startsWith("R")) {
                codeParts.add(splitter[1].trim());
            } else {
                return false;
            }

            String immediate = splitter[2].trim();

            try {
                if (immediate.startsWith("#")) {
                    Integer toDecimal = Integer.parseInt(immediate.substring(immediate.indexOf("#") + 1), 16);

                    if (!(toDecimal >= 0 && toDecimal <= 65535)) {
                        return false;
                    } else {
                        codeParts.add(immediate.substring(immediate.indexOf("#")));
                    }
                } else if (immediate.startsWith("0x")) {
                    int toDecimal = Integer.parseInt(immediate.substring(immediate.indexOf("x") + 1), 16);

                    if (!(toDecimal >= 0 && toDecimal <= 65535)) {
                        return false;
                    } else {
                        codeParts.add(immediate.substring(immediate.indexOf("0")));
                    }
                } else {
                    int toDecimal = Integer.parseInt(immediate.substring(0));
                    codeParts.add(Integer.toString(toDecimal));
                }
            } catch (Exception e) {
                return false;
            }

            for (String c: codeParts)
                System.out.println(c);

            // Assuming all is correct
            try {
                int rt, rs;
                if (!codeParts.get(0).equalsIgnoreCase("DADDIU")) {
                    rt = Integer.parseInt(codeParts.get(2).substring(codeParts.get(2).indexOf("R") + 1));
                    rs = Integer.parseInt(codeParts.get(3).substring(codeParts.get(3).indexOf("R") + 1));
                } else {
                    rt = Integer.parseInt(codeParts.get(1).substring(codeParts.get(1).indexOf("R") + 1));
                    rs = Integer.parseInt(codeParts.get(2).substring(codeParts.get(2).indexOf("R") + 1));
                }

                if ((rt >= 0 && rt <= 31) && (rs >= 0 && rs <= 31))
                    return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public boolean checkingXORI(String codeLine) {
        ArrayList<String> codeParts = new ArrayList<String>();
        String[] splitter = codeLine.split(",");
        StringBuilder errorMessage = new StringBuilder();

        try {
            if (splitter[0].contains(":")) {
                // label
                codeParts.add(splitter[0].substring(0, splitter[0].indexOf(":")));

                // rt
                String[] checker2 = splitter[0].substring(splitter[0].indexOf(":") + 1).trim().split("\\s+");

                if (checker2[0].equalsIgnoreCase("XORI")) {
                    codeParts.add(checker2[0]);

                    if (checker2[1].startsWith("R")) {
                        codeParts.add(checker2[1]);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {
                String[] checker2 = splitter[0].trim().split("\\s+");

                if (checker2[0].equalsIgnoreCase("XORI")) {
                    codeParts.add(checker2[0]);
                    if (checker2[1].startsWith("R")) {
                        codeParts.add(checker2[1]);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            // for r2
            if (splitter[1].trim().startsWith("R")) {
                codeParts.add(splitter[1].trim());
            } else {
                return false;
            }

            String immediate = splitter[2].trim();

            try {
                if (immediate.startsWith("#")) {
                    Integer toDecimal = Integer.parseInt(immediate.substring(immediate.indexOf("#") + 1), 16);

                    if (!(toDecimal >= 0 && toDecimal <= 65535)) {
                        return false;
                    } else {
                        codeParts.add(immediate.substring(immediate.indexOf("#")));
                    }
                } else if (immediate.startsWith("0x")) {
                    int toDecimal = Integer.parseInt(immediate.substring(immediate.indexOf("x") + 1), 16);

                    if (!(toDecimal >= 0 && toDecimal <= 65535)) {
                        return false;
                    } else {
                        codeParts.add(immediate.substring(immediate.indexOf("0")));
                    }
                } else {
                    int toDecimal = Integer.parseInt(immediate.substring(0));
                    codeParts.add(Integer.toString(toDecimal));
                }
            } catch (Exception e) {
                return false;
            }

            for (String c: codeParts)
                System.out.println(c);

            // Assuming all is correct
            try {
                int rt = 0, rs = 0;
                if (!codeParts.get(0).equalsIgnoreCase("XORI")) {
                    rt = Integer.parseInt(codeParts.get(2).substring(codeParts.get(2).indexOf("R") + 1));
                    rs = Integer.parseInt(codeParts.get(3).substring(codeParts.get(3).indexOf("R") + 1));
                } else {
                    rt = Integer.parseInt(codeParts.get(1).substring(codeParts.get(1).indexOf("R") + 1));
                    rs = Integer.parseInt(codeParts.get(2).substring(codeParts.get(2).indexOf("R") + 1));
                }

                if ((rt >= 0 && rt <= 31) && (rs >= 0 && rs <= 31))
                    return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
