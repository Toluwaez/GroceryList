import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    
        @Override
        public void start(Stage primaryStage) {
            VBox groceryPane = GroceryPane.createGroceryPane();
    
            // Set the scene
            Scene scene = new Scene(groceryPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Your Grocery List");
            primaryStage.show();
    }
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}