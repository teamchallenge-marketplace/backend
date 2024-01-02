package ua.com.marketplace.backend.service;


import ua.com.marketplace.backend.model.User;

import java.util.List;

public interface UserService {
	User create(User user);

	User readById(String id);

	User update(User user);

	void delete(String id);

	List<User> getAll();
}