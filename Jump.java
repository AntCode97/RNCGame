
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
//int margin = 70 ;  점프는 마진 70이 적당

public class  Jump extends ImageIcon{
	int del=0; 
	int delcnt=7;
	int x=600,y=0,sizeX=45,sizeY=50;
	int Score=0;
	int stepX =38;
	int stepY = 10;
	int margin = 70;
	int initX,initY;
	boolean soundmusicOn=true;
	int CenX =this.x+this.sizeX/2;
	int CenY =this.y+this.sizeY/2;

	ImageIcon Coin = new ImageIcon("src/Rnc/Coin.png");//55,51 

	Rnc rnc= new Rnc();
	Rnc rnc1 = new Rnc();
	Rnc rnc2= new Rnc();
	Rnc rnc3=  new Rnc();
	Rnc rnc4 = new Rnc();
	Rnc rnc5= new Rnc();
	Rnc rnc6=  new Rnc();
	Rnc rnc7= new Rnc();
	Rnc rnc8=  new Rnc();
	Rnc rnc9= new Rnc();
	Rnc rnc10=  new Rnc();
	
	ArrayList<Rnc> rncJump;



	public void resetcnt(){

		for(Rnc s: rncJump){
			s.cnt2=false;
		}
	}


	public Jump(String img, int x, int y, int sizeX, int sizeY){
		super(img);

		this.x=x;
		this.y=y;
		this.initX=x;
		this.initY=y;
		this.sizeX=sizeX;
		this.sizeY=sizeY;

		this.CenX =this.x+this.sizeX/2;
		this.CenY =this.y+this.sizeY/2;	

		rncJump=new ArrayList<Rnc>();
		rncJump.add(rnc);
		rncJump.add(rnc1);
		rncJump.add(rnc2);
		rncJump.add(rnc3);
		rncJump.add(rnc4);
		rncJump.add(rnc5);
		rncJump.add(rnc6);
		rncJump.add(rnc7);
		rncJump.add(rnc8);
		rncJump.add(rnc9);
		Rncreset();


	}



	public boolean drawjump(Graphics2D g2d, int CollidX, int CollidY){ 

		g2d.drawImage(this.getImage(),x, y, sizeX,sizeY, null);
		for(Rnc s: rncJump){
			if(s.collide(CollidX, CollidY))
				if(s.cnt2){ 
					Score+=100;
					s.cnt2=false;

				}
			s.Draw(g2d);

		}
		return this.collide(CollidX, CollidY); 
	}


	public void reset() {
		x = initX; y= initY;

		Rncreset();	
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;

		CenX =x+sizeX/2;

		Rncreset();
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;

		CenY =y+sizeY/2;
	}

	public void go(int x){
		this.x-=x;
		this.CenX =this.x+sizeX/2;
		this.CenY =y+sizeY/2;	

		for(Rnc s: rncJump){
			s.go(x);


		}

	}

	public int getScore(){
		return Score;
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
	public void Rncreset(){

		for(Rnc s: rncJump){
			s.reset();
		}
		rncJump.get(0).setX(x-3*stepX);
		rncJump.get(1).setX(x-2*stepX);
		rncJump.get(1).setY(y-26);
		rncJump.get(2).setX(x-stepX);
		rncJump.get(2).setY(y-52);
		rncJump.get(3).setX(x);
		rncJump.get(3).setY(y-78);
		rncJump.get(4).setX(x+stepX);
		rncJump.get(4).setY(y-52);
		rncJump.get(5).setX(x+2*stepX);
		rncJump.get(5).setY(y-26);
		rncJump.get(6).setX(x+3*stepX);
		rncJump.get(6).setY(y);
		rncJump.get(7).setX(x+4*stepX);
		rncJump.get(8).setX(x+5*stepX);
		rncJump.get(9).setX(x+6*stepX);

	}

	public void setMusicGo(){

		for(Rnc s: rncJump)
			s.soundmusicOn=true;

	}
	public void setMusicStop(){

		for(Rnc s: rncJump)
			s.soundmusicOn=false;
	}

}

