import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MegaMan {
	static boolean MMstand;
	static boolean NMstand;
	static int megamanx = 0;
	static int megamany = 100;
	static int negamanx;
	static int negamany;
	static boolean RightPress;
	static boolean LeftPress;
	static boolean UpPress;
	static boolean DownPress;
	static boolean WPress;
	static boolean SPress;
	static boolean DPress;
	static boolean APress;
	static boolean SpacePress;
	static boolean EnterPress;
	static int MMpicleft = 1;
	static int MMpicright = 1;
	static int MMpicup = 1;
	static int NMpicleft = 1;
	static int NMpicright = 1;
	static int NMpicup = 1;
	static int MMupcount ;
	static int NMupcount;
	static int misscount;
	static boolean NMShotRight;
	static boolean NMShotLeft;
	static int i = 0;
	public static int[] shotsfiredright = new int[100];
	public static int[] shotsfiredleft = new int[100];
	public static int[] NMMissileRightx = new int[100];
	public static int[] NMMissileLeftx = new int[100];
	public static int[] NMMissileRighty = new int[100];
	public static int[] NMMissileLefty = new int[100];
	static boolean mmdelay = false;
	static boolean nmdelay = false;
	static boolean megamanfall = true;
	static boolean negamanfall = true;
	static ImageIcon[] MMpicjumpright = new ImageIcon[7];
	static ImageIcon[] MMpicjumpleft = new ImageIcon[7];
	static ImageIcon[] NMpicjumpright = new ImageIcon[7];
	static ImageIcon[] NMpicjumpleft = new ImageIcon[7];
	static boolean MMjumpingR = false;
	static boolean MMjumpingL = false;
	
	/**	
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int abc= 0; abc < 7; abc ++)
		{
			MMpicjumpright[abc] = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegamanJumpRight" + abc + ".png");
		}
		for(int abc= 1; abc < 7; abc ++)
		{
			MMpicjumpleft[abc] = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegamanJumpLeft" + abc+ ".png");
		}
		
		for(int abc= 0; abc < 7; abc ++)
		{
			NMpicjumpright[abc] = new ImageIcon("C:\\Users\\Asmir\\PicturesF\\Java Pics\\NegamanJumpRight" + abc+ ".png");
		}
		for(int abc= 1; abc < 7; abc ++)
		{
			NMpicjumpleft[abc] = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegamanJumpLeft" + abc+ ".png");
		}
		
		
		
		//Creating The Frame for the Game
		JFrame gameframe = new JFrame("MegaMan!");
		gameframe.setSize(700,465);
		gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		final JPanel gamepanel = new JPanel();
		gamepanel.setLayout(null);
		gamepanel.setBackground(Color.GRAY);
		
		//Background
		ImageIcon backgroundpic = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\SampleMap.png");
		final JLabel background = new JLabel();
		background.setIcon(backgroundpic);
		background.setBounds(0,0,700,424);
		
		final JLabel[] invis = new JLabel[3];
		for( int abc = 0 ; abc<3 ;abc++)
		{
			invis[abc] = new JLabel();
			background.add(invis[abc]);
			invis[abc].setIcon(new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\Blank.png"));
			invis[abc].setVisible(false);
		}
		invis[0].setBounds(0,353,173,200);
		
		invis[1].setBounds(173,379,400,400);
		
		invis[2].setBounds(547,353,300,300);

		
		//MegaMan 
		final ImageIcon standright = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegaManStand1.png");
		final ImageIcon standleft = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegaManStandLeft1.png");
		final JLabel megaman = new JLabel();
		megamanx = 0;
		megamany = 0;
		megaman.setIcon(standright);
		megaman.setBounds(megamanx,megamany,36,41);
		MMstand = true;
		
		
		
		//Negaman
		final ImageIcon nmleft = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegaManStandLeft1.png");
		final ImageIcon nmright = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegaManStandRight1.png");
		final JLabel negaman = new JLabel();
		negamanx = 650;
		negamany = 0;
		negaman.setIcon(nmleft);
		negaman.setBounds(negamanx,negamany,36,41);
		NMstand = false;
		
		
		
		//Missile
		final ImageIcon rightmissile = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MissileRight.png");
		
		final JLabel[] NMMissileRight = new JLabel[100];
		for ( int abc = 0; abc < 100 ; abc ++)
		{
			NMMissileRight[abc] = new JLabel();
			NMMissileRight[abc].setBounds(0 + abc,0,42,22);
			NMMissileRight[abc].setIcon(rightmissile);
			NMMissileRight[abc].setVisible(false);
			background.add(NMMissileRight[abc]);
			background.setComponentZOrder(NMMissileRight[abc], 0);
			shotsfiredright[abc] = abc;
		}
		
		final ImageIcon leftmissile = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MissileLeft.png");
		
		final JLabel[] NMMissileLeft = new JLabel[100];
		for ( int abc = 0; abc < 100 ; abc ++)
		{
			NMMissileLeft[abc] = new JLabel();
			NMMissileLeft[abc].setBounds(0 + abc,0,42,22);
			NMMissileLeft[abc].setIcon(leftmissile);
			NMMissileLeft[abc].setVisible(false);
			background.add(NMMissileLeft[abc]);
			background.setComponentZOrder(NMMissileLeft[abc], 0);
			shotsfiredleft[abc] = abc;
		}
		
		final Timer NMShootRight = new Timer(1, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(i);
				for (int abc = 0; abc < 100 ; abc++)
				{
					if (NMMissileRight[abc].isVisible() == true)
					{
						NMMissileRightx[abc] = NMMissileRightx[abc] + 1;
						NMMissileRighty[abc] = NMMissileRight[abc].getLocation().y;
						NMMissileRight[abc].setLocation(NMMissileRightx[abc], NMMissileRighty[abc]);
						if(NMMissileRight[abc].getLocation().x + 50 > 700)
						{
							NMMissileRight[abc].setVisible(false);
							i++;
							NMMissileRight[abc].setLocation(0,0);
						}
					}
				}
				
			}
				
			
			
		});
		final Timer NMShootLeft = new Timer(1, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(i);
				for (int abc = 0; abc < 100 ; abc++)
				{
					if (NMMissileLeft[abc].isVisible() == true)
					{
						NMMissileLeftx[abc] = NMMissileLeftx[abc] - 1;
						NMMissileLefty[abc] = NMMissileLeft[abc].getLocation().y;
						NMMissileLeft[abc].setLocation(NMMissileLeftx[abc], NMMissileLefty[abc]);
						if(NMMissileLeft[abc].getLocation().x  < 0)
						{
							NMMissileLeft[abc].setVisible(false);
							i++;
							NMMissileLeft[abc].setLocation(0,0);
						}
					}
				}
				
			}
				
			
			
		});
		final Timer falling = new Timer(5, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(megamany + 38 > invis[0].getLocation().y && megamanx <= invis[0].getLocation().x + invis[0].getWidth()){
					
					if(MMstand == true && megamanfall == true)
					{
						megaman.setIcon(standright);
					}
					if(MMstand == false && megamanfall == true)
					{
						megaman.setIcon(standleft);
					}
					megamanfall = false;
				}
				if (megamany +38 > invis[2].getLocation().y && megamanx > invis[2].getLocation().x)
				{
					if(MMstand == true&& megamanfall == true)
					{
						megaman.setIcon(standright);
					}
					if(MMstand == false&& megamanfall == true)
					{
						megaman.setIcon(standleft);
					}
					megamanfall = false;
				}
				if( megamany +38 > invis[1].getLocation().y && megamanx > invis[1].getLocation().x && megamanx < invis[1].getLocation().x + invis[1].getWidth())
				{
					if(MMstand == true&& megamanfall == true)
					{
						megaman.setIcon(standright);
					}
					if(MMstand == false&& megamanfall == true)
					{
						megaman.setIcon(standleft);
					}

					megamanfall = false;
				}
				if(megamany + 38 <= invis[0].getLocation().y ){
					megamanfall = true;
				}

				
				if(negamany + 38 > invis[0].getLocation().y && negamanx <= invis[0].getLocation().x + invis[0].getWidth()){
					
					if(NMstand == true && negamanfall == true)
					{
						negaman.setIcon(nmright);
					}
					if(NMstand == false && negamanfall == true)
					{
						negaman.setIcon(nmleft);
					}
					negamanfall = false;
				}
				if (negamany +38 > invis[2].getLocation().y && negamanx > invis[2].getLocation().x)
				{
					if(NMstand == true&& negamanfall == true)
					{
						negaman.setIcon(nmright);
					}
					if(NMstand == false&& negamanfall == true)
					{
						negaman.setIcon(nmleft);
					}
					negamanfall = false;
				}
				if( negamany +38 > invis[1].getLocation().y && negamanx > invis[1].getLocation().x && negamanx < invis[1].getLocation().x + invis[1].getWidth())
				{
					if(NMstand == true&& negamanfall == true)
					{
						negaman.setIcon(nmright);
					}
					if(NMstand == false&& negamanfall == true)
					{
						negaman.setIcon(nmleft);
					}

					negamanfall = false;
				}
				if(negamany + 38 <= invis[0].getLocation().y ){
					negamanfall = true;
				}
				
			}
			
		});
		falling.start();
		
		final Timer Gravity = new Timer(5, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (megamanfall == true)
				{
					megamany ++;
					megaman.setLocation(megamanx, megamany);
					negaman.setLocation(negamanx, negamany);
					if(MMstand == true)
					{
						megaman.setIcon(new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegaManJumpRight4.png"));
					}
					if(MMstand == false)
					{
						megaman.setIcon(new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegaManJumpLeft4.png"));
					}
				}
				if (negamanfall == true)
				{
					negamany ++;
					megaman.setLocation(megamanx, megamany);
					negaman.setLocation(negamanx, negamany);
					if(NMstand == true)
					{
						negaman.setIcon(NMpicjumpright[0]);
					}
					if(NMstand == false)
					{
						negaman.setIcon(new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegaManJumpLeft4.png"));
					}
				}
				
				
				
			}
			
		});
		
		
		Gravity.start();
		
		gameframe.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP)
				{
					UpPress = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					DownPress = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					LeftPress = true;
					MMstand = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					RightPress = true;
					MMstand = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_W)
				{
					WPress = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_S)
				{
					SPress = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_A)
				{
					APress = true;
					NMstand = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_D)
				{
					DPress = true;
					NMstand = true;
				}
				if (e.getKeyCode()== KeyEvent.VK_SPACE && NMstand == true && nmdelay == false)
				{
					if (i >= 100)
					{
						i = 0;
					}
					SpacePress = true;
					misscount++;
					NMShotRight = true;
					NMShootRight.start();
					
					
					NMMissileRightx[i]= negamanx + 20;
					NMMissileRighty[i] = negamany +5;
					NMMissileRight[i].setVisible(true);
					NMMissileRight[i].setLocation(NMMissileRightx[i], NMMissileRighty[i]);
					i++;
					
					ImageIcon NMShootRight = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegamanShootRight.png");
					negaman.setIcon(NMShootRight);
					nmdelay = true;
					
				}
				if (e.getKeyCode()== KeyEvent.VK_SPACE && NMstand == false && nmdelay == false)
				{
					if (i >= 100)
					{
						i = 0;
					}
					SpacePress = true;
					misscount++;
					NMShotLeft = true;
					NMShootLeft.start();
					
					
					NMMissileLeftx[i]= negamanx -10 ;
					NMMissileLefty[i] = negamany +5;
					NMMissileLeft[i].setVisible(true);
					NMMissileLeft[i].setLocation(NMMissileLeftx[i], NMMissileLefty[i]);
					i++;
					
					ImageIcon NMShootLeft = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegamanShootLeft.png");
					negaman.setIcon(NMShootLeft);
					nmdelay = true;
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP)
				{
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					DownPress = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					LeftPress = false;
					megaman.setIcon(standleft);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					RightPress = false;
					megaman.setIcon(standright);
				}
				if (e.getKeyCode() == KeyEvent.VK_W)
				{
					
				}
				if (e.getKeyCode() == KeyEvent.VK_S)
				{
					SPress = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_A)
				{
					APress = false;
					negaman.setIcon(nmleft);
				}
				if (e.getKeyCode() == KeyEvent.VK_D)
				{
					DPress = false;
					negaman.setIcon(nmright);
				}
				if (e.getKeyCode()== KeyEvent.VK_SPACE)
				{
					SpacePress = false;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		Thread running = new Thread(){
		public void run(){
			while(true){
				
				if (UpPress && MMstand == true ){
					
					if (MMpicup > 0 && MMpicup < 6)
					{
						MMupcount = -20;
						megamany = megamany + MMupcount;
						megaman.setLocation(megamanx,megamany);
						megaman.setIcon(MMpicjumpright[MMpicup]);
						MMpicup = MMpicup + 1;
					}
					
					if (MMpicup == 6)
					{
						megaman.setIcon(standright);
						MMpicup = 1;
					}
					
					
						
				}
				if (UpPress && MMstand == false){
					
					if (MMpicup >= 1 && MMpicup <=7)
					{
						MMupcount = -20;
						megamany = megamany + MMupcount;
						megaman.setLocation(megamanx,megamany);
						megaman.setIcon(MMpicjumpleft[MMpicup]);
						MMpicup = MMpicup + 1;
					}
					
					if (MMpicup == 8)
					{
						megaman.setIcon(standleft);
						MMpicup = 1;
						UpPress = false;
					}
						
				}
				if (LeftPress && megamanx >0){
					megamanx = megamanx -9;
					megaman.setLocation(megamanx, megamany);
					if (UpPress == false)
					{
						ImageIcon abcd = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegaManRunLeft" + MMpicleft +".png");
						megaman.setIcon(abcd);
						MMpicleft = MMpicleft + 1;
						
						if(MMpicleft == 11)
						{
							MMpicleft = 1;
						}
					}
					if(megamanx +36 < invis[2].getLocation().x && megamanx > invis[0].getLocation().x + invis[0].getWidth() && megamany  <= invis[0].getLocation().y-20)
					{
						megamanfall = true;
					}
					
				}
				if (RightPress && megamanx < 700 ){
					megamanx = megamanx +9;
					megaman.setLocation(megamanx, megamany);
					if (UpPress == false)
					{
						ImageIcon abcd = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\MegaManRunRight" + MMpicright +".png");
						megaman.setIcon(abcd);
						MMpicright = MMpicright + 1;
						if(MMpicright == 11)
						{
							MMpicright = 1;
						}
					}
					if(megamanx > invis[0].getLocation().x + invis[0].getWidth() && megamanx < invis[2].getLocation().x && megamany <= invis[0].getLocation().y -20 )
					{
						megamanfall = true;
					}
					
				}
				if (DownPress){
					
				}
				
				if (WPress && NMstand == true){
					if (NMpicup >= 1 && NMpicup <=7){
						NMupcount = -20;
						negamany = negamany + NMupcount;
						negaman.setLocation(negamanx,negamany);
						
						
						negaman.setIcon(NMpicjumpright[0]);
						NMpicup ++;
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if (NMpicup == 8)
					{
						negaman.setIcon(nmright);
						NMpicup = 1;
						WPress = false;
					}
					
				}
				if (WPress && NMstand == false)
				{
					if (NMpicup >= 1 && NMpicup <=7){
						NMupcount = -20;
						negamany = negamany + NMupcount;
						negaman.setLocation(negamanx,negamany);
						
						ImageIcon abcd = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegaManJumpLeft" + NMpicup +".png");
						negaman.setIcon(abcd);
						NMpicup ++;
					}
					
					if (NMpicup == 8)
					{
						negaman.setIcon(nmleft);
						NMpicup = 1;
						WPress = false;
					}
				}
				if (SPress){
					
				}
				if (APress && negamanx >0){
					negamanx = negamanx -9;
					negaman.setLocation(negamanx, negamany);
					if (WPress == false)
					{
						ImageIcon abcd = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegaManRunLeft" + NMpicleft +".png");
						negaman.setIcon(abcd);
						NMpicleft = NMpicleft + 1;
						
						if(NMpicleft == 11)
						{
							NMpicleft = 1;
						}
					}
					if(negamanx +36 < invis[2].getLocation().x && negamanx > invis[0].getLocation().x + invis[0].getWidth() && negamany  <= invis[0].getLocation().y-20)
					{
						negamanfall = true;
					}
					
				}
				if (DPress && negamanx <700){
					negamanx = negamanx +9;
					negaman.setLocation(negamanx, negamany);
					if (WPress == false)
					{
						ImageIcon abcd = new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\NegaManRunRight" + NMpicleft +".png");
						negaman.setIcon(abcd);
						NMpicleft = NMpicleft + 1;
						
						if(NMpicleft == 11)
						{
							NMpicleft = 1;
						}	
					}
					if(negamanx > invis[0].getLocation().x + invis[0].getWidth() && negamanx < invis[2].getLocation().x && negamany <= invis[0].getLocation().y -20)
					{
						negamanfall = true;
					}
					
				}
				
				
			
				
				try{
					Thread.sleep(50);
				}
				catch (Exception e){}
				}
			}
		};
		running.start();
		
	
		Timer delay = new Timer(1, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (nmdelay == true)
				{
					nmdelay = false;
					
				}
			}
			
		});
		delay.start();
		
		
		//Adding
		gameframe.add(gamepanel);
		gamepanel.add(background);
		background.add(megaman);
		background.add(negaman);
		
		gamepanel.setComponentZOrder(megaman, 0);
		gamepanel.setComponentZOrder(negaman, 1);
		gamepanel.setComponentZOrder(background, 2);
		
		
		//setting
		gameframe.setVisible(true);
		gameframe.requestFocus();
		
	}

}
