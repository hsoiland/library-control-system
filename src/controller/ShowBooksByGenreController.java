package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Book;
import model.Genre;
import model.Library;
import javafx.event.ActionEvent;

public class ShowBooksByGenreController extends Controller<Library> {
    @FXML private ListView<Genre> genresInCatalogLv;
    @FXML private Button displayGenreBtn;
    @FXML private ListView<Book> showBooksByGenreLv;
    private Library getLibrary() {
        return model;
    }
    @FXML public void handleClose() {
        stage.close();
    }
    public final ObservableList<Genre> getGenresInCatalog() {
        return getLibrary().getCatalogue().getGenres();
    }
    @FXML private void initialize() {
        displayGenreBtn.setOnAction(event -> {
            Genre genre = genresInCatalogLv.getSelectionModel().getSelectedItem();
            showBooksByGenreLv.setItems(getLibrary().getCatalogue().getBooksInGenre(genre));});
    }
}
