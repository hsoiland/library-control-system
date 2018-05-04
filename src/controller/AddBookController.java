package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Catalogue;
import model.Library;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class AddBookController extends Controller<Library>{
    @FXML private TextField titleTf;
    @FXML private TextField authorTf;
    @FXML private TextField genreTf;
    @FXML private Label bookBookedLbl;
    @FXML private Button addBookBtn;
    @FXML private Button closeAddBookBtn;

    @FXML
    private String getTitle() {
        return titleTf.getText();
    }
    @FXML
    private String getAuthor() {
        return authorTf.getText();
    }
    @FXML
    private String getGenre() {
        return genreTf.getText();
    }
    public final Library getLibrary() {
        return model;
    }

    @FXML private void handleCloseAddBook(ActionEvent event) {
        stage.close();
    }

    @FXML
    private void handleAddBook(ActionEvent event) {
        String title = getTitle();
        String author  = getAuthor();
        String genre  = getGenre();
        String success = "Book added to Catalogue";
        String failure = "That book is already in the Catalogue";
        if (!(getLibrary().getCatalogue().hasBook(title, author)) && !(title.isEmpty()) && !(getAuthor().isEmpty()) && !(getGenre().isEmpty())) {
            getLibrary().getCatalogue().addBook(title, author, genre);
            bookBookedLbl.setText(success);
        }
        else if (getLibrary().getCatalogue().hasBook(title, author))
        {
            bookBookedLbl.setText(failure);
        }
        else {
            bookBookedLbl.setText("");
        }

    }



}
