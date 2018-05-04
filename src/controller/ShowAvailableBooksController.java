package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Book;
import model.Library;

public class ShowAvailableBooksController extends Controller<Library>{
    @FXML
    private TableView<Book> showBooksOnShelfTv;
    @FXML private TableColumn<Book, ObservableStringValue> titleClm;
    @FXML private TableColumn<Book, ObservableStringValue> authorClm;
    @FXML private TableColumn<Book, ObservableStringValue> genreClm;
    private Library getLibrary() {
        return model;
    }
    @FXML public void handleClose() {
        stage.close();
    }
    public ObservableList<Book> getBooksOnShelf(){
        return getLibrary().getCatalogue().getBooksOnShelf();
    }
    @FXML private void initialize() {

    }

}
