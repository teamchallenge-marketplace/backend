package ua.com.marketplace.backend.service;

import ua.com.marketplace.backend.model.SellerInfo;

import java.util.List;

public interface SellerInfoService {
	SellerInfo create(SellerInfo SellerInfo);

	SellerInfo update(SellerInfo sellerInfo);

	SellerInfo readById(String id);

	void deleteById(String id);

	List<SellerInfo> getAll();
}
