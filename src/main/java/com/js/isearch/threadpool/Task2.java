package com.js.isearch.threadpool;

import java.util.Date;
import java.util.TimerTask;

/**
 * task2
 * @author arron
 * @date 2015年8月5日 下午2:08:34 
 * @version 1.0 
 */
public class Task2 extends TimerTask {

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println("----task2 start--------"+new Date().toLocaleString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----5s later, task2 end--------"+new Date().toLocaleString());
	}
}