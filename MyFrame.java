import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;





public class MyFrame {
	JFrame frame=new JFrame();				// 전체 GUI를 담을 프레임에 대한 레퍼런스

	final int MARGIN = 20;   // 그림에 얼마 범위에 들어왔을 때 충돌로 결정할 것인지의 값(작은 그림)
	final int ALL_WIDTH = 650; 		// 전체 frame의 폭600,400 사용하기위해
	final int ALL_HEIGHT = 418; 	// 전체 frame의 높이 418
	final int M_WIDTH=715; 	//596 *1.3=780 *1.2=715 *1.15 = 685
	final int M_HEIGHT=380;	//320 320*1.3 =417 320*1.2= 384 320*1.15 = 368

	// 소리들
	SoundPlayer LobbyMusic = new SoundPlayer("LobbyMusic.wav");
	SoundPlayer gameMusic = new SoundPlayer("gameMusic.wav");
	SoundPlayer gameMusic2 = new SoundPlayer("gameMusic2.wav");
	SoundPlayer jumpMusic = new SoundPlayer("jump2.wav");
	SoundPlayer closeMusic = new SoundPlayer("CloseMusic.wav");
	SoundPlayer charHit = new SoundPlayer("explode_1.wav");
	boolean lastmusicbol=true;
	// ************배경 움직이기*******************************************
	int backX1=0;		//1탄배경이동
	int backX1_2=800;
	int backX2=0;
	int backX2_2=800;

	int backX10=0;		//2탄배경이동
	int backX10_2=650;
	int backX20=0;
	int backX20_2=650;
	int backX3=0;
	int backX3_1=650;
	int backX4=0;
	int backX4_1=650;

	int backCnt1=0;
	int foothold=80; // 발판좌표
	int Cokiecnt=0;
	int Cokiecnt2=0;

	int stepHurddle=400; // 허들 이동값 *2
	int stepRnc=400;//젤리 *3
	final int initX=130; // 초기의 캐릭터 값
	final int initY=218; // 초기의 캐릭터값

	int Char_W=79; // 쿠키크기
	int Char_H=85;

	int CharPx=120;
	int CharPy=218; // 초기값 218


	int CharCenX=CharPx+Char_W/2; // 캐릭터의 중앙
	int CharCenY=CharPy+Char_H/2; // 캐릭터의 중앙

	int hurddleReturnX=0;
	int hurddleReturnX2=0; // 이값을 사용해 맵변환하기
	int hurddleReturnX3=0;

	int ScoreTime=0;
	int ScoreRnc=0;
	int ScoreAll=0;

	int times =0;
	int Hp=490; // 수정
	int Hpcnt;


	RncUpDown rncupdown = new RncUpDown();
	Rncother rncother = new Rncother();
	//*****************************버튼*********************************************

	JButton startButtonImage = new JButton(new ImageIcon("src/gamestart3.png"));

	ImageIcon endbutton = new ImageIcon("src/endbuttons1.png");	//끝내기, 계속하기, 
	ImageIcon endbutton_end = new ImageIcon("src/endbuttons2.png");// 랭킹보기 옵션
	ImageIcon GameEndResult = new ImageIcon("src/게임 결과.jpg");
	ImageIcon musicSwitchOn = new ImageIcon("src/button/switch_on.png");

	ImageIcon musicSwitchOff = new ImageIcon("src/button/switch_off.png");

	JButton optionButtonImage = new JButton(new ImageIcon("src/endbuttons2.png")); 
	JButton endButtonImage = new JButton(new String("재도전"));
	JButton endButtonImage2 = new JButton(new String("나가기"));
	


	//******************쿠키행동********************
	boolean run=true;
	boolean jump=false;
	boolean Djump = false;
	boolean slide = false;
	boolean hall = false;
	boolean firstRound = true;
	boolean secondRound = false;
	boolean collideTurn = false; // 장애물 부딪힘 여부;
	boolean collideOnce = true;
	boolean music = true;
	boolean Esc = false;
	boolean musicOnOff =true;
	boolean clickedStop=false;

	//*********************패널
	JPanel controlPanel=new JPanel();		// 게임 컨트롤과 시간, 사용자 디스플레이가 들어갈 패널

	JLayeredPane lp = new JLayeredPane();	// 화면을 여러장 겹치기 위한 PaneL 레이어
	JPanel coverPanel;						// 초기화면이 나타날 패널	
	GamePanel  gamepanel=new GamePanel();
	StartPanel startpanel = new StartPanel();

	endPanel endpanel = new endPanel();

	//***************************


