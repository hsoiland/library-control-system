package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class CatalogueController extends Controller<Library>{

    @FXML
    public void initialize() {

    }
    public final Library getLibrary() {
        return model;
    }
    @FXML private void handleAllBooks() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }
    @FXML private void handleAvailableBooks() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }
    @FXML private void handleBooksByGenre() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
    }
    @FXML private void handleBooksByAuthor() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
    }
    @FXML private void handleBorrowBooks() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/borrow.fxml", "Borrow a Book", new Stage());
    }
    @FXML private void handleReturnBooks() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/return.fxml", "Return a Book", new Stage());
    }
    @FXML private void handlePlaceHold() throws Exception {
        ViewLoader.showStage(getLibrary(),"/view/placeHold.fxml", "Place a Hold", new Stage());
    }
    @FXML private void handleExitCatalogue() throws Exception {
        stage.close();
    }






}
