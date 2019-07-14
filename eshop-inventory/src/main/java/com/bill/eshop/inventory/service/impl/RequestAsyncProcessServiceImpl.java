package com.bill.eshop.inventory.service.impl;

import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

import com.bill.eshop.inventory.request.Request;
import com.bill.eshop.inventory.request.RequestQueue;
import com.bill.eshop.inventory.service.RequestAsyncProcessService;

@Service("requestAsyncProcessService")
public class RequestAsyncProcessServiceImpl implements RequestAsyncProcessService {


	@Override
	public void process(Request request) {
		
		//请求路由
		ArrayBlockingQueue<Request> queue = this.getRoutingQueue(request.getProductId());
		try {
			queue.put(request);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取路由到的内存队列
	 * @param productId
	 * @return
	 */
	private ArrayBlockingQueue<Request> getRoutingQueue(Integer productId) {
		RequestQueue requestQueue = RequestQueue.getInstance();
		
		// 获取productId的hash值
		int h;
		String key = String.valueOf(productId);
		int hash = (key == null)? 0:(h=key.hashCode())^(h>>>16);
		
		//对hash值取模，将hash值路由到指定的内存队列中
		int index = (requestQueue.queueSize()-1)&hash;
		
		return requestQueue.getQueue(index);
	}

}
