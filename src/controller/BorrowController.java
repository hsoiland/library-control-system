package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableIntegerValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Book;
import model.Library;
import model.Patron;


public class BorrowController extends Controller<Library>{
    @FXML private ListView<Book> booksToBorrowLv;
    @FXML private Button selectPatronBtn;
    @FXML private TextField patronIDTf;
    @FXML private Button borrowBookBtn;

    @FXML private void initialize() {
        patronIDTf.textProperty().addListener((o, oldText, newText) ->
                selectPatronBtn.setDisable(!newText.matches("[0-9]+")));
        booksToBorrowLv.getSelectionModel().selectedItemProperty().addListener((obs, oldBook, newBook)
                -> borrowBookBtn.setDisable(newBook == null));


    }
    private Library getLibrary() {
        return model;
    }

    private Book getBookToBorrow() {
        return booksToBorrowLv.getSelectionModel().getSelectedItem();
    }

    @FXML public void handleBorrowBook(ActionEvent event) {
        Book book = getBookToBorrow();
        getLibrary().getCatalogue().loanBookToPatron(book, getPatron());
    }
    private int getId(){
        return Integer.parseInt(patronIDTf.getText());
    }
    private Patron getPatron() {
        return getLibrary().getPatron(getId());
    }
    @FXML public void handleCloseBorrow() {
        stage.close();
    }
    @FXML public void handleSelectPatron(){
        booksToBorrowLv.setItems(getLibrary().getCatalogue().getBorrowableBooks(getPatron()));
}



}