	Timer goGround;							// 배경이동과 객체들의 속도
	Timer goChar;
	Timer goTime;
	static String playerName;				// 플에이어 이름
	DirectionListener keyListener;			// 화살표 움직임을 감지하는 리스너

	ClockListener clockListener;			// 시계를 구현하기 위한 리스너



	// 초기화면
	PosImageIcon StartImage = new PosImageIcon("src/IMAGE/startimage.png",0,0,ALL_WIDTH, ALL_HEIGHT,630);

	//배경
	ImageIcon Back_1_1 = new ImageIcon("src/IMAGE/firstRound.png"); // 마지 넓이
	ImageIcon Back_1_2 = new ImageIcon("src/IMAGE/firstRound.png"); //863, 162 
	ImageIcon Back_2_1 = new ImageIcon("src/IMAGE/secondround.png");
	ImageIcon Back_2_2 = new ImageIcon("src/IMAGE/secondround.png");
	ImageIcon Back_2_3 = new ImageIcon("src/IMAGE/secondround.png");
	ImageIcon Back_2_4 = new ImageIcon("src/IMAGE/secondround.png");
	ImageIcon BackStop = new ImageIcon("src/일시정지 불투명.png");

	ImageIcon SlideButton0 = new ImageIcon("src/IMAGE/SlideButton_0.png");
	ImageIcon SlideButton1 = new ImageIcon("src/IMAGE/SlideButton_1.png");

	ImageIcon JumpButton0 = new ImageIcon("src/IMAGE/JumpButton_0.png");
	ImageIcon JumpButton1 = new ImageIcon("src/IMAGE/JumpButton_1.png");


	PosImageIcon startButton = new PosImageIcon("src/gamestart3.png", 0, 0, 100, 50);
	PosImageIcon startButtonPressed = new PosImageIcon("src/gamestart4.png",0,0,100,50);


	// 캐릭터 삽입
	ImageIcon g_character1= new ImageIcon("src/char/runner1.png"); // 120/135 * 1.2  144/162
	ImageIcon g_character2= new ImageIcon("src/char/runner2.png");
	ImageIcon g_character3= new ImageIcon("src/char/runner3.png");
	ImageIcon g_character4= new ImageIcon("src/char/runner4.png");


	ArrayList<ImageIcon> generalChar ;
	ArrayList<ImageIcon> jumpChar;
	ArrayList<ImageIcon> slideChar;

	ImageIcon j_char0 = new ImageIcon("src/char/jump1.png");
	ImageIcon j_char1 = new ImageIcon("src/char/jump2.png");
	ImageIcon j_char2= new ImageIcon("src/char/jump3.png");

	ImageIcon Sl_char0= new ImageIcon("src/char/slide1.png");
	ImageIcon Sl_char1= new ImageIcon("src/char/slide2.png");

	//맞았을때
	ImageIcon char_hit= new ImageIcon("src/char/Char_Hit.png");

	//착지모션
	ImageIcon landing = new ImageIcon("src/char/landing.png");
	// 점수표시위한 곰
	ImageIcon Gom = new ImageIcon("src/Rnc/Gom_rnc4.png"); // 58,59

	// 발판
	ImageIcon Ep1_footHold = new ImageIcon("src/IMAGE/firstfoothold.png");// 380-73 = 307  다른거 그릴때 (307-높이)로 줄것
	ImageIcon Ep2_footHold = new ImageIcon("src/IMAGE/secondfootHold.png");

	//HP bar
	ImageIcon Hpbar1 = new ImageIcon("src/IMAGE/HpBar.png");
	ImageIcon Hpbar2 = new ImageIcon("src/IMAGE/HbBark.gif");

	ArrayList<Rnc> rnc;

	// 장애물 삽입

	//// 장애물을 바로 점프에 넣지 말고 이미지 아이콘으로 넣은 다음에 랜덤값을 받아 출력하도록 한ㄷ

	//Jump what = new Jump(img, x, y, sizeX, sizeY);

	Jump ep1_jump1= new Jump("src/hurddleImage/ep1_jump1.png",600,240,45,60);
	Jump ep1_jump2= new Jump("src/hurddleImage/ep1_jump2.png",800,240,45,60);
	Jump ep1_jump3= new Jump("src/hurddleImage/ep1_jump3.png",800,240,45,60);

	Jump ep2_jump1 = new Jump("src/hurddleImage/ep1_jump1.png",600,240,45,60);
	Jump ep2_jump2 = new Jump("src/hurddleImage/ep3 jump2.png",600,240,45,60);
	Jump ep2_jump3 = new Jump("src/hurddleImage/ep3 jump2.png",600,240,45,60);

