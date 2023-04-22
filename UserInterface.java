package main;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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
	JPanel amenitiesPanel = new JPanel();
	JPanel roomsPanel = new JPanel();
	JPanel modalBg = new JPanel();
	JPanel infoSidePanel = new JPanel();
	
	// room side info
	JLabel roomInfoLabel = new JLabel();
	JLabel roomInfoPrice = new JLabel();
	JTextPane txtSingleRoom = new JTextPane();

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

	public static void primaryBtn(final JButton btnMain, final int posX, final int posY, final int height,
			final int width, JPanel jPanel2) {
		btnMain.setBackground(new Color(255, 255, 255));
		btnMain.setFont(new Font("Helvetica", Font.PLAIN, 13));
		jPanel2.add(btnMain);
		btnMain.setBorder(new LineBorder(new Color(179, 179, 179), 1, true));
		btnMain.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMain.setBounds(posX, posY, width, height);
		
		btnMain.addMouseListener(new MouseAdapter() {
			int numC = 0;
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMain.setBackground(Color.lightGray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMain.setBackground(Color.white);
			}
			public void mouseClicked(MouseEvent e) {
				numC += 1;
				System.out.println(numC);
			}
		});
	}

//	animation settings
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

//	navigation 
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
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				homePanel.setVisible(true);
				amenitiesPanel.setVisible(false);
				roomsPanel.setVisible(false);
				infoSidePanel.setVisible(true);
				modalBg.setVisible(false);
				animatePanel(0, 207, homePanel);
			}
		});

		primaryBtn(roomsBtn, 25, 170, 38, 160, sideBarPanel);
		roomsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				homePanel.setVisible(false);
				amenitiesPanel.setVisible(false);
				roomsPanel.setVisible(true);
				infoSidePanel.setVisible(true);
				modalBg.setVisible(false);
				animatePanel(0, 208, roomsPanel);
			}
		});
		
		primaryBtn(AmenitiesBtn, 25, 230, 38, 160, sideBarPanel);
		AmenitiesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				homePanel.setVisible(false);
				amenitiesPanel.setVisible(true);
				roomsPanel.setVisible(false);
				modalBg.setVisible(false);
				infoSidePanel.setVisible(false);
				animatePanel(0, 218, amenitiesPanel);
			}
		});
		
		primaryBtn(receiptBtn, 25, 290, 38, 160, sideBarPanel);
	}

//	borders
	public void borders() {
		Panel bottomBorder = new Panel();
		bottomBorder.setBounds(0, 624, 1212, 23);
		getContentPane().add(bottomBorder);
		bottomBorder.setBackground(new Color(0, 163, 255));
	}

//	product cards
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

		RoundedButton prodCardBtn = new RoundedButton("View");
		prodCardBtn.setBackground(new Color(255, 255, 255));
		prodCardBtn.setFont(new Font("Helvetica", Font.PLAIN, 13));
		prodCardBtn.setBounds(6, 179, 180, 30);
		primaryBtn(prodCardBtn, 6, 179, 30, 180, prodCardsPanel);
	}

//	small product cards
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
	}

//	home main panel
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
		homePanel.setBounds(207, 0, 737, 647);
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
		homeSubHeading.add(homeHeadingSublabel);
		homeHeadingSublabel.setForeground(new Color(126, 126, 126));
		homeHeadingSublabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		homeHeadingSublabel.setBackground(new Color(255, 255, 255));

		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 58, 423);
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 306, 423);
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 58, 510);
		prodCardsSmall("Single Room", "P1,000 / Night", "/availabel-room-test-img.png", 306, 510);
	}

//	amenities cards
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

//	amenities main panel
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

