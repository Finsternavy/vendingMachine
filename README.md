# Vending Machine

### Authors: Christopher Finster & Ingri Lopez.
###### Project begin date: 29MAY2017.
###### This project is for CST-135 Computer Programming II, Grand Canyon University.
 
The intent of this project is to create a realistic representation of a working vending machine. In its current state, the program can be run using the Welcome class. The Welcome class contains all of the programs graphics functionality. The program allows a user to select a category (Drink, Chips, Candy, or Gum). After selecting a category a list of availble products in that category is displayed. When the user clicks that product, the product is added to their cart and they are returned to the category selection screen. The user can repeat this process as many times as they wish. When the user has finished selecting products, the done button can be clicked from the category selection screen. Clicking the done button opens a receipt screen that displays the name of each product selected, that items price, and the total price of all items selected. Closing the receipt screen empties the cart and returns the user to the category selection screen.  

The next step in the process is to add an inventory manager class and screen to allow a servicer to manage inventory.
We will also implement a simple animation that will run when an item is selected.
 
#### Proposed customer flow:

Insert money > select category > select item > dispense / cancel / add funds / add more items > repeat as necessary. 

#### Proposed servicer(Boss) flow:

Admin login > passcode entry > select area of interest (inventory / financials / passcode change) > item selection / account control / enter new pin > item adjustments > adjustment confirmation > return to main.

### Before installing Vending Machine you may need:

-A [GitHub account](https://github.com/)

-[Eclipse](https://www.eclipse.org/downloads/?), [Netbeans](https://netbeans.org/downloads/), or some other Integrated Development Environment(IDE)

-[SourceTree](https://www.sourcetreeapp.com/)

### Download instructions:

1. Open SourceTree
2. Click <FILE> <NEW/CLONE>
3. Copy the GitHub Vending Machine file's URL and past into the Source Path / URL field in SourceTree
4. Click "Clone"

### Or...

1. Follow the URL at the top of this file
2. Click Clone or Download
3. Select desired method
4. Open an IDE
5. Click file > Open Project > Select the file location you chose when downloading
6. Select the Welcome Class
7. Right click > select Run as Application
