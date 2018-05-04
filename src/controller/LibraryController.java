package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void handleCatalog() throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }

    @FXML private void handlePatRec() throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/record.fxml", "Record", new Stage());
    }

    @FXML private void handleFavBook() throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/favourites.fxml", "Favourites", new Stage());
    }

    @FXML private void handleExit(){
        Platform.exit();
    }

    @FXML private void handleAdmin() throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Menu", new Stage());
    }
}
