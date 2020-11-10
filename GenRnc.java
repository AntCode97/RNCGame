import java.util.ArrayList;


public class GenRnc {
	
	public GenRnc(){
	ArrayList<Rnc> rnc = new ArrayList<Rnc>(); //4°³
	Rnc rnc1 = new Rnc();
	rnc1.setX(rnc1.x+rnc1.stepX);
	rnc1.setY(rnc1.y+rnc1.stepY);
	Rnc rnc2 = new Rnc();
	rnc2.setY(rnc2.y+rnc2.stepY*2);
	Rnc rnc3 = new Rnc();
	rnc3.setY(rnc3.y+rnc3.stepY*3);
	
	Rnc rnc4 = new Rnc();
	rnc4.setY(rnc4.y+rnc4.stepY*4);
	rnc.add(rnc4);
	rnc.add(rnc3);
	rnc.add(rnc2);
	rnc.add(rnc1);
	}
	
	
}
