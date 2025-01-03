package hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ObservableList;

public class StoreScreen extends JFrame implements ActionListener{
	private Store store;
	private CartScreen cartscreen;
	JPanel createNorth()
	{
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar()
	{
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		JMenuItem menuItemViewCart = new JMenuItem("View Cart");
		menu.add(menuItemViewCart);
		menuItemViewCart.setActionCommand("viewCart");
		menuItemViewCart.addActionListener(this);
		
		JMenuBar menubar = new JMenuBar();
		menubar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menubar.add(menu);
		
		return menubar;
	}
	
	JPanel createHeader()
	{
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnCart = new JButton("View Cart");
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.setActionCommand("viewCart");
		btnCart.addActionListener(this);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter()
	{
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ObservableList<Media> mediaInStore = store.getItemsInStore();
		for(int i=0; i<9; i++)
		{
			MediaStore cell = new MediaStore(mediaInStore.get(i), this.cartscreen.getCart());
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Store store, CartScreen cartscreen)
	{
		this.store = store;
		this.cartscreen = cartscreen;
		
		this.setLayout(new BorderLayout());
		
		Container cp = this.getContentPane();
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setSize(1024, 768);
		this.setTitle("Store");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("viewCart".equals(e.getActionCommand()))
		{
			this.dispose();
			this.cartscreen.setVisible(true);
		}
	}
}
