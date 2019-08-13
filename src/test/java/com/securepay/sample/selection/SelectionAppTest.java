package com.securepay.sample.selection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.securepay.sample.selection.model.Category;


public class SelectionAppTest {
	
	List<Category> categories = SelectionApp.initCategories();
	
	@Test
	public void testForCategoriesInitialization() {
		// We should have 20 categories populated every time
		assertEquals(20, categories.size(), "20 Categories Populated Successfully");
	}
	
	@Test 
  	public void testForItemsInCategories() { 
	  // We should have 10 items in all 20 categories 
      categories.forEach(category -> assertEquals(10, category.getItems().size(),
                             "10 items stored successfully in each category")); 
      }
	
	@Test 
  	public void testForItemsCost() { 
	  // All items cost should be less than or equal to 20
      categories.forEach(category -> category.getItems().forEach(item -> 
    		  assertEquals(true, item.getPrice().compareTo(new BigDecimal(20)) > 0 ? false : true)));
      }
	
	@Test 
  	public void testForRatings() { 
	  // All items ratings should be between 1 and 5
      categories.forEach(category -> category.getItems().forEach(item -> 
    		  assertEquals(true, (item.getRating() >= 1 && item.getRating() <= 5) ? true : false)));
      }
	
	@Test 
  	public void testForSumOfItemsCostIsLessThanFifty() { 
		SelectionApp.getOptimizedItems(categories);
		assertEquals(true, SelectionApp.sum.compareTo(new BigDecimal(50)) <= 0 ? true : false);
      }
	
	@Test 
  	public void testForSumOfRatingsOfTheSelectedItems() { 
		List<Category> optimisedItemList = SelectionApp.getOptimizedItems(categories);
		assertEquals(true, 
				optimisedItemList.stream().mapToInt(
						v -> v.getOptimizedItem().getRating()).sum() > 0 ? true : false);
      }	
	 
}
