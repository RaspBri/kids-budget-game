/*
 * Finance Choose Your Own Story Game - Summer 2021 Hackathon
 * Brianna M
 * 7/14/21
 */


package dev.budgetgame;

import Event.Event0;

public class GameManager {
	
	ActionHandler aHandler = new ActionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	
	public ScreenChanger sChanger = new ScreenChanger(this);
	
	public Event0 ev0 = new Event0(this);
	
	// Calls game manager to start the game, that is all
	public static void main(String[] args) {
		new GameManager();
	}
	public GameManager() {
		player.setPlayerDefaultStatus();
		sChanger.showScreen1();
	}
}
