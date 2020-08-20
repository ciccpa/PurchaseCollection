# PurchaseCollection
## Java Application to keep track of customers, purchases, purchase collections.

## This application contains the following:

## BUSINESS LAYER
Contains class information, constructors, member variables. (Customer, Address, Product, Purchase, PurchaseCollection).

## PRESENTATION LAYER
Contains sample input files, in both .TXT and .JSON format. 
The presentation layer allows the user to choose from three interfaces.

### 1. CustomerPurchaseConsoleUI
Allows the user to read customer data (name, address) and purchase data (product, price, description) from 
their respective files and write them to files in .TXT or .JSON format, or print the data on screen.

### 2. PurchaseCollectionConsoleUI
Allows the user to read a collection of purchases from .JSON or .TXT format, write those files, show 
purchases by index, get the maximum purchase, display a purchase collection report, and display purchase collection as toString. 

### 3. PurchasesGraphicalGUI
Brings up a graphical user interface that will let the user open a file via File Explorer, save as, 
or save the file to a report.


In order to run this project you will need to download both the PRESENTATION and BUSINESS folders, respectively. 

### Purchase Collection Console UI. 
Displays a simple user menu with various options. In this case, a PurchaseCollection Report was selected using sample input file data.
![screenshot5](https://user-images.githubusercontent.com/50625576/90799327-0e150900-e2e1-11ea-8283-696ddcf3330d.jpg)

### PurchasesGraphicalGUI. 
Empty GUI. 
![screenshot4](https://user-images.githubusercontent.com/50625576/90799257-f5a4ee80-e2e0-11ea-96a2-35fa57fc3495.jpg)

### Open file dialog. 
When user clicks "open", they're prompted to choose a file to read from.
![screenshot3](https://user-images.githubusercontent.com/50625576/90799193-df972e00-e2e0-11ea-8371-9ac5ae1d40af.png)

### Customers
Once a valid PurchaseCollection file is chosen, fills the window with customer's data.
![screenshot2](https://user-images.githubusercontent.com/50625576/90799087-c1313280-e2e0-11ea-8f52-e857ff5a4e46.jpg)

### Purchases.
A separate tab can be chosen to view that customer's purchase collection info.
![screenshot1](https://user-images.githubusercontent.com/50625576/90798962-9e9f1980-e2e0-11ea-94de-e51946dadee4.jpg)
