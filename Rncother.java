import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Rncother extends Rnc{
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

	ArrayList<Rnc> rncother = new ArrayList<Rnc>();

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
	public Rncother(){
		rncother.add(rnc0);
		rncother.add(rnc1);
		rncother.add(rnc2);
		rncother.add(rnc3);
		rncother.add(rnc4);
		rncother.add(rnc5);
		rncother.add(rnc6);
		rncother.add(rnc7);
		rncother.add(rnc8);
		rncother.add(rnc9);
		rncother.add(rnc10);
		
		rncother.add(rnc11);
		rncother.add(rnc12);
		rncother.add(rnc13);
		rncother.add(rnc14);
		rncother.add(rnc15);
		rncother.add(rnc16);
		rncother.add(rnc17);
		rncother.add(rnc18);
		rncother.add(rnc19);
		rncother.add(rnc20);
		rncother.add(rnc21);
		
		rncother.add(rnc22);
		rncother.add(rnc23);
		rncother.add(rnc24);
		rncother.add(rnc25);
		rncother.add(rnc26);
		rncother.add(rnc27);
		rncother.add(rnc28);
		rncother.add(rnc29);
		rncother.add(rnc30);
		rncother.add(rnc31);
		rncother.add(rnc32);
		
		rncother.add(rnc33);
		rncother.add(rnc34);
		rncother.add(rnc35);
		rncother.add(rnc36);
		rncother.add(rnc37);
		rncother.add(rnc38);
		rncother.add(rnc39);
		rncother.add(rnc40);
		rncother.add(rnc41);
		rncother.add(rnc42);
		rncother.add(rnc43);


		/*rncother.add(rnc22);
		rncother.add(rnc23);
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

	public void drawother(Graphics2D g2d, int CollidX, int CollidY){ // Three

		//점프시 젤리 배치도

		for(Rnc s: rncother){
			if(s.collide(CollidX, CollidY))
				if(s.cnt2){ // 타이머가 돌아갈때 젤리를 먹으면 점수가 한번만 올라가게
					Score+=100;
					s.cnt2=false;

				}
			s.Draw(g2d);

		}
		this.collide(CollidX, CollidY);
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	public void go(int x){

		this.x-=x;
		CenX -=x;
		for(Rnc s: rncother){
			s.go(x);

	}


	}

	public void Rncreset(){

		for(Rnc s: rncother){
			s.reset();
		} // 22개
		rncother.get(0).setX(x-5*stepX);
		rncother.get(1).setX(x-4*stepX);
		rncother.get(2).setX(x-3*stepX);
		rncother.get(3).setX(x-2*stepX);
		rncother.get(4).setX(x-stepX);
		rncother.get(5).setX(x);
		rncother.get(6).setX(x+stepX);
		rncother.get(7).setX(x+2*stepX);
		rncother.get(8).setX(x+3*stepX);
		rncother.get(9).setX(x+4*stepX);
		rncother.get(10).setX(x+5*stepX);
		
		rncother.get(11).setX(x-5*stepX);
		rncother.get(12).setX(x-4*stepX);
		rncother.get(13).setX(x-3*stepX);
		rncother.get(14).setX(x-2*stepX);
		rncother.get(15).setX(x-1*stepX);
		rncother.get(16).setX(x);
		rncother.get(17).setX(x+1*stepX);
		rncother.get(18).setX(x+2*stepX);
		rncother.get(19).setX(x+3*stepX);
		rncother.get(20).setX(x+4*stepX);
		rncother.get(21).setX(x+5*stepX);

		rncother.get(22).setX(x-5*stepX);
		rncother.get(23).setX(x-4*stepX);
		rncother.get(24).setX(x-3*stepX);
		rncother.get(25).setX(x-2*stepX);
		rncother.get(26).setX(x-1*stepX);
		rncother.get(27).setX(x);
		rncother.get(28).setX(x+1*stepX);
		rncother.get(29).setX(x+2*stepX);
		rncother.get(30).setX(x+3*stepX);
		rncother.get(31).setX(x+4*stepX);
		rncother.get(32).setX(x+5*stepX);

		rncother.get(33).setX(x-5*stepX);
		rncother.get(34).setX(x-4*stepX);
		rncother.get(35).setX(x-3*stepX);
		rncother.get(36).setX(x-2*stepX);
		rncother.get(37).setX(x-1*stepX);
		rncother.get(38).setX(x);
		rncother.get(39).setX(x+1*stepX);
		rncother.get(40).setX(x+2*stepX);
		rncother.get(41).setX(x+3*stepX);
		rncother.get(42).setX(x+4*stepX);
		rncother.get(43).setX(x+5*stepX);
		
		
		
		rncother.get(0).setY(y);
		rncother.get(1).setY(y);
		rncother.get(2).setY(y);
		rncother.get(3).setY(y);
		rncother.get(4).setY(y);
		rncother.get(5).setY(y);
		rncother.get(6).setY(y);
		rncother.get(7).setY(y);
		rncother.get(8).setY(y);
		rncother.get(9).setY(y);
		rncother.get(10).setY(y);
		
		rncother.get(11).setY(y-3*stepY);
		rncother.get(12).setY(y-3*stepY);
		rncother.get(13).setY(y-3*stepY);
		rncother.get(14).setY(y-3*stepY);
		rncother.get(15).setY(y-3*stepY);
		rncother.get(16).setY(y-3*stepY);
		rncother.get(17).setY(y-3*stepY);
		rncother.get(18).setY(y-3*stepY);
		rncother.get(19).setY(y-3*stepY);
		rncother.get(20).setY(y-3*stepY);
		rncother.get(21).setY(y-3*stepY);
		

		rncother.get(22).setY(y-6*stepY);
		rncother.get(23).setY(y-6*stepY);
		rncother.get(24).setY(y-6*stepY);
		rncother.get(25).setY(y-6*stepY);
		rncother.get(26).setY(y-6*stepY);
		rncother.get(27).setY(y-6*stepY);
		rncother.get(28).setY(y-6*stepY);
		rncother.get(29).setY(y-6*stepY);
		rncother.get(30).setY(y-6*stepY);
		rncother.get(31).setY(y-6*stepY);
		rncother.get(32).setY(y-6*stepY);

		rncother.get(33).setY(y-9*stepY);
		rncother.get(34).setY(y-9*stepY);
		rncother.get(35).setY(y-9*stepY);
		rncother.get(36).setY(y-9*stepY);
		rncother.get(37).setY(y-9*stepY);
		rncother.get(38).setY(y-9*stepY);
		rncother.get(39).setY(y-9*stepY);
		rncother.get(40).setY(y-9*stepY);
		rncother.get(41).setY(y-9*stepY);
		rncother.get(42).setY(y-9*stepY);
		rncother.get(43).setY(y-9*stepY);
	}

	public void setMusicGo(){

		for(Rnc s: rncother)
			s.soundmusicOn=true;

	}
	public void setMusicStop(){

		for(Rnc s: rncother)
			s.soundmusicOn=false;
	}
	
}





