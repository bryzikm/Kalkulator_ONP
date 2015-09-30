import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;

public class testONP 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	 
	 
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
					mainONP window = new mainONP();
					window.frame.setVisible(true);
				
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}
