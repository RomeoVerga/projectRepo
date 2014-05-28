package com.circlexo;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;

/**
 * User Interface
 * 
 *@version 2.0.0
 */
public class MainWindow {

	private JFrame frmMain;
	private static CircleXOGrid game;
	private static JButton[][] btnArray;
	private Label lblWinner;
	private JButton btnResetGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		game = new CircleXOGrid();
		btnArray = new JButton[game.MAX_FIELD_LENGTH][game.MAX_FIELD_WIDTH];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("CircleXO (programmed by Romeo Verga)");
		frmMain.setBounds(100, 100, 510, 492);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		lblWinner = new Label("");
		lblWinner.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWinner.setAlignment(Label.CENTER);
		lblWinner.setBounds(129, 372, 236, 51);
		frmMain.getContentPane().add(lblWinner);
		
		btnResetGame = new JButton("Reset");
		btnResetGame.setEnabled(false);
		btnResetGame.setBounds(202, 330, 89, 23);
		frmMain.getContentPane().add(btnResetGame);

		for(int j = 0 ; j < game.MAX_FIELD_WIDTH; j++)
		{
			for(int i = 0; i < game.MAX_FIELD_LENGTH; i++)
			{
				btnArray[i][j] = new JButton("*");

			}
		}
		
		btnArray[0][2].setBounds(183, 102, 45, 23);
		btnArray[0][1].setBounds(165, 79, 45, 23);
		btnArray[0][0].setBounds(145, 57, 45, 23);
		btnArray[0][3].setBounds(206, 124, 45, 23);
		
		btnArray[1][3].setBounds(244, 124, 45, 23);
		btnArray[1][2].setBounds(265, 102, 45, 23);
		btnArray[1][1].setBounds(281, 79, 45, 23);
		btnArray[1][0].setBounds(296, 57, 45, 23);
		
		btnArray[2][0].setBounds(390, 113, 45, 23);
		btnArray[2][2].setBounds(306, 134, 45, 23);
		btnArray[2][1].setBounds(348, 124, 45, 23);		
		btnArray[2][3].setBounds(265, 146, 45, 23);
		
		btnArray[3][3].setBounds(265, 168, 45, 23);
		btnArray[3][2].setBounds(306, 179, 45, 23);
		btnArray[3][1].setBounds(348, 190, 45, 23);
		btnArray[3][0].setBounds(390, 202, 45, 23);

		btnArray[4][3].setBounds(244, 190, 45, 23);
		btnArray[4][2].setBounds(265, 213, 45, 23);
		btnArray[4][1].setBounds(281, 235, 45, 23);
		btnArray[4][0].setBounds(296, 257, 45, 23);
		
		btnArray[5][3].setBounds(206, 190, 45, 23);
		btnArray[5][2].setBounds(183, 213, 45, 23);
		btnArray[5][1].setBounds(165, 235, 45, 23);
		btnArray[5][0].setBounds(145, 257, 45, 23);
		
		btnArray[6][2].setBounds(145, 179, 45, 23);
		btnArray[6][1].setBounds(106, 190, 45, 23);
		btnArray[6][0].setBounds(68, 202, 45, 23);		
		btnArray[6][3].setBounds(183, 168, 45, 23);
		
		btnArray[7][3].setBounds(183, 146, 45, 23);
		btnArray[7][2].setBounds(145, 134, 45, 23);
		btnArray[7][1].setBounds(106, 124, 45, 23);
		btnArray[7][0].setBounds(68, 113, 45, 23);
		
		
		for(int j = 0 ; j < game.MAX_FIELD_WIDTH; j++)
		{
			for(int i = 0; i < game.MAX_FIELD_LENGTH; i++)
			{
				frmMain.getContentPane().add(btnArray[i][j]);
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmResetGame = new JMenuItem("Reset Game");
		mnFile.add(mntmResetGame);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Close");
		mnFile.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("About...");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		btnResetGame.addActionListener(new ActionListener()   {public void actionPerformed(ActionEvent e)    {resetGame();}});
		mntmResetGame.addActionListener(new ActionListener()  {public void actionPerformed(ActionEvent e)    {resetGame();}});
		mntmNewMenuItem.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent arg0) {System.exit(0);}});

		btnArray[0][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(0,0);}});
		btnArray[0][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(0,1);}});
		btnArray[0][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(0,2);}});
		btnArray[0][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(0,3);}});
		
		btnArray[1][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(1,0);}});
		btnArray[1][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(1,1);}});
		btnArray[1][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(1,2);}});
		btnArray[1][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(1,3);}});
		
		btnArray[2][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(2,0);}});
		btnArray[2][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(2,1);}});
		btnArray[2][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(2,2);}});
		btnArray[2][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(2,3);}});
		
		btnArray[3][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(3,0);}});
		btnArray[3][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(3,1);}});
		btnArray[3][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(3,2);}});
		btnArray[3][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(3,3);}});
		
		btnArray[4][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(4,0);}});
		btnArray[4][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(4,1);}});
		btnArray[4][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(4,2);}});
		btnArray[4][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(4,3);}});
		
		btnArray[5][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(5,0);}});
		btnArray[5][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(5,1);}});
		btnArray[5][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(5,2);}});
		btnArray[5][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(5,3);}});
		
		btnArray[6][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(6,0);}});
		btnArray[6][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(6,1);}});
		btnArray[6][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(6,2);}});
		btnArray[6][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(6,3);}});
		
		btnArray[7][0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(7,0);}});
		btnArray[7][1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(7,1);}});
		btnArray[7][2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(7,2);}});
		btnArray[7][3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent arg0) {play(7,3);}});
		
	}
	
	public void resetGame()
	{
		game = new CircleXOGrid();
		
		for(int j = 0 ; j < game.MAX_FIELD_WIDTH; j++)
		{
			for(int i = 0; i < game.MAX_FIELD_LENGTH; i++)
			{
				btnArray[i][j].setEnabled(true);
				btnArray[i][j].setText("" + game.EMPTY);
			}
		}
		
		lblWinner.setText("");
		btnResetGame.setEnabled(false);
	}
	
	public void play(int x,int y)
	{
		int[] winX = null;
		int[] winY = null;
		
		if(game.playPos(x, y)){btnArray[x][y].setText("" + game.getPrevPlyr());}
		
		if(game.getWinner() != game.EMPTY)
		{
			winX = game.getXList();
			winY = game.getYList();
			
			for(int j = 0 ; j < game.MAX_FIELD_WIDTH; j++)
			{
				for(int i = 0; i < game.MAX_FIELD_LENGTH; i++)
				{
					if(!((i == winX[0] && j == winY[0]) || (i == winX[1] &&  j == winY[1]) || (i == winX[2] && j == winY[2]) || (i == winX[3] && j == winY[3])))
						btnArray[i][j].setEnabled(false);
				}
			}
			
			btnResetGame.setEnabled(true);
			lblWinner.setText(game.getWinner() + " IS THE WINNER!");
		}
		
		//System.out.println(game);
	}
	public boolean getBtnResetGameEnabled() {
		return btnResetGame.isEnabled();
	}
	public void setBtnResetGameEnabled(boolean enabled) {
		btnResetGame.setEnabled(enabled);
	}
}
