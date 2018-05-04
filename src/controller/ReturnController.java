package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Book;
import model.Library;
import model.Patron;

public class ReturnController extends Controller<Library> {
    @FXML
    private ListView<Book> booksToReturnLv;
    @FXML
    private Button selectPatronBtn;
    @FXML private Button returnBookBtn;
    @FXML

    private TextField patronIDTf;
    @FXML
    private void initialize() {
        patronIDTf.textProperty().addListener((o, oldText, newText) ->
                selectPatronBtn.setDisable(!newText.matches("[0-9]+")));
        booksToReturnLv.getSelectionModel().selectedItemProperty().addListener((obs, oldBook, newBook)
                -> returnBookBtn.setDisable(newBook == null));

    }
    private Library getLibrary() {
        return model;
    }

    private Book getBookToReturn() {
        return booksToReturnLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void handleReturnBook(ActionEvent event) {
        Book book = getBookToReturn();
        getLibrary().getCatalogue().returnBookFromPatron(book, getPatron());

    }
    private int getId() {
        return Integer.parseInt(patronIDTf.getText());
    }

    private Patron getPatron() {
        return getLibrary().getPatron(getId());
    }

    @FXML void handleSelectPatron() {
        if(getPatron() == null) {
            booksToReturnLv.setItems(null);
        }
        else {
            booksToReturnLv.setItems(getLibrary().getCatalogue().getPatron(getId()).currentlyBorrowed());
        }
    }

    @FXML
    public void handleCloseReturn() {
        stage.close();
    }


}
