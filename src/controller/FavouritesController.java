package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Book;
import model.Library;

import javafx.scene.control.ListView;
import model.Patron;

public class FavouritesController extends Controller<Library>{
    @FXML private ListView<Book> favouriteBooksLv;
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
    @FXML public void handleCloseFavourites() {
        stage.close();
    }
    @FXML public void handleShowFavourites(){
        if(getPatron() == null){
            indicatorLbl.setText("Invalid Patron ID");
            favouriteBooksLv.setItems(null);
        }
        else {
            indicatorLbl.setText(getPatron().getName() + "'s favourite books:");
            favouriteBooksLv.setItems(getLibrary().getPatron(getId()).favourites());
        }
    }

}
