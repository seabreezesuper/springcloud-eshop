package com.bill.eshop.inventory.model;

/**
 * 库存数量Model
 * @author seabreeze
 *
 */
public class ProductInventory {

	private Integer productId;
	
	private Long inventoryCnt;

	public ProductInventory(Integer productId, Long inventoryCnt) {
		this.productId = productId;
		this.inventoryCnt = inventoryCnt;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Long getInventoryCnt() {
		return inventoryCnt;
	}

	public void setInventoryCnt(Long inventoryCnt) {
		this.inventoryCnt = inventoryCnt;
	}
	
	
}
