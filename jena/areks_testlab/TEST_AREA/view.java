package TEST_AREA;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class view implements Observer{
	
	controler controller;
	JFrame fusekiFrame;
	
	public view(controler controller){
		this.controller = controller;
	}

	@Override
	public void update(Observable model, Object param) {
		// TODO Auto-generated method stub
		
	}
	
	private void createFrame(){
		fusekiFrame = new JFrame();
		fusekiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
