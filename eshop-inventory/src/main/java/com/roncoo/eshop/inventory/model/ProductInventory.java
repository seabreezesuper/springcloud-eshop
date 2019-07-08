package com.roncoo.eshop.inventory.model;

/**
 * 库存数量Model
 * @author seabreeze
 *
 */
public class ProductInventory {

	private Integer productId;
	
	private Long inventoryCnt;

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
