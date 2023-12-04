import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

// GroceryPane class for creating the UI components
class GroceryPane {

    // List to store all groceries
    private static ObservableList<Food> allGroceries = FXCollections.observableArrayList();

    public static VBox createGroceryPane() {
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

        Button fruitBtn = new Button("Fruit");
        // Button Styling
        fruitBtn.setTextAlignment(TextAlignment.CENTER);
        fruitBtn.setStyle("-fx-background-color: #613393;");
        fruitBtn.setTextFill(Color.WHITE);

        Button meatBtn = new Button("Meat");
        // Button Styling
        meatBtn.setTextAlignment(TextAlignment.CENTER);
        meatBtn.setStyle("-fx-background-color: #613393;");
        meatBtn.setTextFill(Color.WHITE);

        Button vegetableBtn = new Button("Vegetable");
        // Button Styling
        vegetableBtn.setTextAlignment(TextAlignment.CENTER);
        vegetableBtn.setStyle("-fx-background-color: #613393;");
        vegetableBtn.setTextFill(Color.WHITE);  

        // Search Bar
        TextField searchBar = new TextField("Search for items here");

        // List of Groceries
        ListView<String> groceryList = new ListView<>();

        // Set the action for Enter key press
        searchBar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
               String searchTerm = searchBar.getText().toLowerCase();

      // Filter and display items that match the search term
           List<String> matchingItems = allGroceries.stream()
                .map(Food::toString)
                .filter(item -> item.toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());

                groceryList.getItems().clear();
                 groceryList.getItems().addAll(matchingItems);
            }
});

        // Section that displays the lists
        HBox hbox = new HBox();
        // H Box Styling
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));


        //Dairy items
        Food cheese = new Dairy("Cheese", 1, 3.00);
        Food milk = new Dairy("Milk", 1, 2.50);
        Food yogurt = new Dairy("Yogurt", 1, 1.50);

        //This would hold dairy items
        ObservableList<Food> dairyItems = FXCollections.observableArrayList(cheese, milk, yogurt);

        //Fruit items
        Food apple = new Fruit("Apple", 1, 1.00);
        Food pineapple = new Fruit("Pineapple", 1, 3.00);
        Food watermelon = new Fruit("Watermelon", 1, 4.00);

        //holds fruit items
        ObservableList<Food> fruitItems = FXCollections.observableArrayList(apple, pineapple, watermelon);

        //Meat items
        Food chicken = new Meat("Chicken", 1, 8.00);
        Food cowMeat = new Meat("Cow Meat", 1, 11.00);
        Food ham = new Meat("Ham", 1, 7.00);

        //holds meat items
        ObservableList<Food> meatItems = FXCollections.observableArrayList(chicken, cowMeat, ham);

        //Vegetable items
        Food carrot = new Vegetable("Carrot", 1, 1.00);
        Food greenBeans = new Vegetable("Green Beans", 1, 6.00);
        Food bellPepper = new Vegetable("Bell Pepper", 1, 2.00);

        //holds vegi items
        ObservableList<Food> vegetableItems = FXCollections.observableArrayList(carrot, greenBeans, bellPepper);

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

        //DAIRY BUTTON

        // Set the action for the Dairy button
        dairyBtn.setOnAction(event -> {
        // Clear existing items and add dairy items as strings
        groceryList.getItems().clear();
    
        // Convert dairyItems to a list of strings before adding to groceryList
        List<String> dairyItemStrings = dairyItems.stream().map(Food::toString).collect(Collectors.toList());
        groceryList.getItems().addAll(dairyItemStrings);
        });

        //........................................................................................................................
        // FRUIT BUTTON

        // Set the action for the Dairy button
        fruitBtn.setOnAction(event -> {
            // Clear existing items and add dairy items as strings
            groceryList.getItems().clear();
        
            // Convert dairyItems to a list of strings before adding to groceryList
            List<String> fruitItemStrings = fruitItems.stream().map(Food::toString).collect(Collectors.toList());
            groceryList.getItems().addAll(fruitItemStrings);
            });

        //........................................................................................................................
        // MEAT BUTTON

        // Set the action for the Dairy button
        meatBtn.setOnAction(event -> {
        // Clear existing items and add dairy items as strings
        groceryList.getItems().clear();
    
        // Convert dairyItems to a list of strings before adding to groceryList
        List<String> meatItemStrings = meatItems.stream().map(Food::toString).collect(Collectors.toList());
        groceryList.getItems().addAll(meatItemStrings);
        });

        //........................................................................................................................
        // VEGETABLE BUTTON

        // Set the action for the Dairy button
        vegetableBtn.setOnAction(event -> {
            // Clear existing items and add dairy items as strings
            groceryList.getItems().clear();
        
            // Convert dairyItems to a list of strings before adding to groceryList
            List<String> vegetableItemStrings = vegetableItems.stream().map(Food::toString).collect(Collectors.toList());
            groceryList.getItems().addAll(vegetableItemStrings);
            });


            // Add all groceries to the allGroceries list
        allGroceries.addAll(dairyItems);
        allGroceries.addAll(fruitItems);
        allGroceries.addAll(meatItems);
        allGroceries.addAll(vegetableItems);


            
        // Area for two arrow buttons
        VBox buttonsArea = new VBox();
        // Button Area styling
        buttonsArea.setAlignment(Pos.CENTER);
        buttonsArea.setSpacing(10);
        buttonsArea.setPadding(new Insets(10));

        // Left and Right buttons
        Button left = new Button("<");
        Button right = new Button(">");
        // Button Styling
        left.setStyle("-fx-background-color: #613393;");
        left.setTextFill(Color.WHITE);
        right.setStyle("-fx-background-color: #613393;");
        right.setTextFill(Color.WHITE);

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
            
        // Total
        Label total = new Label("Total: ");

        //Adding Button actions
        left.setOnAction(event -> {
            //transfering selected items to the yourList box 
            System.out.println("Left button pressed");
            String selectedItems = yourList.getSelectionModel().getSelectedItem();
            if (selectedItems != null){
                yourList.getItems().remove(selectedItems);
                groceryList.getItems().add(selectedItems + "print added");
            }
        });

        //Adding Button actions
        right.setOnAction(event -> {
            //transfering selected items to the yourList box
            System.out.println("right button pressed"); 
            String selectedItems = yourList.getSelectionModel().getSelectedItem();
            if (selectedItems != null){
                groceryList.getItems().remove(selectedItems);
                yourList.getItems().add(selectedItems + "print added ");
            }
        });

        

        // Adding everything to the main V Box
        vBox.getChildren().addAll(navBar, hbox);
        navBar.getChildren().addAll(dairyBtn, fruitBtn, meatBtn, vegetableBtn, searchBar);
        hbox.getChildren().addAll(foodItemsList, buttonsArea, yourGroceryList);
        foodItemsList.getChildren().addAll(groceriesLabel, groceryList);
        buttonsArea.getChildren().addAll(left, right);
        yourGroceryList.getChildren().addAll(yourListLabel, yourList, total);
        
        return vBox;
    }
}