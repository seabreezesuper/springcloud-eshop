package com.bill.eshop.inventory.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.bill.eshop.inventory.request.Request;
import com.bill.eshop.inventory.request.RequestQueue;

/**
 * 请求处理线程池。
 * @author seabreeze
 *
 */
public class RequestProcessThreadPool {
	
	private ExecutorService threadPool = Executors.newFixedThreadPool(10);
	
	public RequestProcessThreadPool() {
		
		RequestQueue queues = RequestQueue.getInstance();
		
		for (int i = 0; i < 10; i++) {
			ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(100);
			queues.addQueue(queue);
			threadPool.submit(new WorkThread(queue));
		}
	}
	
	/**
	 * 单例。静态内部类的方式去初始化，线程安全。
	 * @author seabreeze
	 *
	 */
	private static class Singleton {
		private static RequestProcessThreadPool instance;
		
		static {
			instance = new RequestProcessThreadPool();
		}
		
		public static RequestProcessThreadPool getInstance() {
			return instance;
		}
	}
	
	public static RequestProcessThreadPool getInstance() {
		return Singleton.getInstance();
	}
	
	public static void init() {
		getInstance();
	}
}
