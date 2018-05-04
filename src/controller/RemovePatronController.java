package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Library;
import model.Patron;

public class RemovePatronController extends Controller<Library> {
    @FXML
    private Button removePatronBtn;
    @FXML private Button closeRemovePatronBtn;
    @FXML private ListView<Patron> patronsInLibraryLv;
    private ObservableList<Patron> patronsInLibrary = FXCollections.observableArrayList();
    private Library getLibrary(){
        return model;
    }

    public final ObservableList<Patron> getPatronsInLibrary() {
        return getLibrary().getPatrons();
    }


    @FXML public void handleRemovePatron(ActionEvent event) {
        Patron patron = patronsInLibraryLv.getSelectionModel().getSelectedItem();
        getLibrary().removePatron(patron);

    }
    @FXML public void handleCloseRemovePatron(ActionEvent event) {
        stage.close();
    }

}
