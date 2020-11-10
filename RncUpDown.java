import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class RncUpDown extends Rnc{
	int x=800;
	int y=240; // 240이 중간위치
	boolean cnt1=true, cnt2=false;
	int gomSizeX = 31;
	int gomSizeY= 28;
	int stepX =30;
	int stepY = 10;
	int Score=0;
	int margin = 35 ;
	int initX,initY;

	boolean soundmusicOn=true;

	int CenX =x+gomSizeX/2;
	int CenY =y+gomSizeY/2;

	Rnc rnc0 = new Rnc();
	Rnc rnc1 = new Rnc();
	Rnc rnc2 = new Rnc();
	Rnc rnc3 = new Rnc();
	Rnc rnc4 = new Rnc();
	Rnc rnc5 = new Rnc();
	Rnc rnc6 = new Rnc();
	Rnc rnc7 = new Rnc();
	Rnc rnc8 = new Rnc();
	Rnc rnc9 = new Rnc();
	Rnc rnc10 = new Rnc();
	
	Rnc rnc11 = new Rnc();
	Rnc rnc12 = new Rnc();
	Rnc rnc13 = new Rnc();
	Rnc rnc14 = new Rnc();
	Rnc rnc15 = new Rnc();
	Rnc rnc16 = new Rnc();
	Rnc rnc17 = new Rnc();
	Rnc rnc18 = new Rnc();
	Rnc rnc19 = new Rnc();
	Rnc rnc20 = new Rnc();
	Rnc rnc21 = new Rnc();
	
	Rnc rnc22 = new Rnc();
	Rnc rnc23 = new Rnc();
	Rnc rnc24 = new Rnc();
	Rnc rnc25 = new Rnc();
	Rnc rnc26 = new Rnc();
	Rnc rnc27 = new Rnc();
	Rnc rnc28 = new Rnc();
	Rnc rnc29 = new Rnc();
	Rnc rnc30 = new Rnc();
	Rnc rnc31 = new Rnc();
	Rnc rnc32 = new Rnc();
	
	Rnc rnc33 = new Rnc();
	Rnc rnc34 = new Rnc();
	Rnc rnc35 = new Rnc();
	Rnc rnc36 = new Rnc();
	Rnc rnc37 = new Rnc();
	Rnc rnc38 = new Rnc();
	Rnc rnc39 = new Rnc();
	Rnc rnc40 = new Rnc();
	Rnc rnc41 = new Rnc();
	Rnc rnc42 = new Rnc();
	Rnc rnc43 = new Rnc();
	public RncUpDown(){
		rncupDown.add(rnc0);
		rncupDown.add(rnc1);
		rncupDown.add(rnc2);
		rncupDown.add(rnc3);
		rncupDown.add(rnc4);
		rncupDown.add(rnc5);
		rncupDown.add(rnc6);
		rncupDown.add(rnc7);
		rncupDown.add(rnc8);
		rncupDown.add(rnc9);
		rncupDown.add(rnc10);
		
		rncupDown.add(rnc11);
		rncupDown.add(rnc12);
		rncupDown.add(rnc13);
		rncupDown.add(rnc14);
		rncupDown.add(rnc15);
		rncupDown.add(rnc16);
		rncupDown.add(rnc17);
		rncupDown.add(rnc18);
		rncupDown.add(rnc19);
		rncupDown.add(rnc20);
		rncupDown.add(rnc21);
		
		rncupDown.add(rnc22);
		rncupDown.add(rnc23);
		rncupDown.add(rnc24);
		rncupDown.add(rnc25);
		rncupDown.add(rnc26);
		rncupDown.add(rnc27);
		rncupDown.add(rnc28);
		rncupDown.add(rnc29);
		rncupDown.add(rnc30);
		rncupDown.add(rnc31);
		rncupDown.add(rnc32);
		
		rncupDown.add(rnc33);
		rncupDown.add(rnc34);
		rncupDown.add(rnc35);
		rncupDown.add(rnc36);
		rncupDown.add(rnc37);
		rncupDown.add(rnc38);
		rncupDown.add(rnc39);
		rncupDown.add(rnc40);
		rncupDown.add(rnc41);
		rncupDown.add(rnc42);
		rncupDown.add(rnc43);


		/*rncupDown.add(rnc22);
		rncupDown.add(rnc23);
		 */
		Rncreset();
	}


	ImageIcon Gom = new ImageIcon("src/Rnc/Gom_Rnc2.png");//55,51 

	ImageIcon resetGom = new ImageIcon("src/Rnc/Gom_Rnc2.png");//55,51 

	ImageIcon Effect = new ImageIcon("src/Rnc/Gom_rnc4.png");//55,51 

	public int getX() {
		return x;
	}

	public void setX(int x) {

		this.x = x;
		CenX =x+gomSizeX/2;

		Rncreset();

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		CenY =y+gomSizeY/2;
		
	}

	public void drawupdown(Graphics2D g2d, int CollidX, int CollidY){ // Three

		//점프시 젤리 배치도

		for(Rnc s: rncupDown){
			if(s.collide(CollidX, CollidY))
				if(s.cnt2){ // 타이머가 돌아갈때 젤리를 먹으면 점수가 한번만 올라가게
					Score+=100;
					s.cnt2=false;

				}
			s.Draw(g2d);

		}
		this.collide(CollidX, CollidY);
	}

	public void drawGomHorizon5(Graphics2D g2d){

		g2d.drawImage(Gom.getImage(), x, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+2*stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+3*stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+4*stepX, y, gomSizeX, gomSizeY,null);

	}
	/*
	for(Rnc s: rncupDown){
		if(s.collide(CollidX, CollidY))
			if(s.cnt2){ // 타이머가 돌아갈때 젤리를 먹으면 점수가 한번만 올라가게
				Score+=100;
				s.cnt2=false;

			}
		s.Draw(g2d);

	}*/
	ArrayList<Rnc> rncupDown = new ArrayList<Rnc>();



	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	public void go(int x){

		this.x-=x;
		CenX -=x;
		for(Rnc s: rncupDown){
			s.go(x);

	}


	}

	public void Rncreset(){

		for(Rnc s: rncupDown){
			s.reset();
		} // 22개
		rncupDown.get(0).setX(x-5*stepX);
		rncupDown.get(1).setX(x-4*stepX);
		rncupDown.get(2).setX(x-3*stepX);
		rncupDown.get(3).setX(x-2*stepX);
		rncupDown.get(4).setX(x-stepX);
		rncupDown.get(5).setX(x);
		rncupDown.get(6).setX(x+stepX);
		rncupDown.get(7).setX(x+2*stepX);
		rncupDown.get(8).setX(x+3*stepX);
		rncupDown.get(9).setX(x+4*stepX);
		rncupDown.get(10).setX(x+5*stepX);
		
		rncupDown.get(11).setX(x-5*stepX);
		rncupDown.get(12).setX(x-4*stepX);
		rncupDown.get(13).setX(x-3*stepX);
		rncupDown.get(14).setX(x-2*stepX);
		rncupDown.get(15).setX(x-1*stepX);
		rncupDown.get(16).setX(x);
		rncupDown.get(17).setX(x+1*stepX);
		rncupDown.get(18).setX(x+2*stepX);
		rncupDown.get(19).setX(x+3*stepX);
		rncupDown.get(20).setX(x+4*stepX);
		rncupDown.get(21).setX(x+5*stepX);

		rncupDown.get(22).setX(x-5*stepX);
		rncupDown.get(23).setX(x-4*stepX);
		rncupDown.get(24).setX(x-3*stepX);
		rncupDown.get(25).setX(x-2*stepX);
		rncupDown.get(26).setX(x-1*stepX);
		rncupDown.get(27).setX(x);
		rncupDown.get(28).setX(x+1*stepX);
		rncupDown.get(29).setX(x+2*stepX);
		rncupDown.get(30).setX(x+3*stepX);
		rncupDown.get(31).setX(x+4*stepX);
		rncupDown.get(32).setX(x+5*stepX);

		rncupDown.get(33).setX(x-5*stepX);
		rncupDown.get(34).setX(x-4*stepX);
		rncupDown.get(35).setX(x-3*stepX);
		rncupDown.get(36).setX(x-2*stepX);
		rncupDown.get(37).setX(x-1*stepX);
		rncupDown.get(38).setX(x);
		rncupDown.get(39).setX(x+1*stepX);
		rncupDown.get(40).setX(x+2*stepX);
		rncupDown.get(41).setX(x+3*stepX);
		rncupDown.get(42).setX(x+4*stepX);
		rncupDown.get(43).setX(x+5*stepX);
		
		
		
		rncupDown.get(0).setY(y);
		rncupDown.get(1).setY(y);
		rncupDown.get(2).setY(y);
		rncupDown.get(3).setY(y);
		rncupDown.get(4).setY(y);
		rncupDown.get(5).setY(y);
		rncupDown.get(6).setY(y);
		rncupDown.get(7).setY(y);
		rncupDown.get(8).setY(y);
		rncupDown.get(9).setY(y);
		rncupDown.get(10).setY(y);
		
		rncupDown.get(11).setY(y-2*stepY);
		rncupDown.get(12).setY(y-2*stepY);
		rncupDown.get(13).setY(y-2*stepY);
		rncupDown.get(14).setY(y-2*stepY);
		rncupDown.get(15).setY(y-2*stepY);
		rncupDown.get(16).setY(y-2*stepY);
		rncupDown.get(17).setY(y-2*stepY);
		rncupDown.get(18).setY(y-2*stepY);
		rncupDown.get(19).setY(y-2*stepY);
		rncupDown.get(20).setY(y-2*stepY);
		rncupDown.get(21).setY(y-2*stepY);
		

		rncupDown.get(22).setY(y-4*stepY);
		rncupDown.get(23).setY(y-4*stepY);
		rncupDown.get(24).setY(y-4*stepY);
		rncupDown.get(25).setY(y-4*stepY);
		rncupDown.get(26).setY(y-4*stepY);
		rncupDown.get(27).setY(y-4*stepY);
		rncupDown.get(28).setY(y-4*stepY);
		rncupDown.get(29).setY(y-4*stepY);
		rncupDown.get(30).setY(y-4*stepY);
		rncupDown.get(31).setY(y-4*stepY);
		rncupDown.get(32).setY(y-4*stepY);

		rncupDown.get(33).setY(y-6*stepY);
		rncupDown.get(34).setY(y-6*stepY);
		rncupDown.get(35).setY(y-6*stepY);
		rncupDown.get(36).setY(y-6*stepY);
		rncupDown.get(37).setY(y-6*stepY);
		rncupDown.get(38).setY(y-6*stepY);
		rncupDown.get(39).setY(y-6*stepY);
		rncupDown.get(40).setY(y-6*stepY);
		rncupDown.get(41).setY(y-6*stepY);
		rncupDown.get(42).setY(y-6*stepY);
		rncupDown.get(43).setY(y-6*stepY);

	}

	public void setMusicGo(){

		for(Rnc s: rncupDown)
			s.soundmusicOn=true;

	}
	public void setMusicStop(){

		for(Rnc s: rncupDown)
			s.soundmusicOn=false;
	}

}





