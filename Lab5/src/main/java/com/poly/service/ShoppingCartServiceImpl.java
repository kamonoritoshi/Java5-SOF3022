package com.poly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.db.DB;
import com.poly.model.Item;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private final Map<Integer, Item> cart = new HashMap<>();

	@Override
	public Item add(Integer id) {
		if (cart.containsKey(id)) {
			Item item = cart.get(id);
			item.setQty(item.getQty() + 1);
			return item;
		} else {
			Item itemFromDB = DB.items.get(id);
			if (itemFromDB != null) {
				// Tạo một bản sao của sản phẩm từ DB và đặt số lượng là 1
				Item newItem = new Item(itemFromDB.getId(), itemFromDB.getName(), itemFromDB.getPrice(), 1);
				cart.put(id, newItem);
				return newItem;
			} else {
				throw new IllegalArgumentException("Product with id " + id + " not found in DB");
			}
		}
	}

	@Override
	public void remove(Integer id) {
		cart.remove(id);
	}

	@Override
	public Item update(Integer id, int qty) {
		if (cart.containsKey(id)) {
			Item item = cart.get(id);
			item.setQty(qty);
			return item;
		}
		throw new IllegalArgumentException("Item not found in the cart!");
	}

	@Override
	public void clear() {
		cart.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return cart.values();
	}

	@Override
	public int getCount() {
		return cart.values().stream().mapToInt(Item::getQty).sum();
	}

	@Override
	public double getAmount() {
		return cart.values().stream().mapToDouble(item -> item.getPrice() * item.getQty()).sum();
	}
}
