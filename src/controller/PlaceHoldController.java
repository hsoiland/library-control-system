package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Book;
import model.Library;
import model.Patron;

public class PlaceHoldController extends Controller<Library> {
    @FXML
    private ListView<Book> booksToHoldLv;
    @FXML private Button selectPatronBtn;
    @FXML private TextField patronIDTf;
    @FXML private Label holdingLbl;
    @FXML private Button holdBtn;
    private Library getLibrary() {
        return model;
    }
    @FXML public void handleHoldBook(ActionEvent event) {
        Book book = booksToHoldLv.getSelectionModel().getSelectedItem();

        if (book.patronWithFirstHold() == null) {
            book.addHold(getPatron());
            holdingLbl.setText("this is success");

        }
        else{
            holdingLbl.setText("failure");
        }


    }
    public ObservableList<Book> getHoldableBooks() {
        return getLibrary().getCatalogue().getAllBooks();
    }
    private int getId(){
        return Integer.parseInt(patronIDTf.getText());
    }
    private Patron getPatron() {
        return getLibrary().getPatron(getId());
    }
    @FXML public void handleCloseHold() {
        stage.close();
    }

    @FXML private void initialize() {
        patronIDTf.textProperty().addListener((o, oldText, newText) ->
                selectPatronBtn.setDisable(!newText.matches("[0-9]+")));

        booksToHoldLv.getSelectionModel().selectedItemProperty().addListener((obs, oldBook, newBook)
                -> holdBtn.setDisable(newBook == null));


    }
}
