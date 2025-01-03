package hust.soict.hedspi.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnReset, btnDelete;
	private JTextField tfDisplay;
	public NumberGrid()
	{
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel paneButtons = new JPanel(new GridLayout(4, 3));
		addButtons(paneButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(paneButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}
	
	public void addButtons(JPanel paneButtons)
	{
		ButtonListener btnListener = new ButtonListener() ;
		
		for(int i=1; i<=9; i++)
		{
			btnNumbers[i] = new JButton(""+i);
			paneButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		
		btnDelete = new JButton(""+ "DEL");
		paneButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnNumbers[0] = new JButton(""+0);
		paneButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("" + "C");
		paneButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.charAt(0) >= '0' && button.charAt(0) <= '9')
			{
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			else if(button.charAt(0) == 'D')
			{
				if(tfDisplay.getText().length() > 0)
				{
					tfDisplay.setText(tfDisplay.getText().substring(0, tfDisplay.getText().length()-1));
				}
			}
			else if(button.charAt(0) == 'C')
			{
				tfDisplay.setText("");
			}
		}
	}
	public static void main(String[] args) {
		new NumberGrid();
	}
}
