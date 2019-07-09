package com.bill.eshop.inventory.mapper;

import com.bill.eshop.inventory.model.ProductInventory;

/**
 * 库存数量Mapper
 * @author seabreeze
 *
 */
public interface ProductInventoryMapper {
	
	/**
	 * 更新商品库存数量
	 * @param productInventory
	 */
	void updateProductInventory(ProductInventory productInventory);
	
	/**
	 * 查询最新的商品库存数量
	 * @param productId
	 * @return
	 */
	ProductInventory findProductInventory(Integer productId);
}
