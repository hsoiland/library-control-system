package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;
import model.Catalogue;
import model.Library;

public class ShowAllBooksController extends Controller<Library>{
    @FXML private TableView <Book> showAllBooksTv;
    @FXML private TableColumn<Book, ObservableStringValue> titleClm;
    @FXML private TableColumn<Book, ObservableStringValue> authorClm;
    @FXML private TableColumn<Book, ObservableStringValue> genreClm;
    private Library getLibrary() {
        return model;
    }
    @FXML public void handleClose() {
        stage.close();
    }
    public ObservableList<Book> getAllBooks(){
        return getLibrary().getCatalogue().getAllBooks();
    }
    @FXML private void initialize() {

    }



}
