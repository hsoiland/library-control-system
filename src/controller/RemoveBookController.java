package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Catalogue;
import javafx.collections.ObservableList;
import model.Library;
import javafx.scene.control.ListView;
import model.Book;
import javafx.scene.control.MultipleSelectionModel;


import javafx.event.ActionEvent;
import java.util.Collection;
import java.util.List;

public class RemoveBookController extends Controller<Library> {
    @FXML private Button removeBookBtn;
    @FXML private Button closeRemoveBookBtn;
    @FXML private ListView<Book> booksInCatalogueLv;
    private ObservableList<Book> booksInCatalogue = FXCollections.observableArrayList();
    private Library getLibrary(){
        return model;
    }

    public final ObservableList<Book> getBooksInCatalogue() {
        return getLibrary().getCatalogue().getBooksOnShelf();
    }


    @FXML public void handleRemoveBook(ActionEvent event) {
        Book book = booksInCatalogueLv.getSelectionModel().getSelectedItem();
        getLibrary().getCatalogue().removeBook(book);

    }
    @FXML public void handleCloseRemoveBook(ActionEvent event) {
        stage.close();
    }

}