//	room cards
	public void roomsCards(String image, String roomName, int posX, int posY) {
		ReadJson.fetchData(roomName);
		JPanel roomsCardPanel = new RoundedPanel(20, Color.white);
		roomsCardPanel.setBounds(posX, posY, 200, 220);
		roomsPanel.add(roomsCardPanel);
		roomsCardPanel.setLayout(null);

		JLabel roomsCardImg = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(image)).getImage();
		roomsCardImg.setIcon(new ImageIcon(img));
		roomsCardImg.setBounds(10, 0, 180, 140);
		roomsCardPanel.add(roomsCardImg);

		JLabel roomsCardName = new JLabel(ReadJson.roomFName);
		roomsCardName.setFont(new Font("Helvetica", Font.BOLD, 15));
		roomsCardName.setHorizontalAlignment(SwingConstants.CENTER);
		roomsCardName.setBounds(45, 135, 108, 24);
		roomsCardPanel.add(roomsCardName);

		JLabel roomsCardPrice = new JLabel(ReadJson.roomSPrice);
		roomsCardPrice.setFont(new Font("Helvetica", Font.PLAIN, 13));
		roomsCardPrice.setHorizontalAlignment(SwingConstants.CENTER);
		roomsCardPrice.setBounds(45, 155, 108, 24);
		roomsCardPanel.add(roomsCardPrice);

		RoundedButton roomsCardBtn = new RoundedButton("View");
		primaryBtn(roomsCardBtn, 10, 180, 30, 180, roomsCardPanel);
		roomsCardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ReadJson.fetchData(roomName);
				roomInfoPrice.setText(ReadJson.roomSPrice);
				roomInfoLabel.setText(ReadJson.roomFName);
				txtSingleRoom.setText(ReadJson.roomDesc);
			}
		});
	}

//	room panel
	public void roomsPanel() {
		roomsPanel.setBounds(208, 0, 1004, 625);
		getContentPane().add(roomsPanel);
		roomsPanel.setLayout(null);

		JLabel roomsHeading = new JLabel("Available Rooms");
		roomsHeading.setFont(new Font("Dialog", Font.BOLD, 20));
		roomsHeading.setBounds(57, 22, 180, 20);
		roomsPanel.add(roomsHeading);

		JPanel panel_blue = new JPanel();
		panel_blue.setBackground(new Color(0, 163, 255));
		panel_blue.setBounds(57, 43, 70, 6);
		roomsPanel.add(panel_blue);

		roomsCards("/room2.png", "singleRoom", 57, 80);
		roomsCards("/room2.png", "doubleRoom", 270, 80);
		roomsCards("/room2.png", "tripleRoom", 485, 80);
		roomsCards("/room2.png", "sampleRoom", 57, 339);
		roomsCards("/room2.png", "singleRoom", 270, 339);
		roomsCards("/room2.png", "singleRoom", 485, 339);
	}

