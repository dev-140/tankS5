package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	static JPanel homePanel = new JPanel();
	JPanel panel_3 = new RoundedPanel(20, Color.white);
	JPanel panel = new JPanel();
	JPanel amenitiesPanel = new JPanel();
	JPanel roomsPanel = new JPanel();
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
	
	public void animatePanel(int endPosY, int posX, final JPanel homePanel2) {
		final int startY = -100;
		final int endY = endPosY;
		final int x = posX;
		
		int delay = 20; // set the delay in milliseconds
		final int increment = 5; // set the increment in pixels

		final Timer timer = new Timer(delay, new ActionListener() {
		    int currentY = startY;
		    
		    public void actionPerformed(ActionEvent e) {
		        currentY += increment;
		        
		        if (currentY > endY) {
		            currentY = endY;
		            ((Timer) e.getSource()).stop(); // stop the timer
		        }
		        
		        homePanel2.setLocation(x, currentY);
		    }
		});
		
		timer.start();
	}
	
	public void sideBar() {
		sideBarPanel.setBackground(Color.WHITE);
		sideBarPanel.setBounds(0, 0, 208, 647);
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
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(true);
				amenitiesPanel.setVisible(false);
				roomsPanel.setVisible(false);
				animatePanel(0, 207, homePanel);
			}
		});
		
		primaryBtn(roomsBtn, 25, 170, 38, 160, sideBarPanel);
		roomsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				amenitiesPanel.setVisible(false);
				roomsPanel.setVisible(true);
				animatePanel(0, 208, roomsPanel);
			}
		});
		primaryBtn(AmenitiesBtn, 25, 230, 38, 160, sideBarPanel);
		AmenitiesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				amenitiesPanel.setVisible(true);
				roomsPanel.setVisible(false);
				animatePanel(0, 218, amenitiesPanel);
			}
		});
		primaryBtn(receiptBtn, 25, 290, 38, 160, sideBarPanel);
	}
	
	public void borders() {
		Panel bottomBorder = new Panel();
		bottomBorder.setBounds(0, 624, 1212, 23);
		getContentPane().add(bottomBorder);
		bottomBorder.setBackground(new Color(0, 163, 255));
	}
	
	public void prodCards(String image, String roomName, String roomPrice, int posX, int posY) {
		JPanel prodCardsPanel = new RoundedPanel(20, Color.white);
		prodCardsPanel.setBounds(posX, posY, 192, 216);
		homePanel.add(prodCardsPanel);
		prodCardsPanel.setLayout(null);
		
		JLabel prodCardImg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(image)).getImage();
		prodCardImg.setIcon(new ImageIcon(img));
		prodCardImg.setBounds(6, 5, 180, 107);
		prodCardsPanel.add(prodCardImg);
		
		JLabel prodCardName = new JLabel(roomName);
		prodCardName.setFont(new Font("Helvetica", Font.BOLD, 15));
		prodCardName.setBounds(6, 124, 180, 28);
		prodCardsPanel.add(prodCardName);
		
		JLabel prodCardRoomPrice = new JLabel(roomPrice);
		prodCardRoomPrice.setFont(new Font("Helvetica", Font.PLAIN, 13));
		prodCardRoomPrice.setBounds(6, 151, 180, 16);
		prodCardsPanel.add(prodCardRoomPrice);
		
		RoundedButton prodCardBtn = new RoundedButton("Book Now");
		prodCardBtn.setBackground(new Color(255, 255, 255));
		prodCardBtn.setFont(new Font("Helvetica", Font.PLAIN, 13));
		prodCardBtn.setBounds(6, 179, 180, 30);
		primaryBtn(prodCardBtn, 6, 179, 30, 180, prodCardsPanel);
	}
	
	public void prodCardsSmall(String name, String price, String img, int posX, int posY) {
		JPanel prodCardSmallPanel = new RoundedPanel(20, Color.white);
		prodCardSmallPanel.setBounds(posX, posY, 218, 69);
		homePanel.add(prodCardSmallPanel);
		prodCardSmallPanel.setLayout(null);
		
		JLabel prodCardImg = new JLabel("");
		prodCardImg.setBounds(6, 6, 101, 57);
		prodCardSmallPanel.add(prodCardImg);
		Image image = new ImageIcon(this.getClass().getResource(img)).getImage();
		prodCardImg.setIcon(new ImageIcon(image));
		
		JLabel prodCardName = new JLabel(name);
		prodCardName.setFont(new Font("Helvetica", Font.BOLD, 13));
		prodCardName.setBounds(119, 6, 93, 24);
		prodCardSmallPanel.add(prodCardName);
		
		JLabel prodCardPrice = new JLabel(price);
		prodCardPrice.setFont(new Font("Helvetica", Font.BOLD, 13));
		prodCardPrice.setBounds(119, 42, 93, 16);
		prodCardSmallPanel.add(prodCardPrice);
		
		JPanel border = new JPanel();
		border.setBackground(new Color(0, 0, 0));
		border.setBounds(119, 32, 93, 2);
		prodCardSmallPanel.add(border);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(737, 0, 268, 626);
		homePanel.add(panel_1);
	}
	
	public void homePanel() {
		animatePanel(0, 207, homePanel);
		
		JLabel homeHeading = new JLabel("Check our rooms");
		homeHeading.setFont(new Font("Helvetica", Font.BOLD, 20));
		homeHeading.setBounds(58, 34, 170, 21);
		homePanel.add(homeHeading);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 163, 255));
		panel.setBounds(58, 56, 74, 10);
		homePanel.add(panel);
		
		JPanel homeHeadingPanel = new RoundedPanel(20, Color.white);
		homeHeadingPanel.setBackground(new Color(240, 239, 239));
		homeHeadingPanel.setBounds(58, 78, 192, 39);
		homePanel.add(homeHeadingPanel);
		homeHeadingPanel.setLayout(null);
		
		JLabel homeHeadinglabel = new JLabel("Here some of our rooms");
		homeHeadinglabel.setBounds(23, 6, 140, 27);
		homeHeadingPanel.add(homeHeadinglabel);
		homeHeadinglabel.setForeground(new Color(126, 126, 126));
		homeHeadinglabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		homeHeadinglabel.setBackground(new Color(255, 255, 255));
		
		homePanel.setBorder(null);
		homePanel.setBackground(new Color(240, 239, 239));
		homePanel.setBounds(207, 0, 1005, 647);
		getContentPane().add(homePanel);
		homePanel.setLayout(null);
		
