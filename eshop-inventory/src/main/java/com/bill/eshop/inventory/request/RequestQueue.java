package com.bill.eshop.inventory.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 请求内存队列
 * @author seabreeze
 *
 */
public class RequestQueue {
	
	/**
	 * 内存队列
	 */
	private List<ArrayBlockingQueue<Request>> queues = new ArrayList<ArrayBlockingQueue<Request>>();
	
	/**
	 * 单例。静态内部类的方式去初始化，线程安全。
	 * @author seabreeze
	 *
	 */
	private static class Singleton {
		private static RequestQueue instance;
		
		static {
			instance = new RequestQueue();
		}
		
		public static RequestQueue getInstance() {
			return instance;
		}
	}
	
	public static RequestQueue getInstance() {
		return Singleton.getInstance();
	}
	
	public void addQueue(ArrayBlockingQueue<Request> queue) {
		this.queues.add(queue);
	}
	
	/**
	 * 内存队列的数量
	 * @return
	 */
	public int queueSize() {
		return queues.size();
	}
	
	public ArrayBlockingQueue getQueue(int index) {
		return queues.get(index);
	}
}
