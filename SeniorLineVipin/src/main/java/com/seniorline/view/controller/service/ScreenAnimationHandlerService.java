package com.seniorline.view.controller.service;


public class ScreenAnimationHandlerService  implements Runnable{

	ScreenAnimationHandler screenAnimationHandler = null;
	String screenUri = null;
	private boolean isRunning = false;
	Thread mThread = null;
	private long refreshRate =  5*1000;
	private Object lock = new Object();
	public ScreenAnimationHandlerService(ScreenAnimationHandler screenAnimationHandler,String screenUri){
		this.screenAnimationHandler=screenAnimationHandler;
		this.screenUri=screenUri;
	}

	public void run() {
		try {
			Thread.sleep(refreshRate);
			screenAnimationHandler.initScreen(screenUri);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void start() {
		stop();
		if (mThread == null) {
			mThread = new Thread(this);
			isRunning = true;
			mThread.start();
		} else {
			isRunning = true;
		}

	}

	public void stop() {
		synchronized (lock) {
			try {
				if (mThread != null) {
					// mThread.stop();
					mThread = null;
				}

				isRunning = false;

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
