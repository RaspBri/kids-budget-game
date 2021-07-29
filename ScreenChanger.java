/*
 * Finance Choose Your Own Story Game - Summer 2021 Hackathon
 * Brianna M
 * 7/14/21
 */

package dev.budgetgame;

public class ScreenChanger {
	
	GameManager gm;
	
	public ScreenChanger (GameManager gm) {
		
		this.gm = gm;
	}
	
	public void showScreen1() { // kitchen screen
		
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.messageText.setText("Click on Miguel to get started!");
	}
	
	public void showScreen2() { // house screen
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.messageText.setText("Try talking to the clerk.");
	}
	
	public void showScreen3() { // park screen
		
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.messageText.setText("Miguel: Let's sell some gumbo!\n\n*** This is the end of the demo. Thanks for playing! ***");
	}
}
