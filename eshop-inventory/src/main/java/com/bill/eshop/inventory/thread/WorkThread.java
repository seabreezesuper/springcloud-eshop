package com.bill.eshop.inventory.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

import com.bill.eshop.inventory.request.Request;

public class WorkThread implements Callable<Boolean>{

	private ArrayBlockingQueue<Request> queue;
	
	public WorkThread(ArrayBlockingQueue<Request> queue) {
		this.queue = queue;
	}
	
	@Override
	public Boolean call() throws Exception {
		try {
			while(true) {
				Request request = queue.take();
				request.process();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
