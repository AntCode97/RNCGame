
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

// ImageIcon�� ��ǥ�� ��ġ�� �ο��ϰ��� ImageIcon Ŭ������ �����
public class PosImageIcon extends ImageIcon {
	int pX;            // ImageIcon�� X��ǥ
	int pY;            // ImageIcon�� y��ǥ
	int width;         // ImageIcon�� ����
	int height;         // ImageIcon�� ����
	int xDerection;
	int margin=100;

	public PosImageIcon(String img, int x, int y, int width, int height) {
		super(img);
		pX=x;
		pY=y;
		this.width = width;
		this.height = height;
	}

	public PosImageIcon(String img, int x, int y, int width, int height, int xDerection) {
		super(img);
		pX=x;
		pY=y;
		this.width = width;
		this.height = height;
		this.xDerection = xDerection;
	}


	public int getpX() {
		return pX;
	}


	public void setpX(int pX) {
		this.pX = pX;
	}


	public int getpY() {
		return pY;
	}


	public void setpY(int pY) {
		this.pY = pY;
	}


	public void move(int x, int y) {      
		pX += x;
		pY += y;      
	}



	public void draw(Graphics2D g2d, int pX) {
		g2d.drawImage(this.getImage(), pX, pY, width, height, null);


	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(this.getImage(), pX, pY, width, height, null);



	}

	public void draw3(Graphics2D g2d) {
		if(this.pX==-xDerection)
			this.pX=xDerection;
		g2d.drawImage(this.getImage(), pX+xDerection, pY, width, height, null);


	}

	public boolean collide (Point p2) {
		Point p = new Point(this.pX, this.pY);
		if (p.distance(p2) <= margin) return true;
		return false;
	}

}