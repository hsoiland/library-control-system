package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Catalogue;
import model.Library;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import model.Patron;

public class AddPatronController extends Controller<Library> {
    @FXML private TextField IDTf;
    @FXML private TextField patronNameTf;
    @FXML private Label patronAddedLbl;
    @FXML private Button addPatronBtn;
    @FXML private Button closeAddPatronBtn;

    @FXML private int getID() {
        return Integer.parseInt(IDTf.getText());
    }
    @FXML private String getPatronName() {
        return patronNameTf.getText();
    }
    public final Library getLibrary() {
        return model;
    }

    @FXML private void handleCloseAddPatron(ActionEvent event) {
        stage.close();
    }
    @FXML private void handleAddPatron(ActionEvent event) {
        int id = -1;
        String name = getPatronName();
        String emptyID = IDTf.getText();
        if (!emptyID.equals("") && IDTf.getText().matches("[1-9]+")){id = getID();}
        String success = "Patron Added.";
        String failure = "Patron already exists!";


        if (id == -1 && emptyID.equals("")){
            patronAddedLbl.setText("");
        }
        else if (getLibrary().getPatron(id) == null && IDTf.getText().matches("[1-9]+")) {
            getLibrary().addPatron(id, name);
            patronAddedLbl.setText(success);
        }
        else if (!(IDTf.getText().matches("[1-9]+"))){
            patronAddedLbl.setText("");
        }
        else {
            patronAddedLbl.setText(failure);
        }





    }


}