	Slide ep1_slide1= new Slide("src/hurddleImage/professor3.png",800,-20,65,270);
	Slide ep1_slide2= new Slide("src/hurddleImage/professor4.png",800,-20,65,270);

	Slide ep2_slide1 = new Slide("src/hurddleImage/professor3.png",800,-20,65,270);
	/*
	ImageIcon ep1_Djump1 = new ImageIcon("src/hurddleImage/ep1_Djump2.png"); //34,54 304-54=250
	ImageIcon ep1_Djump2 = new ImageIcon("src/hurddleImage/ep1_Djump2.png"); //34,54 304-54=250
	ImageIcon ep1_down1 = new ImageIcon("src/hurddleImage/ep1_down1.png"); //34,54 304-54=250
	ImageIcon ep1_down2 = new ImageIcon("src/hurddleImage/ep1_down2.png"); //34,54 304-54=250
	//Slide ep1_slide3_0 = new Slide("src/hurddleImage/ep1_slide3_0.png",600,240,45,60); //34,54 304-54=250
	//Slide ep1_slide3_1 = new Slide("src/hurddleImage/ep1_slide3_1.png",600,240,45,60); //304-54=250
	//Slide ep1_slide3_2 = new Slide("src/hurddleImage/ep1_slide3_2.png",600,240,45,60); //34,54 304-54=250

	 */
	ArrayList<Jump> ep1Jump;
	ArrayList<Slide> ep1Slide;
	ArrayList<ImageIcon> what;// 이중 어레이 리스트

	int hurddleRan = (int)(Math.random()*5);// 0~5;

	int casew=4;//(int)(Math.random()*3)+1;
	int casew2=2;//casew+1;//(int)(Math.random()*3)+2;
	int casew3=1;
	boolean once =true;
	boolean once2 =true;
	boolean twice = true;
	boolean third = true;


	public static void main(String[] args){

		MyFrame myframe = new MyFrame();
		myframe.go();

	}
	
	
	public void go(){

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기버튼 누러서 종료하면 프로세스는 계속실행중이기에 이명령으로 끊다

		LobbyMusic.startPlay();
		//****************리스너 설치
		gamepanel.addKeyListener(new DirectionListener());
		gamepanel.addMouseListener(new StopListener());
		startButtonImage.addMouseListener(new StartListener());
		optionButtonImage.addActionListener(new EndListener());

		endpanel = new endPanel();
		// lp사용해서 배경 순서 만들기 
		lp.add(startpanel, new Integer(2));
		startpanel.setSize(M_WIDTH, M_HEIGHT);
		lp.add(gamepanel, new Integer(1));
		gamepanel.setSize(M_WIDTH, M_HEIGHT);
		lp.add(endpanel,new Integer(0)); /// 패널들 변환
		endpanel.setSize(M_WIDTH, M_HEIGHT);
		frame.add(lp);
		frame.setTitle("쿠키런, 뛰어뛰어!!");
		frame.setVisible(true);
		frame.setResizable(true); // 창 늘리기 가능/불가
		frame.setSize(ALL_WIDTH, ALL_HEIGHT);
		endpanel.add(endButtonImage);
		endpanel.add(endButtonImage2);


		endButtonImage.addActionListener(new restartListener ());
		endButtonImage2.addActionListener(new EndListener());

		///////**********************타이머***********************
		goGround = new Timer(30,new GroundListener() );	// 스피드		//24//34
		goChar = new Timer(25,new CookieListener() );	 //goChar = 40; //20//30
		goTime = new Timer(100,new ClockListener());					//100		//50			

		//*********Char ArrayList 선언*****************

		generalChar = new ArrayList<ImageIcon>();{//4개
			generalChar.add(g_character1);//0
			generalChar.add(g_character2);//1
			generalChar.add(g_character3);//2
			generalChar.add(g_character4);//3
		}
		jumpChar= new ArrayList<ImageIcon>();{//5개

			jumpChar.add(j_char0);
			jumpChar.add(j_char1);
			jumpChar.add(j_char2);
			jumpChar.add(landing);
			jumpChar.add(landing);

		}
		slideChar = new ArrayList<ImageIcon>();{ //2개
			slideChar.add(Sl_char0);
			slideChar.add(Sl_char1);
		}
	}


	private class ClockListener implements ActionListener {

		// goTime = new Timer(100,new ClockListener()); 1초당 1000점
		public void actionPerformed (ActionEvent event) {		
			ScoreTime+=35;

			times++;						
			Hpcnt++;
			if(Hpcnt>1){// HP게이지깎는 속도조절
				Hp--;
				Hpcnt=0;
			}
		}

