import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.*;


public class Rnc extends ImageIcon{
	int x=800;
	int y=240; // 240이 중간위치
	boolean cnt1=true, cnt2=false, cnt3=false, cnt4=false;
	int gomSizeX = 31;
	int gomSizeY= 28;
	int stepX =30;
	int stepY = 10;

	int margin = 35 ;
	int initX,initY;


	int CenX =x+gomSizeX/2;
	int CenY =y+gomSizeY/2;

	SoundPlayer rnc = new SoundPlayer("rnc1.wav");

	boolean soundmusicOn =true; //소리끌때

	public Rnc(){

	}
	public Rnc(int x, int y){

		this.initX=x;
		this.initY=y;
		this.x=x;
		this.y=y;
		CenX =x+gomSizeX/2;
		CenY =y+gomSizeY/2;
	}
	ImageIcon Gom = new ImageIcon("src/Rnc/Gom_Rnc2.png");//55,51 

	ImageIcon resetGom = new ImageIcon("src/Rnc/Gom_Rnc2.png");//55,51 

	ImageIcon Coin = new ImageIcon("src/Rnc/Coin.png");//55,51 

	ImageIcon Effect = new ImageIcon("src/Rnc/Gom_rnc4.png");//55,51 

	ImageIcon Effect2 = new ImageIcon("src/Rnc/afterGom.gif");//55,51 

	public int getX() {
		return x;
	}

	public void setX(int x) {

		this.x = x;
		CenX =x+gomSizeX/2;

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		CenY =y+gomSizeY/2;
	}




	//g2d.drawImage(Gom.getImage(), 200, 250, 36, 35,null);//0.7  gomSizeX, gomSizeY


	public boolean collide (int px, int py) {

		Point what = new Point(px,py);
		Point p = new Point(this.CenX, this.CenY);
		if (p.distance(what) <= margin) {
			Gom.setImage(Effect2.getImage());
			if(soundmusicOn)
				rnc.startPlay();
			if(cnt1){
				cnt2=true;
				cnt1=false;

			}


			return true;

		}
		else	
			return false;

		/*
		Point p = new Point(this.x, this.y);
		if (p.distance(p2) <= margin) return true;
		return false;*/
	}


	public void Draw(Graphics2D g2d){
		g2d.drawImage(Gom.getImage(), x, y, gomSizeX, gomSizeY,null);
	}

	/*
	public void drawGom(Graphics2D g2d){
		g2d.drawImage(Gom.getImage(), x, y, gomSizeX, gomSizeY,null);
	}
	public void drawGomHorizon5(Graphics2D g2d){

		g2d.drawImage(Gom.getImage(), x, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+2*stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+3*stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+4*stepX, y, gomSizeX, gomSizeY,null);

	}
	public void drawGomDown(Graphics2D g2d){

		g2d.drawImage(Gom.getImage(), x, y-2*stepY, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+stepX, y-stepY, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+2*stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+3*stepX, y+stepY, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+4*stepX, y+2*stepY, gomSizeX, gomSizeY,null);

	}
	public void drawGomUp(Graphics2D g2d){



		g2d.drawImage(Gom.getImage(), x+stepX, y+2*stepY, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+2*stepX, y+stepY, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+3*stepX, y, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+4*stepX, y-stepY, gomSizeX, gomSizeY,null);
		g2d.drawImage(Gom.getImage(), x+5*stepX, y-2*stepY, gomSizeX, gomSizeY,null);

	}

	 */
	/*
	public boolean collide (Point p2) {
		Point p = new Point(this.x, this.y);
		if (p.distance(p2) <= margin) 
			return true;
		return false;
	}
	 */

	public void go(int Px){
		if(x>-100){
			x-=Px;
			//CenX +=Px; 수정

			CenX -=Px;
		}

	}
	public void move (int Px){

		if(x>-100){
			x-=Px;
			CenX -=Px;
		}
	}

	public void move (int Px,int Py){
		x-=Px;
		y-=Py;
		CenX -=Px;
		CenY -=Py;
	}
	public void reset(){
		Gom.setImage(resetGom.getImage());
		cnt1=true;
		cnt2=false;
	}
	public void rncMusicGo(){
		soundmusicOn=true;
	}
	public void rncMusicStop(){
		soundmusicOn=false;
	}




}
