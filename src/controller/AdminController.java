package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminController extends Controller<Library>{
    @FXML
    public void initialize() {

    }
    public final Library getLibrary() {
        return model;
    }
    @FXML private void handleAddPatron() throws Exception{
        ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());

    }
    @FXML private void handleRemPatron() throws Exception{
        ViewLoader.showStage(getLibrary(), "/view/removePatron.fxml", "Remove Patron", new Stage());

    }@FXML private void handleAddBook() throws Exception{
        ViewLoader.showStage(getLibrary(), "/view/addBook.fxml", "Add Book", new Stage());

    }@FXML private void handleRemBook() throws Exception{
        ViewLoader.showStage(getLibrary(), "/view/removeBook.fxml", "Remove Patron", new Stage());

    }@FXML private void handleCloseAdmin() throws Exception{
        stage.close();
    }

}