		public void reset() {
			times = 0;
		}
	}


	public class GroundListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(backCnt1>1){    // 화면전환
				firstRound=false;
			}
			if(backCnt1>0){
				secondRound=true;


			}
			if(firstRound){
				backX1-=2;
				backX1_2-=2;
				backX2-=4;
				backX2_2-=4;
			}
			if(secondRound){
				backX10-=2;
				backX10_2-=2;
				backX20-=5;
				backX20_2-=5;
				backX3-=7;
				backX3_1-=7;
				backX4-=8;
				backX4_1-=8;
			}
			foothold-=9; // 발판 속도

			if(hurddleReturnX<-350){
				once=true;

			}
			if(hurddleReturnX2<-350){
				twice=true;
			}

			if(hurddleReturnX3<-350){
				third=true;
			}
			if(ep1_jump1.getX()>-400)
				ep1_jump1.go(9); // 장애물의 이동속도
			if(ep1_jump2.getX()>-400) // 이미지를 멈춰서 메모리 과부하를 미연방지
				ep1_jump2.go(9);
			if(ep1_jump3.getX()>-400)
				ep1_jump3.go(9);
			if(ep1_slide1.getX()>-400)
				ep1_slide1.go(9);
			if(ep1_slide2.getX()>-400)
				ep1_slide2.go(9);

			if(rncother.getX()>-400)
				rncother.go(9);
			if(rncupdown.getX()>-400)
				rncupdown.go(9);

			if(ep2_jump1.getX()>-400)
				ep2_jump1.go(9); // 장애물의 이동속도
			if(ep2_jump2.getX()>-400) // 이미지를 멈춰서 메모리 과부하를 미연방지
				ep2_jump2.go(9);
			if(ep2_jump3.getX()>-400)
				ep2_jump3.go(9);
			if(ep2_slide1.getX()>-400)
				ep2_slide1.go(9);

			CharCenX=CharPx+Char_W/2; // 캐릭터의 중앙
			CharCenY=CharPy+Char_H/2; // 캐릭터의 중앙

