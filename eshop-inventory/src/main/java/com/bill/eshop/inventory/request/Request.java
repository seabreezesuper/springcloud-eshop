package com.bill.eshop.inventory.request;

public interface Request {

	void process();
	
	Integer getProductId();
}
