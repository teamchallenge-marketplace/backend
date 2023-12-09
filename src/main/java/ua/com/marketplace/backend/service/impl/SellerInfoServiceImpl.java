package ua.com.marketplace.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.marketplace.backend.model.SellerInfo;
import ua.com.marketplace.backend.repository.SellerInfoRepository;
import ua.com.marketplace.backend.service.SellerInfoService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {
	@Autowired
	private SellerInfoRepository sellerInfoRepository;


	@Override
	public SellerInfo create(SellerInfo sellerInfo) {
		return sellerInfoRepository.save(sellerInfo);
	}

	@Override
	public SellerInfo update(SellerInfo sellerInfo) {
		return sellerInfoRepository.save(sellerInfo);
	}

	@Override
	public SellerInfo readById(String id) {
		Optional<SellerInfo> optional = sellerInfoRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new NoSuchElementException("Seller Information with ID " + id + " not found");
		}
	}

	@Override
	public void deleteById(String id) {
		sellerInfoRepository.delete(readById(id));
	}

	@Override
	public List<SellerInfo> getAll() {
		return sellerInfoRepository.findAll();
	}
}