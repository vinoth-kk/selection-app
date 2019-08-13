package com.securepay.sample.selection.model;

import java.math.BigDecimal;
import java.util.Comparator;

public class Item implements Comparable<Item> {
	private int itemId;
	private String itemName;
	private BigDecimal price;
	private BigDecimal shippingCost;
	private BigDecimal totalCost;
	private int rating;

	public Item() {
		super();
	}

	public Item(int itemId, String itemName, BigDecimal price, BigDecimal shippingCost, int rating) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.shippingCost = shippingCost;
		this.rating = rating;
		this.totalCost = price.add(shippingCost);
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public int compareTo(Item o) {
		return Comparator.comparing(Item::getRating).reversed().thenComparing(Item::getTotalCost).compare(this, o);
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", shippingCost="
				+ shippingCost + ", rating=" + rating + ", Total Cost=" + (price.add(shippingCost)) + "]";
	}

}
