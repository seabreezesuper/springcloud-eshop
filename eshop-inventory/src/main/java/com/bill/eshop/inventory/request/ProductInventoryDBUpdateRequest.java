package com.bill.eshop.inventory.request;

import com.bill.eshop.inventory.model.ProductInventory;
import com.bill.eshop.inventory.service.ProductInventoryService;

/**
 * 数据更新请求
 * （1）删除缓存
 * （2）更新数据库
 * @author seabreeze
 *
 */
public class ProductInventoryDBUpdateRequest implements Request {

	/*
	 * 商品库存
	 */
	private ProductInventory productInventory;
	
	/*
	 * 商品库存Service
	 */
	private ProductInventoryService productInventoryService;
	
	public ProductInventoryDBUpdateRequest(ProductInventory productInventory,ProductInventoryService productInventoryService){
		this.productInventory = productInventory;
		this.productInventoryService = productInventoryService;
	}
	
	@Override
	public void process() {
		// 删除缓存
		productInventoryService.removeProductInventoryCache(productInventory);
		
		// 更新数据库
		productInventoryService.updateProductInventory(productInventory);
	}

	@Override
	public Integer getProductId() {
		return this.productInventory.getProductId();
	}

}
