import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;


public class mainONP 
{
	JFrame frame;
	private String equation;

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public mainONP() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
	{
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
	{
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 210, 335);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("ikona.jpg").getImage());
		
		//zmiana wygl¹du okna
		for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
		{
			System.out.println(info + " - " + info.getName());
			
			if("Nimbus".equals(info.getName()))
			{
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
		
		//Menu u góry
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnWidok = new JMenu("Widok");
		menuBar.add(mnWidok);
		
		JMenuItem mntmStandardowy = new JMenuItem("Standardowy");
		mnWidok.add(mntmStandardowy);
		
		JMenu mnEdycja = new JMenu("Edycja");
		menuBar.add(mnEdycja);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmOAutorach = new JMenuItem("O autorach");
		mnPomoc.add(mntmOAutorach);
		
		//utworzenie obiektu klasy textArea
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		/**
		 * Listener dla Buttonów
		 * @author Mateusz Bryzik
		 */
		final class ButtonAction implements ActionListener
		{

			public void actionPerformed(ActionEvent e) 
			{

				JButton j = (JButton) e.getSource();
				String s = j.getText();
				
				if(s.equals("C"))
				{
					textArea.setText("");
				}
				else if(s.equals("="))
				{
					String equation = textArea.getText();
					String x = ONP.toONP(equation);
					textArea.append("\n" + ONP.calculateResult(x) + "\n");
				}
				else
				{
					textArea.append(s);
				}
			}
			
		}
		
		/*
		 * Przypisanie buttonom akcji
		 */
		
		// nawias (
		JButton btnMc = new JButton("(");
		btnMc.addActionListener(new ButtonAction());
		
		//nawias )
		JButton btnMr = new JButton(")");
		btnMr.addActionListener(new ButtonAction());
		
		//znak ^
		JButton btnMs = new JButton("^");
		btnMs.addActionListener(new ButtonAction());
		
		//znak C
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ButtonAction());
		
		//pierwiastek
		JButton button_2 = new JButton("\u221A");
		button_2.addActionListener(new ButtonAction());
		
		//7
		JButton button_3 = new JButton("7");
		button_3.addActionListener(new ButtonAction());
		
		//8
		JButton button_4 = new JButton("8");
		button_4.addActionListener(new ButtonAction());
		
		//9
		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ButtonAction());
		
		// znak /
		JButton button_6 = new JButton("/");
		button_6.addActionListener(new ButtonAction());
		
		//znak %
		JButton button_7 = new JButton("%");
		
		
		//4
		JButton button_8 = new JButton("4");
		button_8.addActionListener(new ButtonAction());
		
		//5
		JButton button_9 = new JButton("5");
		button_9.addActionListener(new ButtonAction());
		
		//6
		JButton button_10 = new JButton("6");
		button_10.addActionListener(new ButtonAction());
		
		//znak *
		JButton button_11 = new JButton("*");
		button_11.addActionListener(new ButtonAction());
		
		//1
		JButton button_12 = new JButton("1");
		button_12.addActionListener(new ButtonAction());
		
		//2
		JButton button_13 = new JButton("2");
		button_13.addActionListener(new ButtonAction());
		
		//3
		JButton button_14 = new JButton("3");
		button_14.addActionListener(new ButtonAction());
		
		//znak -
		JButton button_15 = new JButton("-");
		button_15.addActionListener(new ButtonAction());
		
		//0
		JButton button_16 = new JButton("0");
		button_16.addActionListener(new ButtonAction());
		
		//kropka
		JButton button_17 = new JButton(".");
		button_17.addActionListener(new ButtonAction());
		
		//znak +
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ButtonAction());
		
		//znak =
		JButton btnNewButton_2 = new JButton("=");
		btnNewButton_2.addActionListener(new ButtonAction());
			
		
		//reszta kodu
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnMc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(8)
									.addComponent(btnMr, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(button_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(button_15, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnMs, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(button_17, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addComponent(button_14, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
												.addComponent(button_10, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(button_16, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(button_12)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(button_13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(button_9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(button_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(button_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addGap(52)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_2)
									.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(button_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button_11, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMc)
						.addComponent(btnMs)
						.addComponent(button_2)
						.addComponent(btnMr, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnC)
						.addComponent(btnNewButton_1)
						.addComponent(button_15)
						.addComponent(button_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5)
						.addComponent(button_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_8)
						.addComponent(button_9)
						.addComponent(button_10)
						.addComponent(button_11))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_12)
								.addComponent(button_13)
								.addComponent(button_14))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_16)
								.addComponent(button_17)))
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
