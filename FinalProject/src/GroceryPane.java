import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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

    // Linked List for yourList
    private static LinkedList<Food> linkedYourList = new LinkedList<>();

    // Total
    private static Label total = new Label("Total: ");

    public static VBox createGroceryPane() {
        
        /*******************************************************************************************************************/
        // List of Groceries
        ListView<Food> groceryList = new ListView<>();

        // Dairy items
        Food cheese = new Dairy("Cheese", 1, 3.00);
        Food milk = new Dairy("Milk", 1, 2.50);
        Food yogurt = new Dairy("Yogurt", 1, 1.50);
        Food icecream = new Dairy("Icecream", 1, 2.00);
        Food butter = new Dairy("Butter", 1, 1.00);
        Food custard = new Dairy("Custard", 1, 4.00);

        // List of Dairy Items
        ObservableList<Food> dairyItems = FXCollections.observableArrayList(cheese, milk, yogurt, icecream, butter, custard);

        // Fruit items
        Food apple = new Fruit("Apple", 1, 1.00);
        Food pineapple = new Fruit("Pineapple", 1, 3.00);
        Food watermelon = new Fruit("Watermelon", 1, 4.00);
        Food pear = new Fruit("Pear", 1, 4.00);
        Food banana = new Fruit("Banana", 1, 4.00);
        Food grapes = new Fruit("Grapes", 1, 2.00);

        // List of Fruit Items
        ObservableList<Food> fruitItems = FXCollections.observableArrayList(apple, pineapple, watermelon, pear, banana, grapes);

        // Meat items
        Food chicken = new Meat("Chicken", 1, 8.00);
        Food steak = new Meat("Steak", 1, 11.00);
        Food ham = new Meat("Ham", 1, 7.00);
        Food pork = new Meat("Pork", 1, 7.00);
        Food beef = new Meat("Beef", 1, 7.00);
        Food turkey = new Meat("Turkey", 1, 7.00);

        // List of Meat Items
        ObservableList<Food> meatItems = FXCollections.observableArrayList(chicken, steak, ham, pork, beef, turkey);

        // Vegetable items
        Food carrot = new Vegetable("Carrot", 1, 1.00);
        Food greenBeans = new Vegetable("Green Beans", 1, 6.00);
        Food bellPepper = new Vegetable("Bell Pepper", 1, 2.00);
        Food springOnions = new Vegetable("Spring Onions", 1, 2.00);
        Food onion = new Vegetable("Onion", 1, 2.00);
        Food tomatoe = new Vegetable("Tomatoe", 1, 2.00);

        // List of Vegetable Items
        ObservableList<Food> vegetableItems = FXCollections.observableArrayList(carrot, greenBeans, bellPepper, springOnions, onion, tomatoe);

        // Baked Goods
        Food bread = new BakedGoods("Bread", 1, 5.50);
        Food muffin = new BakedGoods("Muffin", 1, 2.00);
        Food cake = new BakedGoods("Cake", 1, 12.00);
        Food donut = new BakedGoods("Donut", 1, 2.00);
        Food cupcake = new BakedGoods("Cupcake", 1, 3.50);

        ObservableList<Food> bakedGoodsItems = FXCollections.observableArrayList(bread, muffin, cake, donut, cupcake);
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
            groceryList.getItems().addAll(dairyItems);
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
            groceryList.getItems().addAll(fruitItems);
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
            groceryList.getItems().addAll(meatItems);
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
            groceryList.getItems().addAll(vegetableItems);
        });

        Button bakedGoodsBtn = new Button("Baked Goods");
        // Button Styling
        bakedGoodsBtn.setTextAlignment(TextAlignment.CENTER);
        bakedGoodsBtn.setStyle("-fx-background-color: #613393;");
        bakedGoodsBtn.setTextFill(Color.WHITE);

        // Set the action for the Baked Goods button
        bakedGoodsBtn.setOnAction(event -> {
            // Clear existing items and add baked goods items as strings
            groceryList.getItems().clear();
        
            // Convert bakedGoodsItems to a list of strings before adding to groceryList
            groceryList.getItems().addAll(bakedGoodsItems);
        });

        /*******************************************************************************************************************/
        
        // Search Bar
        TextField searchBar = new TextField("Search for items here");

        // Set the action for Enter key press
        searchBar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
               String searchTerm = searchBar.getText().toLowerCase();

                // Filter and display items that match the search term
                List<Food> matchingItems =allGroceries.stream()
                .filter(item -> item.toString().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
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
        allGroceries.addAll(bakedGoodsItems);

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
        ListView<Food> yourList = new ListView<>();

        /*******************************************************************************************************************/

        // Remove button
        Button removeBtn = new Button("Remove");
        // Button Styling
        removeBtn.setTextAlignment(TextAlignment.CENTER);
        removeBtn.setStyle("-fx-background-color: #613393;");
        removeBtn.setTextFill(Color.WHITE);

         // Set the action for the Remove button
        removeBtn.setOnAction(event -> {
        Food selectedItem = yourList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                yourList.getItems().remove(selectedItem);
                linkedYourList.remove(selectedItem);
                updateTotalLabel(total);
            }
        });

        /*******************************************************************************************************************/

        // Reset button
        Button resetBtn = new Button("Reset");
        // Button Styling
        resetBtn.setTextAlignment(TextAlignment.CENTER);
        resetBtn.setStyle("-fx-background-color: #613393;");
        resetBtn.setTextFill(Color.WHITE);

        // Set the action for the Reset button
        resetBtn.setOnAction(event -> {
           yourList.getItems().clear();
            linkedYourList.clear();
            updateTotalLabel(total);
        });

        /*******************************************************************************************************************/

        // Method call to add items from the list view to the linked list whenever the listview is changes
        yourList.getItems().addListener((ListChangeListener<Food>) change -> {
            linkedYourList.clear();
            linkedYourList.addAll(yourList.getItems());
            updateTotalLabel(total);
        });
        
        // MIME type used to transfer information between two objects
        final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

        // Drag and Drop Event 
        groceryList.setOnDragDetected(event -> {
            Food selectedItem = groceryList.getSelectionModel().getSelectedItem();
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
                // Assuming that the items in yourList are the string representations of Food objects
                Food foodItem = (Food) dragboard.getContent(SERIALIZED_MIME_TYPE);
                yourList.getItems().add(foodItem);
                linkedYourList.add(foodItem);

                success = true;
            }
        
            event.setDropCompleted(success);
            event.consume();
        });

        /*******************************************************************************************************************/

        // When you right click an object in your list, you are able to change the quantity
        yourList.setCellFactory(lv -> {
            ListCell<Food> cell = new ListCell<>();
            ContextMenu contextMenu = createContextMenu(cell);
            cell.textProperty().bind(cell.itemProperty().asString());
            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell;
        });



        /*******************************************************************************************************************/
    
        // Adding everything to the main V Box
        vBox.getChildren().addAll(navBar, hbox);
        navBar.getChildren().addAll(dairyBtn, fruitBtn, meatBtn, vegetableBtn, bakedGoodsBtn, searchBar, resetBtn, removeBtn);
        hbox.getChildren().addAll(foodItemsList, yourGroceryList);
        foodItemsList.getChildren().addAll(groceriesLabel, groceryList);
        yourGroceryList.getChildren().addAll(yourListLabel, yourList, total);
        
        return vBox;
    }

    /*******************************************************************************************************************/
    // Calculate total 

    private static String calculateTotal(LinkedList<Food> foodItems) {
        double sum = 0.00;

        for (Food food : foodItems){
            System.out.println(food.getName());
            double price = food.getPrice();
            System.out.println("Price: " + price);
            double quantity = food.getQuantity();
            System.out.println("Quantity: " + quantity);
            sum += price * quantity;
        }

        System.out.println(sum);
        System.out.println("End of Calculation");

        String total = ("Total: $" + Double.toString(sum));
        return total;
    }

    /*******************************************************************************************************************/
    // Update Total Label
    private static void updateTotalLabel(Label total){
        total.setText(calculateTotal(linkedYourList));
    }

    /*******************************************************************************************************************/
    // Create Context Menu

    private static ContextMenu createContextMenu(ListCell<Food> cell) {
        ContextMenu contextMenu = new ContextMenu();

        MenuItem editQuantity = new MenuItem("Edit Quantity");

        editQuantity.setOnAction(event -> {
            cell.textProperty().unbind();
            Food selectedFoodItem = cell.getItem();
            TextInputDialog dialog = new TextInputDialog(String.valueOf(selectedFoodItem.getQuantity()));
            dialog.setTitle("Edit Quantity");
            dialog.setHeaderText("Enter the quantity:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newQuantity -> {
                try {
                    int newQuantityValue = Integer.parseInt(newQuantity);
                    selectedFoodItem.setQuantity(newQuantityValue);
                    cell.setText(selectedFoodItem.toString());
                    cell.textProperty().bind(cell.itemProperty().asString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for quantity.");
                }
            });
        });

        contextMenu.getItems().add(editQuantity);
        return contextMenu;
    }
 
}   