package com.securepay.sample.selection.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Category implements Comparable<Category> {
	private int categoryId;
	private String categoryName;
	private List<Item> items;
	private Item optimizedItem;

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, List<Item> items) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.items = items;
		Collections.sort(this.items);
		this.setOptimizedItem(this.items.get(0));
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item getOptimizedItem() {
		return optimizedItem;
	}

	public void setOptimizedItem(Item optimizedItem) {
		this.optimizedItem = optimizedItem;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", optimizedItemTotalPrice="
				+ optimizedItem.getPrice().add(optimizedItem.getShippingCost()) + " , rating="
				+ optimizedItem.getRating() + "]" + "\n " + items ;
	}

	@Override
	public int compareTo(Category o) {
		return Comparator.comparing(Category::getOptimizedItem).compare(this, o);
	}

}
