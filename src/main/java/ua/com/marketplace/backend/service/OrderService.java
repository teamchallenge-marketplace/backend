package ua.com.marketplace.backend.service;

import ua.com.marketplace.backend.model.Order;

import java.util.List;

public interface OrderService {
	Order create(Order product);

	Order update(Order product);

	Order readById(String id);

	void deleteById(String id);

	List<Order> getAll();
}
