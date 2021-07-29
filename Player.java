/*
 * Finance Choose Your Own Story Game - Summer 2021 Hackathon
 * Brianna M
 * 7/14/21
 */

package dev.budgetgame;

public class Player {
	GameManager gm;
	
	public int playerMaxCoins;
	public int playerCoins;
	public int hasGumbo;
	
	public Player (GameManager gm) {
		this.gm = gm;
	}
	
	public void setPlayerDefaultStatus() {
		
		playerMaxCoins = 5;
		playerCoins = 3;
		hasGumbo = 0;
		
		updatePlayerStatus();
	}
	
	public void updatePlayerStatus() {
		
		// Remove all coin icons
		int i = 0;
		while(i < 5) { // reset all icons
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		
		// Add coins as needed
		int lifeCount = playerCoins;
		while(lifeCount != 0) {
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount--;
		}
		
		// Check player items
		if(hasGumbo == 0) {
			gm.ui.gumboLabel.setVisible(false);
		}
		if(hasGumbo == 1) {
			gm.ui.gumboLabel.setVisible(true);
		}
	}
}