//	room side info
	public void roomInfo(String data, String panel) {
		ReadJson.fetchData(data);
		
		roomInfoPrice.setText(ReadJson.roomSPrice);
		roomInfoLabel.setText(ReadJson.roomFName);
		txtSingleRoom.setText(ReadJson.roomDesc);
		
		infoSidePanel.setBackground(new Color(255, 255, 255));
		infoSidePanel.setBounds(944, 0, 268, 647);
		infoSidePanel.setLayout(null);
		getContentPane().add(infoSidePanel);

		JLabel roomInfoHeading = new JLabel("Room Info");
		roomInfoHeading.setHorizontalAlignment(SwingConstants.CENTER);
		roomInfoHeading.setFont(new Font("Helvetica", Font.BOLD, 20));
		roomInfoHeading.setBounds(6, 18, 256, 28);
		infoSidePanel.add(roomInfoHeading);

		roomInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomInfoLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		roomInfoLabel.setBounds(6, 66, 256, 28);
		infoSidePanel.add(roomInfoLabel);

		JPanel headingBorder = new JPanel();
		headingBorder.setBackground(new Color(0, 163, 255));
		headingBorder.setBounds(46, 47, 170, 10);
		infoSidePanel.add(headingBorder);

		JLabel roomInfoImage = new JLabel("");
		roomInfoImage.setBounds(16, 106, 235, 140);
		infoSidePanel.add(roomInfoImage);

		Image image = new ImageIcon(this.getClass().getResource(ReadJson.dummyheroIcon)).getImage();
		roomInfoImage.setIcon(new ImageIcon(image));

		JLabel floorInfo = new JLabel("Floor: 1st");
		floorInfo.setFont(new Font("Helvetica", Font.BOLD, 15));
		floorInfo.setBounds(16, 272, 92, 16);
		infoSidePanel.add(floorInfo);

		JLabel roomNumber = new JLabel("Room number: 1");
		roomNumber.setFont(new Font("Helvetica", Font.BOLD, 15));
		roomNumber.setBounds(125, 272, 126, 16);
		infoSidePanel.add(roomNumber);

		JPanel roomBottomBorder = new JPanel();
		roomBottomBorder.setBackground(new Color(0, 0, 0));
		roomBottomBorder.setBounds(109, 272, 4, 16);
		infoSidePanel.add(roomBottomBorder);

		Color custom = Color.decode("#00A3FF");
		JPanel roomInfoPriceBg = new RoundedPanel(20, custom);
		roomInfoPriceBg.setBackground(new Color(255, 255, 255));
		roomInfoPriceBg.setBounds(46, 300, 181, 36);
		infoSidePanel.add(roomInfoPriceBg);
		roomInfoPriceBg.setLayout(null);
		
		roomInfoPrice.setForeground(new Color(255, 255, 255));
		roomInfoPrice.setFont(new Font("Helvetica", Font.BOLD, 13));
		roomInfoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		roomInfoPrice.setBounds(6, 6, 169, 24);
		roomInfoPriceBg.add(roomInfoPrice);
		
		txtSingleRoom.setForeground(new Color(126, 126, 126));
		txtSingleRoom.setEditable(false);
		txtSingleRoom.setFont(new Font("Helvetica", Font.PLAIN, 15));
		txtSingleRoom.setBounds(16, 352, 235, 110);
		infoSidePanel.add(txtSingleRoom);
		StyledDocument doc = txtSingleRoom.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		RoundedButton viewBtn = new RoundedButton("View");
		primaryBtn(viewBtn, 46, 470, 38, 181, infoSidePanel);
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				homePanel.setVisible(false);
				amenitiesPanel.setVisible(false);
				roomsPanel.setVisible(false);
				infoSidePanel.setVisible(false);
				modalBg.setVisible(true);
			}
			
		});
		
		RoundedButton bookBtn = new RoundedButton("Book now");
		primaryBtn(bookBtn, 46, 518, 38, 181, infoSidePanel);
	}	

