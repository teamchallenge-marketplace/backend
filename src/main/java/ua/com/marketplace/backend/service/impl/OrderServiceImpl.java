package ua.com.marketplace.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.marketplace.backend.model.Order;
import ua.com.marketplace.backend.repository.OrderRepository;
import ua.com.marketplace.backend.service.OrderService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;


	@Override
	public Order create(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order readById(String id) {
		Optional<Order> optional = orderRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new NoSuchElementException("Order with ID " + id + " not found");
		}
	}

	@Override
	public void deleteById(String id) {
		orderRepository.delete(readById(id));
	}

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}
}
