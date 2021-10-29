package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	private Long itemId;
	private String itemName;
	private Long itemValue;

	public Item(String itemName, Long itemValue) {
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}

	public Item(Long itemId, String itemName, Long itemValue) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	

	public Item(Long itemId) {
		super();
		this.itemId = itemId;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getItemValue() {
		return itemValue;
	}

	public void setItemValue(Long itemValue) {
		this.itemValue = itemValue;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemValue=" + itemValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemValue == null) ? 0 : itemValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemValue == null) {
			if (other.itemValue != null)
				return false;
		} else if (!itemValue.equals(other.itemValue))
			return false;
		return true;
	}

	

}
