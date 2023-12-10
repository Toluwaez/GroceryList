import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

// GroceryPane class for creating the UI components
class GroceryPane {

    // List to store all groceries
    private static ObservableList<Food> allGroceries = FXCollections.observableArrayList();

    public static VBox createGroceryPane() {
        
        /*******************************************************************************************************************/
        // List of Groceries
        ListView<String> groceryList = new ListView<>();

        // Dairy items
        Food cheese = new Dairy("Cheese", 1, 3.00);
        Food milk = new Dairy("Milk", 1, 2.50);
        Food yogurt = new Dairy("Yogurt", 1, 1.50);

        // List of Dairy Items
        ObservableList<Food> dairyItems = FXCollections.observableArrayList(cheese, milk, yogurt);

        // Fruit items
        Food apple = new Fruit("Apple", 1, 1.00);
        Food pineapple = new Fruit("Pineapple", 1, 3.00);
        Food watermelon = new Fruit("Watermelon", 1, 4.00);

        // List of Fruit Items
        ObservableList<Food> fruitItems = FXCollections.observableArrayList(apple, pineapple, watermelon);

        // Meat items
        Food chicken = new Meat("Chicken", 1, 8.00);
        Food steak = new Meat("Steak", 1, 11.00);
        Food ham = new Meat("Ham", 1, 7.00);

        // List of Meat Items
        ObservableList<Food> meatItems = FXCollections.observableArrayList(chicken, steak, ham);

        // Vegetable items
        Food carrot = new Vegetable("Carrot", 1, 1.00);
        Food greenBeans = new Vegetable("Green Beans", 1, 6.00);
        Food bellPepper = new Vegetable("Bell Pepper", 1, 2.00);

        // List of Vegetable Items
        ObservableList<Food> vegetableItems = FXCollections.observableArrayList(carrot, greenBeans, bellPepper);

        /*******************************************************************************************************************/

        // Main application
        VBox vBox = new VBox();

        // NavBar
        HBox navBar = new HBox();
        // NavBar styling
        navBar.setStyle("-fx-background-color: #D9D9D9;");
        navBar.setSpacing(10);
        navBar.setPadding(new Insets(15));

        // Buttons in NavBar
        Button dairyBtn = new Button("Dairy");
        // Button styling
        dairyBtn.setTextAlignment(TextAlignment.CENTER);
        dairyBtn.setStyle("-fx-background-color: #613393;");
        dairyBtn.setTextFill(Color.WHITE);

        // Set the action for the Dairy button
        dairyBtn.setOnAction(event -> {
            // Clear existing items and add dairy items as strings
            groceryList.getItems().clear();
        
            // Convert dairyItems to a list of strings before adding to groceryList
            List<String> dairyItemStrings = dairyItems.stream().map(Food::toString).collect(Collectors.toList());
            groceryList.getItems().addAll(dairyItemStrings);
        });

        Button fruitBtn = new Button("Fruit");
        // Button Styling
        fruitBtn.setTextAlignment(TextAlignment.CENTER);
        fruitBtn.setStyle("-fx-background-color: #613393;");
        fruitBtn.setTextFill(Color.WHITE);

        // Set the action for the Fruit button
        fruitBtn.setOnAction(event -> {
            // Clear existing items and add fruit items as strings
            groceryList.getItems().clear();
        
            // Convert fruitItems to a list of strings before adding to groceryList
            List<String> fruitItemStrings = fruitItems.stream().map(Food::toString).collect(Collectors.toList());
            groceryList.getItems().addAll(fruitItemStrings);
            });

        Button meatBtn = new Button("Meat");
        // Button Styling
        meatBtn.setTextAlignment(TextAlignment.CENTER);
        meatBtn.setStyle("-fx-background-color: #613393;");
        meatBtn.setTextFill(Color.WHITE);

        // Set the action for the Meat button
        meatBtn.setOnAction(event -> {
            // Clear existing items and add meat items as strings
            groceryList.getItems().clear();
        
            // Convert meatItems to a list of strings before adding to groceryList
            List<String> meatItemStrings = meatItems.stream().map(Food::toString).collect(Collectors.toList());
            groceryList.getItems().addAll(meatItemStrings);
        });

        Button vegetableBtn = new Button("Vegetable");
        // Button Styling
        vegetableBtn.setTextAlignment(TextAlignment.CENTER);
        vegetableBtn.setStyle("-fx-background-color: #613393;");
        vegetableBtn.setTextFill(Color.WHITE); 
        
        // Set the action for the Vegetable button
        vegetableBtn.setOnAction(event -> {
            // Clear existing items and add vegetable items as strings
            groceryList.getItems().clear();
        
            // Convert vegetableItems to a list of strings before adding to groceryList
            List<String> vegetableItemStrings = vegetableItems.stream().map(Food::toString).collect(Collectors.toList());
            groceryList.getItems().addAll(vegetableItemStrings);
        });

        /*******************************************************************************************************************/
        
        // Search Bar
        TextField searchBar = new TextField("Search for items here");

        // Set the action for Enter key press
        searchBar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
               String searchTerm = searchBar.getText().toLowerCase();

                // Filter and display items that match the search term
                List<String> matchingItems = allGroceries.stream().map(Food::toString).filter(item -> item.toLowerCase().contains(searchTerm)).collect(Collectors.toList());
                groceryList.getItems().clear();
                groceryList.getItems().addAll(matchingItems);
            }
        });

        /*******************************************************************************************************************/

        // Section that displays the lists
        HBox hbox = new HBox();
        // H Box Styling
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));

        // List of groceries and label
        VBox foodItemsList = new VBox();
        // V box styling
        foodItemsList.setSpacing(5);

        // Label for groceries list
        Label groceriesLabel = new Label("Groceries");
        // Label Styling
        groceriesLabel.setStyle("-fx-background-color: #613393;");
        groceriesLabel.setTextFill(Color.WHITE);
        groceriesLabel.setPadding(new Insets(10));

        // Add all groceries to the allGroceries list
        allGroceries.addAll(dairyItems);
        allGroceries.addAll(fruitItems);
        allGroceries.addAll(meatItems);
        allGroceries.addAll(vegetableItems);

        // List of your groceries with label and total
        VBox yourGroceryList = new VBox();
        // V box styling
        yourGroceryList.setSpacing(5);

        // Your grocery list label
        Label yourListLabel = new Label("Your List");
        // Label Styling
        yourListLabel.setStyle("-fx-background-color: #613393;");
        yourListLabel.setTextFill(Color.WHITE);
        yourListLabel.setPadding(new Insets(10));

        // List of your groceries
        ListView<String> yourList = new ListView<>();
        
        // Linked List for yourList
        LinkedList<String> linkedYourList = new LinkedList<>();

        // Method call to add items from the list view to the linked list whenever the listview is changes
        yourList.getItems().addListener((ListChangeListener<String>) change -> {
            linkedYourList.clear();
            linkedYourList.addAll(yourList.getItems());
        });
        
        // MIME type used to transfer information between two objects
        final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

        // Drag and Drop Event
        groceryList.setOnDragDetected(event -> {
            String selectedItem = groceryList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Dragboard dragboard = groceryList.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.put(SERIALIZED_MIME_TYPE, selectedItem);
                dragboard.setContent(content);
            }
            event.consume();
        });

        yourList.setOnDragOver(event -> {
            if (event.getGestureSource() != yourList && event.getDragboard().hasContent(SERIALIZED_MIME_TYPE)) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        yourList.setOnDragDropped((DragEvent event) -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;

            if (dragboard.hasContent(SERIALIZED_MIME_TYPE)) {
                String item = (String) dragboard.getContent(SERIALIZED_MIME_TYPE);
                yourList.getItems().add(item);
                success = true;
            }

            event.setDropCompleted(success);
            event.consume();
        });

        /*******************************************************************************************************************/

        // Total
        Label total = new Label("Total: ");

        // Adding everything to the main V Box
        vBox.getChildren().addAll(navBar, hbox);
        navBar.getChildren().addAll(dairyBtn, fruitBtn, meatBtn, vegetableBtn, searchBar);
        hbox.getChildren().addAll(foodItemsList, yourGroceryList);
        foodItemsList.getChildren().addAll(groceriesLabel, groceryList);
        yourGroceryList.getChildren().addAll(yourListLabel, yourList, total);
        
        return vBox;
    }
}