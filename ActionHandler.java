/*
 * Finance Choose Your Own Story Game - Summer 2021 Hackathon
 * Brianna M
 * 7/14/21
 */

package dev.budgetgame;

import java.awt.event.*;

/*
 * Class will perform the action of the pop window, from the object interaction
 */
public class ActionHandler implements ActionListener{

	GameManager gm;
	
	public ActionHandler(GameManager gm) {
		this.gm = gm;
	}
	
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		// Commands for pop window of object
		switch(yourChoice) {
		case "lookMiguel": gm.ev0.lookMiguel(); break;
		case "talkMiguel": gm.ev0.talkMiguel(); break;
		case "cookMiguel": gm.ev0.cookMiguel(); break;
		case "lookShop": gm.ev0.lookShop(); break;
		case "talkShop": gm.ev0.talkShop(); break;
		case "buyShop": gm.ev0.buyShop(); break;
		
		// change screens
		case "goScene1": gm.sChanger.showScreen1(); break;
		case "goScene2": gm.sChanger.showScreen2(); break;
		case "goScene3": gm.sChanger.showScreen3(); break;
		}
		
	}

}
