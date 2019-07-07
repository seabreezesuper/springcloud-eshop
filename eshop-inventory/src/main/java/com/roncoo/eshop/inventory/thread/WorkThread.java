package com.roncoo.eshop.inventory.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

import com.roncoo.eshop.inventory.request.Request;

public class WorkThread implements Callable<Boolean>{

	private ArrayBlockingQueue<Request> queue;
	
	public WorkThread(ArrayBlockingQueue<Request> queue) {
		this.queue = queue;
	}
	
	@Override
	public Boolean call() throws Exception {
		while(true) {
			// 此处消费消息
			break;
		}
		return true;
	}

}