//		home prodcards
		prodCards("/room2.png", "Single Room", "P 1,000 / Night", 58, 129);
		prodCards("/room2.png", "Single Room", "P 1,000 / Night", 280, 129);
		prodCards("/room2.png", "Single Room", "P 1,000 / Night", 502, 129);
		
//		availble rooms
		JPanel homeSubHeading = new RoundedPanel(20, Color.white);
		homeSubHeading.setBackground(new Color(240, 239, 239));
		homeSubHeading.setBounds(58, 372, 147, 39);
		homePanel.add(homeSubHeading);
		homeSubHeading.setLayout(null);
		
		JLabel homeHeadingSublabel = new JLabel("Available rooms");
		homeHeadingSublabel.setBounds(23, 6, 102, 27);
		homeSubHeading.add( homeHeadingSublabel);
		homeHeadingSublabel.setForeground(new Color(126, 126, 126));
		homeHeadingSublabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		homeHeadingSublabel.setBackground(new Color(255, 255, 255));
		
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 58, 423);
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 306, 423);
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 58, 510);
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 306, 510);
	}
	
	public void amenitiesCards(String images, String label, int posX, int posY) {
		JPanel itemPanel = new RoundedPanel(20, Color.white);
		itemPanel.setBounds(posX, posY, 297, 189);
		itemPanel.setLayout(null);
		amenitiesPanel.add(itemPanel);
		
		
		JLabel image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(10, 11, 277, 143);
		itemPanel.add(image);
		
		Image img = new ImageIcon(this.getClass().getResource(images)).getImage();
		image.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_5 = new JLabel(label);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 155, 277, 32);
		itemPanel.add(lblNewLabel_5);
	}
	
	public void amenitiesPanel() {	
		amenitiesPanel.setBounds(218, 0, 978, 582);
		getContentPane().add(amenitiesPanel);
		amenitiesPanel.setLayout(null);
		
		JLabel amenitiesHeading = new JLabel("Amenities");
		amenitiesHeading.setFont(new Font("Dialog", Font.BOLD, 20));
		amenitiesHeading.setBounds(58, 34, 118, 26);
		amenitiesPanel.add(amenitiesHeading);
		
		JPanel heading_blue = new JPanel();
		heading_blue.setBackground(new Color(0, 163, 255));
		heading_blue.setBounds(58, 58, 45, 6);
		amenitiesPanel.add(heading_blue);
		
		JLabel amenitiesSubHeading = new JLabel("Perfect home with perfect space and amenities.");
		amenitiesSubHeading.setForeground(new Color(159, 158, 158));
		amenitiesSubHeading.setFont(new Font("Tahoma", Font.PLAIN, 13));
		amenitiesSubHeading.setBounds(57, 74, 273, 14);
		amenitiesPanel.add(amenitiesSubHeading);
		
		amenitiesCards("/item1.png", "Swimming Pools", 139, 99);
		amenitiesCards("/item2.png", "Indoor Fitness Area", 487, 99);
		amenitiesCards("/item3.png", "Outdoor Playground", 10, 336);
		amenitiesCards("/item4.png", "Billiards", 335, 336);
		amenitiesCards("/item5.png", "Golf Course", 671, 336);

	}
	
	public void roomsCards(String image, String roomName, String roomPrice, int posX, int posY) {
		JPanel roomsCardPanel = new RoundedPanel(20, Color.white);
		roomsCardPanel.setBounds(posX, posY, 192, 235);
		roomsPanel.add(roomsCardPanel);
		roomsCardPanel.setLayout(null);
		
		JLabel roomsCardImg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(image)).getImage();
		roomsCardImg.setIcon(new ImageIcon(img));
		roomsCardImg.setBounds(10, 7, 172, 140);
		roomsCardPanel.add(roomsCardImg);
		
		JLabel roomsCardName = new JLabel(roomName);
		roomsCardName.setFont(new Font("Helvetica", Font.BOLD, 15));
		roomsCardName.setHorizontalAlignment(SwingConstants.CENTER);
		roomsCardName.setBounds(45, 150, 108, 24);
		roomsCardPanel.add(roomsCardName);
		
		JLabel roomsCardPrice = new JLabel(roomPrice);
		roomsCardPrice.setFont(new Font("Helvetica", Font.PLAIN, 13));
		roomsCardPrice.setHorizontalAlignment(SwingConstants.CENTER);
		roomsCardPrice.setBounds(45, 175, 108, 24);
		roomsCardPanel.add(roomsCardPrice);
		
		RoundedButton roomsCardBtn = new RoundedButton("View");
		roomsCardBtn.setBackground(new Color(255, 255, 255));
		roomsCardBtn.setFont(new Font("Helvetica", Font.PLAIN, 13));
		roomsCardBtn.setBounds(55, 201, 89, 23);
		roomsCardPanel.add(roomsCardBtn);
	}
	
	public void roomsPanel() {
		
		roomsPanel.setBounds(208, 0, 700, 625);
		getContentPane().add(roomsPanel);
		roomsPanel.setLayout(null);
		
		JLabel roomsHeading = new JLabel("Available Rooms");
		roomsHeading.setFont(new Font("Dialog", Font.BOLD, 20));
		roomsHeading.setBounds(57, 22, 163, 20);
		roomsPanel.add(roomsHeading);
		
		JPanel panel_blue = new JPanel();
		panel_blue.setBackground(new Color(0, 163, 255));
		panel_blue.setBounds(57, 43, 70, 6);
		roomsPanel.add(panel_blue);
		
		roomsCards("/room1.jpg", "Single Room", "P 1,000 / Night", 57, 80);
		roomsCards("/room1.jpg", "Double Room", "P 2,000 / Night", 270, 80);
		roomsCards("/room1.jpg", "Triple Room", "P 3,000 / Night", 485, 80);
		roomsCards("/room1.jpg", "Single Room", "P 1,000 / Night", 57, 339);
		roomsCards("/room1.jpg", "Double Room", "P 2,000 / Night", 270, 339);
		roomsCards("/room1.jpg", "Triple Room", "P 3,000 / Night", 485, 339);

	}
	
	public UserInterface() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 675);
		getContentPane().setLayout(null);
		
//		border bottom
		borders();
//		home panel
		homePanel();
//		amenities panel
		amenitiesPanel();
		amenitiesPanel.setVisible(false);
//		rooms panel
		roomsPanel();
		roomsPanel.setVisible(false);
//		side bar
		sideBar();
		
	}
}
