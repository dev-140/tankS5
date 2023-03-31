package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Font;
import java.awt.Image;

import java.awt.Panel;
import java.awt.Label;

public class UserInterface extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel sideBarPanel = new JPanel();
	RoundedButton homeBtn = new RoundedButton("Home");
	RoundedButton roomsBtn = new RoundedButton("Rooms");
	RoundedButton AmenitiesBtn = new RoundedButton("Amenities");
	RoundedButton receiptBtn = new RoundedButton("Receipt");
	RoundedButton receiptBtn1 = new RoundedButton("Receipts");
	JPanel homePanel = new JPanel();
	
	JPanel panel_3 = new RoundedPanel(20, Color.white);
	JPanel panel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void primaryBtn(final JButton btnMain, final int posX, final int posY, final int height, final int width, JPanel sideBarPanel2) {
		btnMain.setBackground(new Color(255, 255, 255));
		btnMain.setFont(new Font("Helvetica", Font.PLAIN, 13));
		sideBarPanel2.add(btnMain);
		btnMain.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnMain.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMain.setBounds(posX, posY, width, height);
		btnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMain.setBackground(Color.lightGray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMain.setBackground(Color.white);
			}
		});
	}
	
	public void prodCards(String image, String roomName, String roomPrice, int posX, int posY) {
		JPanel panel_2 = new RoundedPanel(20, Color.white);
		panel_2.setBounds(posX, posY, 192, 216);
		homePanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(image)).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(6, 5, 180, 107);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(roomName);
		lblNewLabel_2.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblNewLabel_2.setBounds(6, 124, 180, 28);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(roomPrice);
		lblNewLabel_3.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(6, 151, 180, 16);
		panel_2.add(lblNewLabel_3);
		
		RoundedButton btnNewButton = new RoundedButton("Book Now");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnNewButton.setBounds(6, 179, 180, 30);
		
		primaryBtn(btnNewButton, 6, 179, 30, 180, panel_2);
	}
	
	public void sideBar() {
		sideBarPanel.setBackground(Color.WHITE);
		sideBarPanel.setBounds(0, 0, 208, 604);
		getContentPane().add(sideBarPanel);
		sideBarPanel.setLayout(null);
		
		Label mainHeading = new Label("TANK S5");
		mainHeading.setFont(new Font("Helvetica", Font.BOLD, 32));
		mainHeading.setAlignment(Label.CENTER);
		mainHeading.setBounds(25, 29, 160, 38);
		sideBarPanel.add(mainHeading);
		mainHeading.setForeground(Color.BLACK);
		
		Panel borderBottomHeading = new Panel();
		borderBottomHeading.setBackground(new Color(0, 163, 255));
		borderBottomHeading.setBounds(25, 73, 160, 15);
		sideBarPanel.add(borderBottomHeading);
		
		
//		sidebar btns
		primaryBtn(homeBtn, 25, 110, 38, 160, sideBarPanel);
		primaryBtn(roomsBtn, 25, 170, 38, 160, sideBarPanel);
		primaryBtn(AmenitiesBtn, 25, 230, 38, 160, sideBarPanel);
		primaryBtn(receiptBtn, 25, 290, 38, 160, sideBarPanel);
		primaryBtn(receiptBtn1, 25, 350, 38, 160, sideBarPanel);
		
		
		
	}
	
	public void borders() {
		Panel bottomBorder = new Panel();
		bottomBorder.setBounds(0, 581, 1212, 23);
		getContentPane().add(bottomBorder);
		bottomBorder.setBackground(new Color(0, 163, 255));
	}
	
	public void homePanel() {
		JLabel homeHeading = new JLabel("Check our rooms");
		homeHeading.setFont(new Font("Helvetica", Font.BOLD, 20));
		homeHeading.setBounds(58, 34, 170, 21);
		homePanel.add(homeHeading);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 163, 255));
		panel.setBounds(58, 56, 74, 10);
		homePanel.add(panel);
		
		JPanel panel_1 = new RoundedPanel(20, Color.white);
		panel_1.setBackground(new Color(240, 239, 239));
		panel_1.setBounds(58, 78, 192, 39);
		homePanel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Here some of our rooms");
		lblNewLabel.setBounds(23, 6, 140, 27);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(126, 126, 126));
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		homePanel.setBorder(null);
		homePanel.setBackground(new Color(240, 239, 239));
		homePanel.setBounds(207, 0, 724, 582);
		getContentPane().add(homePanel);
		homePanel.setLayout(null);
		
//		home prodcards
		prodCards("/room2.png", "Single Room", "P 1,000 / Night", 58, 129);
		prodCards("/room2.png", "Single Room", "P 1,000 / Night", 280, 129);
		prodCards("/room2.png", "Single Room", "P 1,000 / Night", 502, 129);
	}
	
	public void amenitiesCards(String images, String label, int posX, int posY) {
		JPanel panel_3 = new RoundedPanel(20, Color.white);
		panel_3.setBounds(posX, posY, 204, 146);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
		JLabel image = new JLabel("");
		image.setBounds(6, 6, 192, 93);
		panel_3.add(image);
		
		Image img = new ImageIcon(this.getClass().getResource(images)).getImage();
		image.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_5 = new JLabel(label);
		lblNewLabel_5.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblNewLabel_5.setBounds(16, 111, 161, 30);
		panel_3.add(lblNewLabel_5);
	}
	
	public UserInterface() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 632);
		getContentPane().setLayout(null);
		
//		border bottom
		borders();
		
//		home panel
		homePanel();
		
//		side bar
		sideBar();
		
	}
}
