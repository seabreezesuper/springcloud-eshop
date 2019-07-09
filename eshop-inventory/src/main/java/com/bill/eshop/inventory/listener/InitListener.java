package com.bill.eshop.inventory.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bill.eshop.inventory.thread.RequestProcessThreadPool;

public class InitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Listener initialized!");
		
		// 初始化线程池和内存队列
		RequestProcessThreadPool.init();
		
		ServletContextListener.super.contextInitialized(sce);
	}
	
}