			frame.repaint();
			frame.setVisible(true);


		}
	}

	public class CookieListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(run==true){  // 스레드? 이용한 캐릭터 움직임 사용
				Cokiecnt++;
				if (Cokiecnt == 4)
					Cokiecnt =0;
			}
			if(jump==true){ // 3_6 // 가속도 올라가는 속도차이
				if(Cokiecnt2==1)
					CharPy-=20;
				else if(Cokiecnt2==2)
					CharPy-=8;
				else if (Cokiecnt2==3)
					CharPy-=5;
				else if(Cokiecnt2==4)
					CharPy-=3;
				else if (Cokiecnt2==5)
					CharPy-=1;
				else if(Cokiecnt2==6)
					CharPy+=4;
				else if(Cokiecnt2==7)
					CharPy+=8;
				else if (Cokiecnt2==8)
					CharPy+=15;
				else if(Cokiecnt2==9)
					CharPy+=10;
				Cokiecnt++;

				if(Cokiecnt==3){
					Cokiecnt2++;
					if(Cokiecnt2==10){
						Cokiecnt=3;

					}
					else
						Cokiecnt=0;
				}
				else if(Cokiecnt>4){
					Cokiecnt=0;
					Cokiecnt2=0;
					jump=false;
					run=true;
					CharPy=218;
				}
			}
			if(Djump==true){

			}

			if(slide==true){
				Cokiecnt++;
				if (Cokiecnt ==2)
					Cokiecnt =0;
			}

			frame.repaint();
			frame.setVisible(true);
		}


	}


	public class StartPanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g.clearRect(0,0,WIDTH,HEIGHT);
			g.drawImage(StartImage.getImage(), 0,0,  650, 400, this); // 전체 프레임 크기: 600,400

			startButtonImage.setBounds(173,305,297,50); // 게임시작버튼

			startButtonImage.setOpaque(false);
			startButtonImage.setContentAreaFilled(false);
			startButtonImage.setBorderPainted(false);

			startpanel.add(startButtonImage);

			startButtonImage.addMouseListener(new StartListener());

	
		}
	}


	class GamePanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			clickedStop=false;

			// 1탄 배경1

			if(firstRound){
				g.drawImage(Back_1_1.getImage(), backX1,0, 800,600, this);

				g.drawImage(Back_1_1.getImage(), backX1_2,0, 800,600, this);

				if(backX1<=-800){ // 배경이 일정부분이상 넘어가면 다시그려준다.
					backCnt1++;
					backX1=800;
				}
				if(backX1_2<=-800)
					backX1_2=800;
				//1탄 배경2

				g.drawImage(Back_1_2.getImage(), backX2,210, 863,170, this);
				g.drawImage(Back_1_2.getImage(), backX2_2,210, 863,170, this);


				if(backX2<=-863){
					backX2=863;

				}

				if(backX2<=-863)
					backX2_2=863;

			}

			if(secondRound){
				if(music){
					if(musicOnOff){
						gameMusic.stopPlayer();
						gameMusic2.startPlay();
					}
					music=false;
				}
				g.drawImage(Back_2_1.getImage(), backX10,0, 650,320, this);
				g.drawImage(Back_2_1.getImage(), backX10_2,0,650,320, this);
				if(backX10<=-650) 
					backX10=650;
				if(backX10_2<=-650)
					backX10_2=650;

				g.drawImage(Back_2_2.getImage(), backX20,0, 750,320, this);
				g.drawImage(Back_2_2.getImage(), backX20_2,0, 750,320, this);
				if(backX20<=-750)
					backX20=750;
				if(backX20_2<=-750)
					backX20_2=750;

				g.drawImage(Back_2_3.getImage(), backX3,0, 750,320, this);
				g.drawImage(Back_2_3.getImage(), backX3_1,0, 750,320, this);
				if(backX3<=-750)
					backX3=750;
				if(backX3_1<=-750)
					backX3_1=750;

				g.drawImage(Back_2_4.getImage(), backX4,150, 800,170, this);
				g.drawImage(Back_2_4.getImage(), backX4_1,150, 800,170, this);
				if(backX4<=-790)
					backX4=790;
				if(backX4_1<=-790)
					backX4_1=790;

			}
			//*************젤리, 장애물 그림

			drawRnc(g2d); // 젤리 그려줌

			if(firstRound){
				if(secondRound==false)
					drawHurddle(g2d); 
			}
			if(secondRound) // 이렇게하는 이유는 2탄으로 맵이바꼈을때 1탄아이템이 안나오도록

				drawHurddleEp2(g2d);

			//***********점수계산*********************

			ScoreRnc=ep1_jump1.getScore()+ep1_jump2.getScore()+ep1_jump3.getScore()+ep1_slide1.getScore()+
					ep1_slide2.getScore()+rncupdown.getScore()+ep2_jump1.getScore()+ep2_jump2.getScore()+ep2_jump3.getScore()
					+ ep2_slide1.getScore();

			//************캐릭터그리기*****************************************

			if(collideTurn){ // 충돌시
				g.drawImage(char_hit.getImage(), CharPx-25, CharPy, 68	, 85, this);
				if(collideOnce){
					if(musicOnOff)
						charHit.startPlay();
					Hp-=100;
					collideOnce=false; //충돌시
				}
			}
			else{

				if(run==true)
					g.drawImage(generalChar.get(Cokiecnt).getImage(), CharPx, CharPy, 79, 	85, this);  // CharPy=228; 72,78

				else if(jump==true)
					g.drawImage(jumpChar.get(Cokiecnt).getImage(), CharPx, CharPy, 79, 	85, this);  // CharPy=228; 72,78

				else if(slide==true){
					CharPy=218+33;
					CharCenX=CharPx+Char_W/2; // 캐릭터의 중앙
					CharCenY=CharPy+Char_H/2; // 캐릭터의 중앙 228
					g.drawImage(slideChar.get(Cokiecnt).getImage(), CharPx, CharPy, 79, 	50, this);  // CharPy=228; 72,78
				}
				collideOnce=true;// 충돌 재설정
			}

			//***************발판*************************************
			if(firstRound)
				for(int i=0;i<100;i++){

					g.drawImage(Ep1_footHold.getImage(),foothold+80*i,M_HEIGHT-80, 80, 80, this);
				}
			if(secondRound)
				for(int i=0;i<100;i++){

					g.drawImage(Ep2_footHold.getImage(),foothold+80*i,M_HEIGHT-80, 80, 80, this);
				}
			if(foothold<=-960)
				foothold=0;

			//********************** HP bar*************************************

			g.drawImage(Hpbar1.getImage(), 0, 50, 580, 50, null);
			g.drawImage(Hpbar2.getImage(), 87, 70, Hp, 15, null);
			if(Hp<5){
				lp.setLayer(endpanel, 5);				// gamePanel 이 앞으로 나오게 함

				endpanel.setFocusable(true);					// gamePanel이 포커싱될 수 있게 함
				endpanel.requestFocus();


				stopAll();

			}


			//  점프, 슬라이드 이미지 효과
			if(jump)
				g2d.drawImage(JumpButton1.getImage(), 10, 280, 120, 90, null);
			else
				g2d.drawImage(JumpButton0.getImage(), 10, 280, 120, 90, null);

			if(slide)
				g2d.drawImage( SlideButton1.getImage(), 500,280,120,90,null);
			else
				g2d.drawImage( SlideButton0.getImage(), 500,280,120,90,null);


			// 상단 젤리갯수와 총점수
			g2d.setFont(new Font("나눔고딕", Font.BOLD, 30));
			g2d.setColor(Color.WHITE);
			ScoreAll=ScoreRnc+ScoreTime;
			g2d.drawString("점수:"+ScoreAll, 420,30);
			g2d.drawImage(Gom.getImage(), 260, 10, 40, 35,null);
			g2d.drawString(ScoreRnc/100+"", 305,33);


			if(Esc){ // 정지를 눌렀을때
				stopAll();
				g2d.drawImage(BackStop.getImage(),0,0,640,390,this);

				g2d.drawImage(endbutton.getImage(),260,120,160,55,this);

				g2d.drawImage(endbutton_end.getImage(),260,190,160,55,this);
				g2d.setFont(new Font("나눔고딕", Font.BOLD, 30));
				g2d.setColor(Color.white);
				g2d.drawString("계속하기", 280,155);
				g2d.drawString("나가기", 290, 225);		



				if(musicOnOff) // on상태
					g2d.drawImage(musicSwitchOn.getImage(),280,250,120,40,this);
				else
					g2d.drawImage(musicSwitchOff.getImage(),280,250,120,40,this);
				//if( 온오프 버튼 클릭시 )
				// misiconoff== false;
				if(musicOnOff){ // 젤리 효과음 죽이기 , 나머지배경음은 나올때 다 효과 넣어줬음

					ep1_jump1.setMusicGo();
					ep1_jump2.setMusicGo();
					ep1_jump3.setMusicGo();
					ep1_slide1.setMusicGo();
					ep1_slide2.setMusicGo();

					ep2_jump1.setMusicGo();
					ep2_jump2.setMusicGo();
					ep2_jump3.setMusicGo();

					ep2_slide1.setMusicGo();
					rncother.setMusicGo();
					rncupdown.setMusicGo();
				}
				else{

					ep1_jump1.setMusicStop();
					ep1_jump2.setMusicStop();
					ep1_jump3.setMusicStop();
					ep1_slide1.setMusicStop();
					ep1_slide2.setMusicStop();

					ep2_jump1.setMusicStop();
					ep2_jump2.setMusicStop();
					ep2_jump3.setMusicStop();

					ep2_slide1.setMusicStop();
					rncother.setMusicStop();
					rncupdown.setMusicStop();
				}




			}

			g2d.setColor(Color.white);
			// 가로줄

			//세로줄
			/*
			g2d.drawLine(0, 50, 800, 50);
			g2d.drawLine(0, 100, 800, 100);
			g2d.drawLine(0, 150, 800, 150);
			g2d.drawLine(0, 200, 800, 200);
			g2d.drawLine(0, 250, 800, 250);
			g2d.drawLine(0, 300, 800, 300);
			g2d.drawLine(0, 350, 800, 350);
			g2d.drawLine(0, 400, 800, 400);

			g2d.drawLine(50, 0, 50, 400);
			g2d.drawLine(100, 0, 100, 400);
			g2d.drawLine(150, 0, 150, 400);
			g2d.drawLine(200, 0, 200, 400);
			g2d.drawLine(250, 0, 250, 400);
			g2d.drawLine(300, 0, 300, 400);
			g2d.drawLine(350, 0, 350, 400);
			g2d.drawLine(400, 0, 400, 400);
			g2d.drawLine(450, 0, 450, 400);
			g2d.drawLine(500, 0, 500, 400);
			g2d.drawLine(550, 0, 550, 400);
			g2d.drawLine(600, 0, 600, 400);
			g2d.drawLine(650, 0, 650, 400);
			g2d.drawLine(700, 0, 700, 400);
			 */




		}
	}
	class endPanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			//	g2d.setFont("NanumGothicOTF",170);

			g2d.drawImage(GameEndResult.getImage(),0,0,640,390,this);

			g2d.setColor(Color.black);
			g2d.setFont(new Font("나눔고딕", Font.BOLD, 35));
			g2d.setColor(Color.white);
			g2d.setFont(new Font("나눔고딕", Font.BOLD, 30));
			g2d.setColor(Color.black);

			if(lastmusicbol){
				closeMusic.startPlay();
				lastmusicbol=false;
			}
			g2d.drawString("                          "
					+ " 획득젤리 :        "+ScoreRnc/100+"개", 65,245);
			g2d.drawString("                           "
					+ "게임시간 :  "+times/10/60+"분 "+times/10%60+"초", 65,295);// delay가 100밀리초

			g2d.setFont(new Font("나눔고딕", Font.BOLD, 50));

			g2d.drawString("총 점수 : "+ScoreAll, 120,180);

			g2d.setFont(new Font("나눔고딕", Font.BOLD, 40));
			
			endButtonImage.setFont(new Font("나눔고딕", Font.BOLD, 40));
			endButtonImage2.setFont(new Font("나눔고딕", Font.BOLD, 40));
			endButtonImage.setForeground(Color.white);
			endButtonImage2.setForeground(Color.white);
		
			//	g2d.drawImage(endbutton.getImage(),130,320,180,60,this);
			//g2d.drawImage(endbutton_end.getImage(),320,320,180,60,this);
			endButtonImage.setBounds(130,320,185,60); // 게임종료버튼

			//endButtonImage.setSize(100, 100);
			endButtonImage2.setBounds(320,320,185,60); // 게임종료버튼
			//endButtonImage.setVisible(false);
			//endButtonImage2.setVisible(false);
			endButtonImage.setOpaque(false);
			endButtonImage2.setOpaque(false);
			endButtonImage.setContentAreaFilled(false);
			endButtonImage2.setContentAreaFilled(false);
			ImageIcon 으헝헝 = new ImageIcon("src/endbuttons1.png");
			ImageIcon 으헝헝2 = new ImageIcon("src/endbuttons2.png");
			
			g2d.drawImage(으헝헝.getImage(), 130, 320, 185, 60,null);
			g2d.drawImage(으헝헝2.getImage(), 320, 320, 185, 60,null);
			endButtonImage.setBorderPainted(false);
			endButtonImage2.setBorderPainted(false);			
		//	g2d.drawString("나가기", 320, 400);
			
			//endButtonImage.setOpaque(false);
		}
	}
	

	public void stopAll(){

		goChar.stop();
		goGround.stop();
		goTime.stop();
		gameMusic.stopPlayer();
		gameMusic2.stopPlayer();
		LobbyMusic.stopPlayer();

	}
	public void startall(){
		goGround.start();
		goChar.start();
		goTime.start();
		if(musicOnOff){
			if(secondRound)
				gameMusic2.startPlay();
			else
				gameMusic.startPlay();
		}
	}


	public void drawHurddle(Graphics2D g2d){

		if(once){ // 스위치로 바꿀것
			ep1_jump1.setX(400+stepHurddle*2);
			ep1_jump2.setX(400+stepHurddle*2);
			ep1_jump3.setX(400+stepHurddle*2);
			ep1_slide1.setX(400+stepHurddle*2);
			ep1_slide2.setX(400+stepHurddle*2);
			casew=(int)(Math.random()*5+1);
			once=false;	
		}	
		switch(casew){

		case 1:// 충돌시 true
			collideTurn=ep1_jump1.drawjump(g2d, CharCenX, CharCenY); 
			hurddleReturnX= ep1_jump1.getX();
			break;
		case 2:
			collideTurn= ep1_jump2.drawjump(g2d, CharCenX, CharCenY);
			hurddleReturnX= ep1_jump2.getX();
			break;
		case 3:
			collideTurn= ep1_jump3.drawjump(g2d, CharCenX, CharCenY);
			hurddleReturnX= ep1_jump3.getX();
			break;

		case 4:
			collideTurn= ep1_slide2.drawsldie(g2d, CharCenX, CharCenY);
			hurddleReturnX= ep1_slide2.getX();
			break;
		case 5:

			collideTurn= ep1_slide1.drawsldie(g2d, CharCenX, CharCenY);
			hurddleReturnX= ep1_slide1.getX();
			break;




		}

	}
	public void drawHurddleEp2(Graphics2D g2d){
		if(third){ // 스위치로 바꿀것
			ep2_jump1.setX(400+stepHurddle*2);
			ep2_jump2.setX(400+stepHurddle*2);
			ep2_jump3.setX(400+stepHurddle*2);
			ep2_slide1.setX(400+stepHurddle*2);
			casew3=(int)(Math.random()*4+1);
			third=false;	
		}	

		switch(casew3){

		case 1:// 충돌시 true
			collideTurn=ep2_jump1.drawjump(g2d, CharCenX, CharCenY); 
			hurddleReturnX3= ep2_jump1.getX();
			break;
		case 2:
			collideTurn= ep2_jump2.drawjump(g2d, CharCenX, CharCenY);
			hurddleReturnX3= ep2_jump2.getX();
			break;
		case 3:
			collideTurn= ep2_jump3.drawjump(g2d, CharCenX, CharCenY);
			hurddleReturnX3= ep2_jump3.getX();
			break;

		case 4:
			collideTurn= ep2_slide1.drawsldie(g2d, CharCenX, CharCenY);
			hurddleReturnX3= ep2_slide1.getX();
			break;
		}
	}


	public void drawRnc(Graphics2D g2d){	
		if(twice){ // 스위치로 바꿀것
			rncupdown.setX(400+stepHurddle);
			casew2=(int)(Math.random()*2+1);
			twice=false;

		}
		if(casew2 == 1){

			rncupdown.drawupdown(g2d, CharCenX, CharCenY);
			hurddleReturnX2=rncupdown.getX(); // 앞으로 갈수있게

		}
		if(casew2==2){
			rncother.drawother(g2d, CharCenX, CharCenY);
			hurddleReturnX2=rncother.getX();
		}

	}

	// 시작 버튼의 감청자
	//****************시작 리스너****************
	class StartListener implements MouseListener {
		public void actionPerformed(ActionEvent e) {

		}

		public void mouseClicked(MouseEvent e) {
			startButtonImage.setIcon(startButton);


		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			startButtonImage.setIcon(startButtonPressed);

		}

		public void mouseReleased(MouseEvent e) {
			lp.setLayer(gamepanel, 3);				// gamePanel 이 앞으로 나오게 함

			LobbyMusic.stopPlayer();
			gameMusic.startPlay();

			gamepanel.setFocusable(true);					// gamePanel이 포커싱될 수 있게 함
			gamepanel.requestFocus();
			frame.repaint();
			goGround.start();
			goChar.start();
			goTime.start();
		}
	}

	//****************멈춤 리스너****************
	
	
	class StopListener implements MouseListener{


		public void mouseClicked(MouseEvent arg0) {

		}
		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
			if(clickedStop=true){
				int whatX = arg0.getX();
				int whatY = arg0.getY();

				if(whatX>=260&&whatX<=420){
					if(whatY>=120&&whatY<175){ // 계속좌표
						startall();
						Esc=false;
					}
					if(whatY>=190&&whatY<235){ // 나가기좌표
						lp.setLayer(endpanel, 5);				// gamePanel 이 앞으로 나오게 함

						endpanel.setFocusable(true);					// gamePanel이 포커싱될 수 있게 함
						endpanel.requestFocus();
						stopAll();
					}
					//	frame.setVisible(false); 
					// 이게아니라 스코어 점수 나타내기
				}

				if(whatY>=250&&whatY<290){
					if(whatX>=280&&whatX<340){ // on좌표
						musicOnOff=true;
						frame.repaint();
					}
					if(whatX>340&&whatX<=400){
						musicOnOff=false;
						frame.repaint();
					}
				}
			}
		}
		public void mouseReleased(MouseEvent arg0) {
		}
	}

	//****************마지막엔드 리스너****************
	class EndListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			frame.setVisible(false);

		}



	}
	class restartListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			frame.setVisible(false);
			MyFrame what = new MyFrame();
			what.go();

		}



	}


	class DirectionListener implements KeyListener {


		public void keyPressed (KeyEvent event) {
			switch (event.getKeyCode()){

			case KeyEvent.VK_DOWN:
				if(CharPy==218){ // 점프중 슬라이드하지못하게
					run=false;
					Cokiecnt=0;
					jump=false;
					Djump = false;
					slide = true;
				}

				break;
			case KeyEvent.VK_UP:
				if(musicOnOff)
					jumpMusic.startPlay();
				break;


			}
		}
		public void keyTyped (KeyEvent event) {

		}
		public void keyReleased (KeyEvent event) {

			switch (event.getKeyCode()){

			case KeyEvent.VK_UP:
				if(jump==false){
					run=false;
					Cokiecnt=0;
					jump=true;
					Djump = false;
					slide = false;
					hall = false;
				}
				break;


			case KeyEvent.VK_SPACE:  // 슬라이드 false,런 true하면 멈춤

				break;
			case KeyEvent.VK_LEFT:
				break;
			case KeyEvent.VK_RIGHT:
				Cokiecnt=0;
				break;
			case KeyEvent.VK_DOWN:

				// slideSound=true; 에러나서 사용불가......
				run=true;
				Cokiecnt=0;
				CharPy=initY;
				jump=false;
				Djump = false;
				slide = false;

				break;
			case KeyEvent.VK_ESCAPE:
				Esc=true;
				break;
			}
		}
	}
}




