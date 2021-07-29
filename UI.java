/*
 * Finance Choose Your Own Story Game - Summer 2021 Hackathon
 * Brianna M
 * 7/14/21
 */

package dev.budgetgame;
import  javax.swing.*; // used for window and JTextArea
import  java.awt.*; // used for window color.black
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class UI {
	
	GameManager gm;
	
	JFrame window;
	public JTextArea messageText; // Make text on the bottom of the screen
	public JPanel bgPanel[] = new JPanel[10]; // background panel for game window
	public JLabel bgLabel[] = new JLabel[10];
	
	// Player UI
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6]; // amount of money Miguel has
	JPanel inventoryPanel;
	public JLabel gumboLabel;
	
	/*
	 * Calls the needed methods to start the game
	 */
	public UI(GameManager gm) {
		this.gm =gm;
		
		createMainField(); // Create window
		createPlayerField();
		generateScreen();
		
		window.setVisible(true); // make window visible
	}
	
	
	/*
	 * Method creates the main window of the game along with
	 * creating a text box for the story to be in
	 */
	public void createMainField() {
		
		window = new JFrame();
		
		// Be sure to match game window size with other game window sizes
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window properly
		window.getContentPane().setBackground(Color.black); // set background color
		window.setLayout(null); // sets the layout manager
		
		
		messageText = new JTextArea("SAMPLE TEXT ABC 123"); // make new text object
		messageText.setBounds(50, 410,700,150); // Creates text box
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false); // Cannot edit the text from what it is set to say
		messageText.setLineWrap(true); // Automatically wrap text
		messageText.setWrapStyleWord(true); // Handles line breaks for text wrap
		messageText.setFont(new Font("Macaron Pillow", Font.PLAIN, 26));
		window.add(messageText);
	}	
	
	
	/*
	 * Method creates background frame for the game visuals w/ multiple screens
	 */
	public void createBackground(int bgNum, String bgFileName) {
		
		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350); // Size of background image
		bgPanel[bgNum].setBackground(Color.black);
		bgPanel[bgNum].setLayout(null);
		window.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350); // Displays background image
		
		
		// Screen 1 - Kitchen
		// Load kitchen background to "bgIcon"
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName)); 
		bgLabel[bgNum].setIcon(bgIcon);
		// background gets added when createObject() is called
	}
	
	
	/*
	 * Method takes in screen #, along with image dimensions, and location to place onto background
	 */
	public void createObject(int bgNum, int objX, int objY, int objWidth, int objHeight, String objFileName,
			String choice0Name, String choice1Name, String choice2Name, String choice0Com, String choice1Com, String choice2Com) {
		
		// Create Pop menu
		JPopupMenu popMenu = new JPopupMenu(); // for pop up selection of object
		JMenuItem menuItem[] = new JMenuItem[3]; // Item interactions...Use [0],[1],[2]
		
		// Create menu items
		menuItem[0] = new JMenuItem(choice0Name);
		menuItem[0].addActionListener(gm.aHandler);
		menuItem[0].setActionCommand(choice0Com);
		popMenu.add(menuItem[0]);
		
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1Com);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2Com);
		popMenu.add(menuItem[2]);
		
		
		// make objects
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objX, objY, objWidth, objHeight);
																												// UPDATE AND CHANGE FOR PAGE WITH THE SHOPS!!
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);
		
		objectLabel.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				
				if(SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(objectLabel, e.getX(), e.getY()); // only activated when right mouse button is clicked
				}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		bgPanel[bgNum].add(objectLabel); // add object to background
		
		
	}
	
	
	/*
	 * Method creates a button to flip between screens
	 */
	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
		
		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
		JButton arrowButton = new JButton();
		arrowButton.setBounds(x, y, width, height);
		arrowButton.setBackground(null); // do not fill arrow with color
		arrowButton.setContentAreaFilled(false);
		arrowButton.setFocusPainted(false);
		arrowButton.setIcon(arrowIcon);
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		
		bgPanel[bgNum].add(arrowButton); // add arrow to scene
		
	}
	
	/*
	 * Method creates the lives / coins for player Miguel
	 */
	public void createPlayerField() {
		lifePanel = new JPanel();
		lifePanel.setBounds(50,0,250,50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(0,5)); // min and max lives
		window.add(lifePanel); // add lives to window
		
		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("coin.png")); // import coin photo
		
		// creates 5 total coins
		int i = 0;
		while (i < 5) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;
		}
		
		// Add inventory where Miguel gets ingredients from stand
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(650,0,100,50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(0,2));
		window.add(inventoryPanel);
		
		// Create Item - soup pot
		gumboLabel = new JLabel();
		ImageIcon gumboIcon = new ImageIcon(getClass().getClassLoader().getResource("cooking-pot.png"));
		Image image = gumboIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT); // resize item
		gumboIcon = new ImageIcon(image);
		gumboLabel.setIcon(gumboIcon);
		inventoryPanel.add(gumboLabel);
		
	}
	
	/*
	 * Method generates multiple objects by calling createObject() and backgrounds with createBackground()
	 */
	public void generateScreen() {
		
		//Screen 1
		createBackground(1,"kitchen.png");
		createObject(1,70,180,100,200,"miguel.png", "Look", "Talk", "Cook", "lookMiguel", "talkMiguel", "cookMiguel"); // Add Miguel to kitchen scene
		createArrowButton(1,0,150,50,50,"pointLeft.png","goScene2");
		bgPanel[1].add(bgLabel[1]); // add background to window last (kitchen)
		
		//Screen 2
		createBackground(2,"houseBackground.png");
		createObject(2,400,200,100,100,"blankImg.png","Look", "Talk", "Buy","lookShop", "talkShop", "buyShop"); // interact with produce stand
		createArrowButton(2,650,150,50,50,"pointRight.png","goScene1");
		bgPanel[2].add(bgLabel[2]); // add background to window last (outside houses)
		
		//Screen 3
		createBackground(3,"parkBackground.png");
		createArrowButton(2,650,150,50,50,"pointLeft.png","goScene3");
		bgPanel[3].add(bgLabel[3]);
	}
}











