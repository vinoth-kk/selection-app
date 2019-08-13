# selection-app
Project to add items to a shopping cart. The categories and the items, cost, shipping cost, ratings of each item has to be generated dynamically every time. The total cart cost should not exceed 50$

**Listed below are the constraints:**
- Generate 20 Categories
- Generate 10 Items per Category
- Item cost should be randomly assigned between 1 to 20
- Item shipping cost should be randomly assigned between 2 to 5
- Item rating should be randomly assigned between 1 to 5
- Picks as many items as you can for the basket, while keeping the total cost (price shipping cost)of all picked items below 5 0 and ensuring that the sum of ratings of all items picked is optimized

On running the program each time, it should print the below:
Print the coordinates of the selected items.

- CategoryA:ItemX,CategoryB:ItemY,...
- Total cost, and
- Sum of ratings of all the items that were picked

**Sample Output:**  
The coordinates of the selected items:  
Category 7:Item 1, Category 15:Item 2, Category 2:Item 5, Category 13:Item 10, Category 18:Item 3, Category 4:Item 1, Category 11:Item 4, Category 5:Item 7  

Total cost = $48.0  

Sum of ratings of all the items that were picked = 40  
 
## The below Maven commands can be used to run the project in command prompt once the project is built

mvn clean build  
mvn exec:java -Dexec.mainClass="com.securepay.sample.selection.SelectionApp"  
 

## Below command can be used to run the test cases  
mvn test
