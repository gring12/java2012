package com.gring12.realoop;

public class TestPlayGame {

	public static void main(String[] args) {
		TestPlayer player = new TestPlayer();
		player.play(1);
		
		TestAdvanced aLevel = new TestAdvanced();
		player.play(2);
		
		TestSuper sLevel = new TestSuper();
		player.play(3);
	}

}
