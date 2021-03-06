# Vending Machine

### Authors: Christopher Finster & Ingri Lopez.
###### Project begin date: 29MAY2017.
###### This project is for CST-135 Computer Programming II, Grand Canyon University.

#### Area of responsibilities

Chris Finster - Writter and maintainer of all source code.

Ingri Lopez - Product ideas, images for button graphics.

### Overview
 
The intent of this project is to create a realistic representation of a working vending machine. In its current state, the program can be run using the Dispenser class. The Dispenser class contains all the programs graphic functionality. The program can also be run by downloading vendingMachineV2.0.exe. The program allows a user to select a category (Drink, Chips, Candy, or Gum). After selecting a category, a list of available products in that category is displayed. When the user clicks a product, the product is added to their cart. The user can repeat this process as many times as they wish. When the user has finished selecting products, the done button can be clicked from the category selection screen. Clicking the done button opens a receipt screen that displays the name of each product selected, that items price, the total price of all items selected and the amount of change due to the customer. Closing the receipt screen empties the cart and returns the user to the category selection screen. Each time this cycle is completed, the inventory of each product is updated and accessible from the input funds screen. 
If a customer wishes to cancel their order, a receipt screen opens showing that the amount deposited by the customer is returned as change. 

#### Additional functionality added:

Ability to view your cart from any main screen.
Animation showing your product falling into your cart when an item is selected.
Ability to add more funds if needed.
Pop-up windows display when the customer has insufficient  funds or a product is out of stock.
Restock page for vending machine boss.
Check profits and change available from boss menu.
A simulation of a queue of customers (buggy).
 
#### Proposed customer flow:

Insert money > select category > select item > return to home / cancel / add funds > repeat as necessary > click done to finish. 

#### Proposed servicer(Boss) flow:

Admin login > passcode entry > select area of interest (inventory / financials / passcode change) > item selection / account control / enter new pin > item adjustments > adjustment confirmation > return to main.

### Before installing Vending Machine, you may need:

-A [GitHub account](https://github.com/)

-[Eclipse](https://www.eclipse.org/downloads/?), [Netbeans](https://netbeans.org/downloads/), or some other Integrated Development Environment(IDE)

-[SourceTree](https://www.sourcetreeapp.com/)

### Project Download instructions:

1. Open SourceTree
2. Click <FILE> <NEW/CLONE>
3. Copy the GitHub Vending Machine file's URL and paste into the Source Path / URL field in SourceTree
4. Click "Clone"

### Or...

1. Follow the URL at the top of this file
2. Click Clone or Download
3. Select desired method
4. Open an IDE
5. Click file > Open Project > Select the file location you chose when downloading
6. Select the Welcome Class
7. Right click > select Run as Application

### Vending Machine Download (Application only) instructions:

1. Select the file titled "VendingMachineV2.0.exe
2. Click "Download" on the right side of the screen
3. A message will display stating that windows has blocked installation. Click "details" in the message body.
4. Click "Download anyway"
5. When the download has finished, double click the file from the location you saved it to. The program will open.
