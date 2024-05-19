package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BrandBook {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The list of brands or designers */
    private ArrayList<Brand> brands;

    /** The ListView containing the names of brands or designers */
    private ListView<String> listView;

    /** The text field for the user to enter a brand or designer */
    private TextField inputField;

    /**
     * Constructs a new BrandBook object with the given window, width, and height.
     * Initializes an empty ArrayList of brands, a ListView of strings, and a TextField for input.
     *
     * @param window the Stage object representing the window
     * @param width the width of the window
     * @param height the height of the window
     */
    public BrandBook(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        brands = new ArrayList<Brand>();
        listView = new ListView<String>();
        inputField = new TextField();
    }
    
    /**
     * Sets the title of the window to "BrandBook", creates the main scene, adds the stylesheet to the scene,
     * sets the scene to the window, and shows the window.
     */
    public void startApp() {
        window.setTitle("BrandBook");

        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the BrandBook application.
     * 
     * @return the main scene for the application
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("BrandBook");
        Button addButton = createAddButton();

        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(titleLabel, inputField, addButton, listView);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Adds a new brand to the list of brands.
     * It first retrieves the text from the input field, checks if it's not empty,
     * then creates a new Brand object with the input text and adds it to the brands list.
     * After adding the new brand, it sorts the brands list, refreshes the list view,
     * and finally clears the input field.
     */
    public void addBrand() {
        String newBrand = inputField.getText();

        if (!newBrand.isEmpty()) {
            brands.add(new Brand(newBrand));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the brands in the 'brands' list based on their names.
     */
    public void sortBrands() {
        

    }

    /**
     * Refreshes the list of brands displayed in the listView.
     * It first clears the listView, then iterates over the 'brands' list,
     * adding each brand's name to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (Brand brand : brands) {
            listView.getItems().add(brand.getName());
        }
    }

    /**
     * Creates a button to add a new brand or designer.
     * 
     * @return the button to add a new brand or designer
     */
    public Button createAddButton() {
        Button tempButton = new Button("Add Brand / Designer");

        tempButton.setOnAction(event -> {
            addBrand();
        });

        return tempButton;
    }

}
