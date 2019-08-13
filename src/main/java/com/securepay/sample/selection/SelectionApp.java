package com.securepay.sample.selection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.securepay.sample.selection.model.Category;
import com.securepay.sample.selection.model.Item;
import com.securepay.sample.selection.utility.SelectionUtil;

public class SelectionApp {
	public static BigDecimal sum = BigDecimal.ZERO;
	
	public static void main(String[] args) {

		List<Category> categories = initCategories();
		List<Category> finalListWithItemsAndCategories = new ArrayList<Category>();

		System.out.println("Initial Category and Items");
		categories.stream().forEach(System.out::println);
		
		System.out.println("");
		finalListWithItemsAndCategories = getOptimizedItems(categories);
		printOptimizedItems(finalListWithItemsAndCategories);

	}

	public static List<Category> getOptimizedItems(List<Category> categories) {
		sum = BigDecimal.ZERO;
		List<Category> finalList = new ArrayList<>();

		for (Category category : categories) {
			if (sum.add(category.getOptimizedItem().getTotalCost()).compareTo(new BigDecimal(50)) > 0) {
				break;
			}
			sum = sum.add(category.getOptimizedItem().getTotalCost());
			finalList.add(category);
		}
		return finalList;
}
	
	private static void printOptimizedItems(List<Category> finalList) {

		System.out.println("Total number of items selected = " + finalList.size());
		System.out.println("\nThe coordinates of the selected items:\n" + getCoordinatesOfSelectedItems(finalList));
		System.out.println("\nTotal cost = $" + sum.doubleValue());
		System.out.println("\nSum of ratings of all the items that were picked = "
				+ finalList.stream().mapToInt(v -> v.getOptimizedItem().getRating()).sum());
	}	

	private static String getCoordinatesOfSelectedItems(List<Category> finalList) {
		return String.join(", ",
				finalList.stream().map(v -> String.join(":", v.getCategoryName(), v.getOptimizedItem().getItemName()))
						.collect(Collectors.toList()));
	}

	public static List<Category> initCategories() {
		List<Category> categories = new ArrayList<Category>();
		List<Item> items = new ArrayList<Item>();

		for (int i = 1; i <= 20; i++) {
			items = new ArrayList<Item>();
			for (int j = 1; j <= 10; j++) {
				items.add(new Item(j, "Item " + j, new BigDecimal(SelectionUtil.generateRandomIntegerWithinRange(20, 1)),
						new BigDecimal(SelectionUtil.generateRandomIntegerWithinRange(5, 2)),
						SelectionUtil.generateRandomIntegerWithinRange(5, 1)));
			}
			categories.add(new Category(i, "Category " + i, items));
		}
		Collections.sort(categories);
		return categories;
	}


}