//	room modal
	public void roomModal() {
		Color blueCircle = new Color(0, 163, 255);
		Image image1 = new ImageIcon(this.getClass().getResource("/sample-image-room-info.png")).getImage();
		
	    modalBg.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
	    modalBg.setBounds(209, 0, 1003, 647);
	    getContentPane().add(modalBg);
	    modalBg.setLayout(null);

	    JPanel roomModal = new JPanel();
	    roomModal.setBounds(178, 81, 547, 466);
	    modalBg.add(roomModal);
	    roomModal.setBackground(new Color(255, 255, 255));
	    roomModal.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Info");
		lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
		lblNewLabel.setBounds(41, 21, 128, 45);
		roomModal.add(lblNewLabel);
		
		JPanel borderBottomModal = new JPanel();
		borderBottomModal.setBackground(new Color(160, 160, 160));
		borderBottomModal.setBounds(41, 56, 117, 10);
		roomModal.add(borderBottomModal);
		
		JPanel circleModal = new RoundedPanel(100, blueCircle);
		circleModal.setBackground(new Color(255, 255, 255));
		circleModal.setBounds(210, 29, 37, 37);
		roomModal.add(circleModal);
		
		JLabel roomModalTitle = new JLabel("Single room");
		roomModalTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
		roomModalTitle.setBounds(259, 31, 232, 37);
		roomModal.add(roomModalTitle);
		
		JLabel imageOne = new JLabel("");
		imageOne.setBounds(43, 105, 235, 140);
		roomModal.add(imageOne);
		imageOne.setIcon(new ImageIcon(image1));
		
		JLabel imageTwo = new JLabel("");
		imageTwo.setBounds(41, 268, 235, 140);
		roomModal.add(imageTwo);
		imageTwo.setIcon(new ImageIcon(image1));
		
		JLabel roomNumber = new JLabel("Room number: 1");
		roomNumber.setHorizontalAlignment(SwingConstants.LEFT);
		roomNumber.setFont(new Font("Helvetica", Font.BOLD, 18));
		roomNumber.setBounds(308, 77, 196, 37);
		roomModal.add(roomNumber);
		
		JPanel roomPrice = new RoundedPanel(25, blueCircle);
		roomPrice.setBackground(new Color(255, 255, 255));
		roomPrice.setBounds(308, 115, 189, 37);
		roomModal.add(roomPrice);
		roomPrice.setLayout(null);
		
		JLabel lblNight = new JLabel("1,000 - Night");
		lblNight.setForeground(new Color(255, 255, 255));
		lblNight.setBounds(6, 0, 177, 37);
		roomPrice.add(lblNight);
		lblNight.setHorizontalAlignment(SwingConstants.CENTER);
		lblNight.setFont(new Font("Helvetica", Font.BOLD, 13));
		
		JTextPane roomInfoDesc = new JTextPane();
		roomInfoDesc.setEnabled(false);
		roomInfoDesc.setForeground(new Color(153, 152, 152));
		roomInfoDesc.setFont(new Font("Helvetica", Font.PLAIN, 12));
		roomInfoDesc.setText("A single room in a hotel is a comfortable and cozy space designed for a single occupant, featuring a single bed, basic amenities, and a functional layout.");
		roomInfoDesc.setBounds(308, 164, 196, 88);
		roomModal.add(roomInfoDesc);
		
		JLabel lblNewLabel_2 = new JLabel("Features:");
		lblNewLabel_2.setFont(new Font("Helvetica", Font.BOLD, 13));
		lblNewLabel_2.setBounds(308, 264, 82, 16);
		roomModal.add(lblNewLabel_2);
		
		JLabel feature = new JLabel("- Lorem ipsum");
		feature.setFont(new Font("Helvetica", Font.PLAIN, 13));
		feature.setBounds(308, 290, 156, 16);
		roomModal.add(feature);
		
		JLabel feature1 = new JLabel("- Lorem ipsum");
		feature1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		feature1.setBounds(308, 318, 156, 16);
		roomModal.add(feature1);
		
		JLabel feature2 = new JLabel("- Lorem ipsum");
		feature2.setFont(new Font("Helvetica", Font.PLAIN, 13));
		feature2.setBounds(308, 346, 156, 16);
		roomModal.add(feature2);
		
		JLabel feature3 = new JLabel("- Lorem ipsum");
		feature3.setFont(new Font("Helvetica", Font.PLAIN, 13));
		feature3.setBounds(308, 346, 156, 16);
		modalBg.add(feature3);
		
		JButton closeModalBtn = new RoundedButton("Close");
		primaryBtn(closeModalBtn, 308, 387, 38, 160, roomModal);
		closeModalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				roomsPanel.setVisible(true);
				infoSidePanel.setVisible(true);
				modalBg.setVisible(false);
			}
		});
		
		closeModalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				roomsPanel.setVisible(true);
				modalBg.setVisible(false);
			}
		});
	}
	
	public UserInterface() throws IOException {
//		Resources.main(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 675);
		getContentPane().setLayout(null);

//		border bottom
		borders();
		
//		modal
		roomModal();
		modalBg.setVisible(false);

//		side info panel
		roomInfo("singleRoom", "homePanel");
		
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
