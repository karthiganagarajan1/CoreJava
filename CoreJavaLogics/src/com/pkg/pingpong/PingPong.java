package com.pkg.pingpong;

public class PingPong {
	public static final Object lock = new Object();
	public static final int maxItr = 10;
	
	public static void main(String[] args) {

		Thread pingThread = new Thread(new Ping(), "PingThread");
		Thread pongThread = new Thread(new Pong(), "PongThread");

		pingThread.start();
		pongThread.start();
	}

}
