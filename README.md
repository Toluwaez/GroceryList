# GROCERYLIST APP
GroceryPane - a simple grocery management application.

## Overview:
This program allows users to manage their grocery list with categories like Dairy, Fruit, Meat, and Vegetables.
Users can drag and drop items between the available grocery items and their personal shopping list.
The total cost of the shopping list is displayed and updated dynamically.
 
## Design Choices:
- The program uses JavaFX for the graphical user interface.
- The grocery items are organized into categories and displayed in ListViews.
- Users can search for specific items using the search bar.
- Drag-and-drop functionality is implemented to add items to the personal shopping list.
- Error handling is in place to provide user-friendly messages in case of issues.
   
## Known Bugs:
- There is a known issue with updating the total cost label; if an error occurs, an error dialog is displayed.
- Total calculation might not work correctly in all scenarios.
  
## README:
- This program was developed as a group project by REAGAN and TOLUWANIMI.
- Each group member contributed to different aspects of the code:
- **Reagan Wix**: Designed user interface.
- **Reagan Wix**: Implemented the drag-and-drop functionality.
- **Reagan Wix**: Implemented the context menu.
- **Toluwanimi Oladeleajose**: Handled error handling and user-friendly messages.
- **Toluwanimi Oladeleajose**: Created interfaces, abstract classes, and subclasses.
- **Toluwanimi Oladeleajose**: Implemented search function and filter by category functions.
- **Reagan & Toluwanimi**: Worked on the design and layout of the graphical interface.
- **Reagan & Toluwanimi**: Implemented total function
 
## Usage:
- Compile and run the GroceryPane class to start the application.
- Use the category buttons to select different types of groceries.
- Drag items from the available list to the personal shopping list.
- Remove items from the personal shopping list using the Remove button.
- Reset the personal shopping list using the Reset button.
  
**Note:** This README provides a general overview. For detailed code comments, refer to the GroceryPane class.

## Debugging Collaborators
Reagan
- For the UI I referenced the JavaFX docs
- For the drag and drop I referenced the JavaFX docs along with [code found on Github](https://gist.github.com/jewelsea/7821196).
- For the context menu I referenced the JavaFX docs

## Project Details
### Tolu
Approximate hours spent on the project: 55 hours

### Reagan
Approximate hours spent on the project: 60 hours
