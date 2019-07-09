package com.roncoo.eshop.inventory.service;

import com.roncoo.eshop.inventory.model.ProductInventory;

/**
 * 商品库存Service接口
 * @author seabreeze
 *
 */
public interface ProductInventoryService {

	/**
	 * 更新数据库中的商品库存
	 */
	void updateProductInventory(ProductInventory productInventory);
	
	/**
	 * 删除Redis缓存中的商品库存
	 * @param productInventory
	 */
	void removeProductInventoryCache(ProductInventory productInventory);
	
	/**
	 * 根据商品ID查询最新商品库存数量
	 * @param productInventory
	 */
	ProductInventory findProductInventory(Integer productId);
	
	/**
	 * 设置Redis缓存中的商品库存
	 * @param productInventory
	 */
	void setProductInventoryCache(ProductInventory productInventory);
}
