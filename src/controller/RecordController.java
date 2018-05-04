package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Book;
import model.Library;
import model.Patron;

import java.awt.event.ActionEvent;

public class RecordController extends Controller<Library> {
    @FXML private ListView<Book> currentlyBorrowedBooksLv;
    @FXML private ListView<Book> borrowingHistoryBooksLv;
    @FXML private TextField IDTf;
    @FXML private Button showBtn;
    @FXML private Label indicatorLbl;
    @FXML private Button closeBtn;
    @FXML private void initialize() {
        IDTf.textProperty().addListener((o, oldText, newText) ->
                showBtn.setDisable(!newText.matches("[0-9]+")));
    }
    private Library getLibrary() {
        return model;
    }
    private int getId(){
        return Integer.parseInt(IDTf.getText());
    }
    private Patron getPatron() {
        return getLibrary().getPatron(getId());
    }
    @FXML public void handleCloseRecord() {
        stage.close();
    }
    @FXML public void handleShowRecord(){
        if (getPatron() == null){
            indicatorLbl.setText("Invalid Patron ID");
            currentlyBorrowedBooksLv.setItems(null);
            borrowingHistoryBooksLv.setItems(null);
        }
        else {
            indicatorLbl.setText(getId() + " " + getPatron().getName());
            currentlyBorrowedBooksLv.setItems(getLibrary().getCatalogue().getPatron(getId()).currentlyBorrowed());
            borrowingHistoryBooksLv.setItems(getLibrary().getCatalogue().getPatron(getId()).borrowingHistory());
        }
    }


}
