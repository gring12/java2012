package com.gring12.realoop;

public class TestPlayer {
	private TestPlayerLevel level;
	
	public TestPlayer() {
		level = new TestBeginner();
		level.showLevelMessage();
	}
	
	public TestPlayerLevel getLevel() {
		return level;
	}
	
	public void upgradeLevel(TestPlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
		
	}
	
	public void play(int count) {
		level.go(count);
	}
}
