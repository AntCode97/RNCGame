
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class  Slide extends ImageIcon{


	int x=600,y=0,sizeX=30,sizeY=500;
	int RncX=500, RncY=260;

	int stepX =30;
	int stepY = 10;
	int margin = 40
			;
	int CenX =this.x+this.sizeX/2;
	int CenY =sizeY-20;
	boolean cnt;

	boolean soundmusicOn=true;
	ImageIcon Coin = new ImageIcon("src/Rnc/Coin.png");//55,51 


	int Score=0;

	int ScoreCntStop=0;
	// 타이머가 돌아갈때 젤리를 먹으면 점수가 한번만 올라가게

	// 240이 중간위치

	Rnc rnc= new Rnc(RncX,RncY);
	Rnc rnc1 =new Rnc(RncX,RncY);
	Rnc rnc2= new Rnc(RncX,RncY);
	Rnc rnc3= new Rnc(RncX,RncY);
	Rnc rnc4 = new Rnc(RncX,RncY);
	Rnc rnc5= new Rnc(RncX,RncY);
	Rnc rnc6= new Rnc(RncX,RncY);
	Rnc rnc7 = new Rnc(RncX,RncY);
	Rnc rnc8= new Rnc(RncX,RncY);
	Rnc rnc9= new Rnc(RncX,RncY);
	Rnc rnc10= new Rnc(RncX,RncY);


	ArrayList<Rnc> rncSlide;



	public Slide(String img, int x, int y, int sizeX, int sizeY){
		super(img);
		this.x=x;
		this.y=y;
		this.sizeX=sizeX;
		this.sizeY=sizeY;

		this.CenX =this.x+this.sizeX/2;
		CenY =this.sizeY-20;
		rncSlide=new ArrayList<Rnc>();



		rncSlide.add(rnc);
		rncSlide.add(rnc1);
		rncSlide.add(rnc2);
		rncSlide.add(rnc3);
		rncSlide.add(rnc4);
		rncSlide.add(rnc5);
		rncSlide.add(rnc6);
		rncSlide.add(rnc7);
		rncSlide.add(rnc8);
		rncSlide.add(rnc9);
		rncSlide.add(rnc10);


	}
	
	public boolean drawsldie(Graphics2D g2d, int CollidX, int CollidY){ // Three



		g2d.drawImage(this.getImage(),x, y, sizeX,sizeY, null);
	
		for(Rnc s: rncSlide){
			if(s.collide(CollidX, CollidY))
				if(s.cnt2){ 
					Score+=100;
					s.cnt2=false;


				}
			s.Draw(g2d);
		}

		return this.collide(CollidX, CollidY);
	}
	public int getScore(){
		return Score;
	}



	// 앞의 장애물과의 거리조절
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		CenX =this.x+sizeX/2;
		rncReset();
		for(Rnc s: rncSlide)
			s.reset();
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;

		CenY =sizeY-20;

	}
	public void go(int x){
		
			this.x-=x;

			CenX =this.x+sizeX/2;
			CenY =sizeY-20;
		
		for(Rnc s: rncSlide){
			s.go(x);
		}

	}
	public void reset(){

		x=600;y=0;sizeX=30;sizeY=500;
		RncX=500; RncY=260;
		Score=0;
		rncReset();
		for(Rnc s: rncSlide){
			s.reset();
		}

	}

	public boolean collide (int px, int py) {
		Point what = new Point(px,py);
		Point p = new Point(this.CenX, this.CenY);
		if (p.distance(what) <= margin) {

			return true;

		}
		else	
			return false;
	}
	public void rncReset(){

		rncSlide.get(0).setX(x-5*stepX);
		rncSlide.get(1).setX(x-4*stepX);
		rncSlide.get(2).setX(x-3*stepX);
		rncSlide.get(3).setX(x-2*stepX);
		rncSlide.get(4).setX(x-stepX);
		rncSlide.get(5).setX(x);
		rncSlide.get(6).setX(x+stepX);
		rncSlide.get(7).setX(x+2*stepX);
		rncSlide.get(8).setX(x+3*stepX);
		rncSlide.get(9).setX(x+4*stepX);
		rncSlide.get(10).setX(x+5*stepX);
	}

	public void setMusicGo(){

		for(Rnc s: rncSlide)
			s.soundmusicOn=true;

	}
	public void setMusicStop(){

		for(Rnc s: rncSlide)
			s.soundmusicOn=false;
	}

}

