package com.bill.eshop.inventory.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.eshop.inventory.model.ProductInventory;
import com.bill.eshop.inventory.request.ProductInventoryCacheReloadRequest;
import com.bill.eshop.inventory.request.ProductInventoryDBUpdateRequest;
import com.bill.eshop.inventory.request.Request;
import com.bill.eshop.inventory.service.ProductInventoryService;
import com.bill.eshop.inventory.service.RequestAsyncProcessService;
import com.bill.eshop.inventory.vo.Response;

/**
 * 用户Controller控制器
 * @author Administrator
 *
 */
@Controller
public class ProductInventoryController {

	@Resource
	private RequestAsyncProcessService requestAsyncProcessService;
	
	@Resource
	private ProductInventoryService productInventoryService;
	
	/**
	 * 更新商品庫存
	 * @return
	 */
	@RequestMapping("/updateProductInventory")
	@ResponseBody
	public Response updateProductInventory(ProductInventory productInventory) {
		
		Response response = null;
		
		try {
			Request request = new ProductInventoryDBUpdateRequest(productInventory, productInventoryService);
			requestAsyncProcessService.process(request);
			response = new Response(Response.SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			response = new Response(Response.FAILURE);
		}

		return response;
	}
	
	/**
	 * 获取商品庫存
	 * @return
	 */
	@RequestMapping("/getProductInventory")
	@ResponseBody
	public ProductInventory getProductInventory(Integer productId) {
		
		ProductInventory productInventory = null;
		
		try {
			Request request = new ProductInventoryCacheReloadRequest(productId, productInventoryService);
			requestAsyncProcessService.process(request);
			
			// 将请求扔给service异步处理后，要while(true)，等应答回来
			long startTime = System.currentTimeMillis();
			long endTime = 0L;
			long waitTime = 0L;
			
			while(true) {
				
				// 总尝试时间超过200毫秒，就跳出
				if(waitTime > 200) {
					break;
				}
				
				productInventory = productInventoryService.getProductInventoryCache(productId);
				
				// 取到结果就返回
				if(productInventory != null) {
					return productInventory;
					
				// 结果为null，就等待20毫秒后再尝试
				}else {
					Thread.sleep(20);
					endTime = System.currentTimeMillis();
					waitTime = endTime - startTime;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ProductInventory(productId,-1L);
	}
	
}
