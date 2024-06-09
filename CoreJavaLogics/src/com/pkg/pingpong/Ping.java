package com.pkg.pingpong;

public class Ping implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while (true && i < PingPong.maxItr) {
			synchronized (PingPong.lock) {
				System.out.println("PING");
				PingPong.lock.notify();
				try {
					PingPong.lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}

	}

}
