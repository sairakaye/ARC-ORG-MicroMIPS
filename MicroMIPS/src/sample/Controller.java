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

        opcodeTableItems = new ArrayList<>();

        for (int i = 0; i < instructions.size(); i++){
            Instruction ins = instructions.get(i);

            if (ins instanceof DADDIU)
                opcodeTableItems.add(new OpcodeTableItem(savedCode[i], ins.toHex(), ins.getOPCode(), ins.getRs(),
                                                         ins.getRt(), ins.getImm().substring(0, 5), ins.getImm().substring(5, 10), ins.getImm().substring(10, 16)));
            else if (ins instanceof DADDU)
                opcodeTableItems.add(new OpcodeTableItem(savedCode[i], ins.toHex(), ins.getOPCode(), ins.getRs(),
                                                         ins.getRt(), ins.getRd(), ins.getSa(), ins.getFunc()));
            else if (ins instanceof LD)
                opcodeTableItems.add(new OpcodeTableItem(savedCode[i], ins.toHex(), ins.getOPCode(), ins.getRs(),
                                                         ins.getRt(), ins.getImm().substring(0, 5), ins.getImm().substring(5, 10), ins.getImm().substring(10, 16)));
            else if (ins instanceof SD)
                opcodeTableItems.add(new OpcodeTableItem(savedCode[i], ins.toHex(), ins.getOPCode(), ins.getRs(),
                                                         ins.getRt(), ins.getImm().substring(0, 5), ins.getImm().substring(5, 10), ins.getImm().substring(10, 16)));
            else if (ins instanceof XORI)
                opcodeTableItems.add(new OpcodeTableItem(savedCode[i], ins.toHex(), ins.getOPCode(), ins.getRs(),
                                                         ins.getRt(), ins.getImm().substring(0, 5), ins.getImm().substring(5, 10), ins.getImm().substring(10, 16)));
        }
    }

    @FXML
    private void clear() {
        codingArea.clear();
        instructions.clear();
        NPC = 0;
    }

    @FXML
    private void runOneCycle() {
        currPC = NPC;
        System.out.println("IR: " + instructions.get(NPC).toHex());
        NPC += 4;
        System.out.println("NPC: " + NPC);

        A = registers.get("R" + instructions.get(currPC).getIR21to25());
        System.out.println("A: " + A);
        B = registers.get("R" + instructions.get(currPC).getIR16to20());
        System.out.println("B: " + B);
        Imm = instructions.get(currPC).getR15to0();
        System.out.println("IMM: " + Imm);
        
        System.out.println("ALUOUTPUT: ");
        System.out.println("COND: ");

        System.out.println("PC: " + NPC);
        System.out.println("LMD: ");
        System.out.println("Range: ");

        System.out.println("Rn: ");
}

    private void makeInstructions() {
        for(String line : savedCode) {

            String[] temp = line.split("\\s+");

            if (temp[0].indexOf("\\:") > 0) {
                String[] parsed = temp[0].split(" ");
                temp[0] = parsed[1];
            }

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
                    instructions.put(NPC, new BEQC(line));
                    break;

                case "XORI":
                    instructions.put(NPC, new XORI(line));
                    break;
            }
            NPC += 4;
        }
        NPC = 0;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NPC = 0;
        registers = new HashMap<>();
        instructions = new HashMap<>();
    }

    public void performOperation(String instruction){
        switch(instruction){
            case "DADDIU": break;
            case "DADDU": break;
            case "XORI": break;
            case "BEQC": break;
            case "BC": break;
            case "LD": break;
            case "SD": break;
        }
    }


    private String[] savedCode;
    private HashMap<String, String> registers;
    private ObservableList<String> values;
    private HashMap<Integer, Instruction> instructions;
    ArrayList<OpcodeTableItem> opcodeTableItems;
    private int currPC;
    private int NPC;
    private String A;
    private String B;
    private String Imm;
    private String ALUOutput;
    private int cond;
    private String PC;
    private String LMD;

}
