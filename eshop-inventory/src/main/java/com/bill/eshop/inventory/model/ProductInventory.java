package com.bill.eshop.inventory.model;

/**
 * 库存数量Model
 * @author seabreeze
 *
 */
public class ProductInventory {

	private Integer productId;
	
	private Integer inventoryCnt;

	public ProductInventory(Integer productId, Integer inventoryCnt) {
		this.productId = productId;
		this.inventoryCnt = inventoryCnt;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getInventoryCnt() {
		return inventoryCnt;
	}

	public void setInventoryCnt(Integer inventoryCnt) {
		this.inventoryCnt = inventoryCnt;
	}


	
}
