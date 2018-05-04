package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Author;
import model.Book;
import model.Genre;
import model.Library;

public class ShowBooksByAuthorController extends Controller<Library> {
    @FXML
    private ListView<Author> authorsInCatalogLv;
    @FXML private Button displayAuthorBtn;
    @FXML private ListView<Book> showBooksByAuthorLv;
    private Library getLibrary() {
        return model;
    }
    @FXML public void handleClose() {
        stage.close();
    }
    public final ObservableList<Author> getAuthorsInCatalog() {
        return getLibrary().getCatalogue().getAuthors();
    }
    @FXML private void initialize() {
        displayAuthorBtn.setOnAction(event1 -> {
            Author author = authorsInCatalogLv.getSelectionModel().getSelectedItem();
            showBooksByAuthorLv.setItems(getLibrary().getCatalogue().getBooksByAuthor(author));});
    }
}
