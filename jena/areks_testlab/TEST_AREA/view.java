package TEST_AREA;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/** View-Plugin for the Fuseki GUI **/
public class view implements Observer{
	
	controler controller;
	JFrame fusekiFrame;
	JButton connectButton;
	JButton disconnectButton;
	JTextArea logTextarea;
	GridBagConstraints constrains;
	private int jButtonlength = 50;
	
	public view(controler controller){
		this.controller = controller;
		this.constrains = new GridBagConstraints();
		
		createFrame();
	}

	public void showView(){
		fusekiFrame.pack();
		fusekiFrame.setVisible(true);
	}

	@Override
	public void update(Observable model, Object param) {
		// TODO Auto-generated method stub
		
	}
	
	private void createFrame(){
		fusekiFrame = new JFrame();
		fusekiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fusekiFrame.setSize((2*jButtonlength) + 500, 1000);
		
		//constrains demo Button 1
		GridBagLayout layout = new GridBagLayout();
		double[] d = new double[] {0, 0, 2, 2, 2};
		layout.columnWeights = d;
		int[] w = new int[] {jButtonlength, jButtonlength, 100, 100, 100};
		layout.columnWidths = w;
		fusekiFrame.setLayout(layout);
		
		createConnectButton();
		createDisconnectButton();
		createLogTextarea();
	}
	
	private void createConnectButton(){
		//constrains.fill = GridBagConstraints.HORIZONTAL;
		constrains.ipadx = jButtonlength - controller.getLang().getCurrLang().CONNECTFUSEKIBUTTONCONNECT.length();
		constrains.anchor = GridBagConstraints.NORTHWEST;
		constrains.weightx = 1;
		constrains.gridx = 0;
		constrains.gridy = 0;

		connectButton = new JButton(controller.getLang().getCurrLang().CONNECTFUSEKIBUTTONCONNECT);
		fusekiFrame.add(connectButton, constrains);
	}
	
	private void createDisconnectButton(){
		//constrains.fill = GridBagConstraints.HORIZONTAL;
		constrains.ipadx = jButtonlength - controller.getLang().getCurrLang().CONNECTFUSEKIBUTTONDISCONNECT.length();
		constrains.anchor = GridBagConstraints.NORTHWEST;
		constrains.weightx = 1;
		constrains.gridx = 1;
		constrains.gridy = 0;

		disconnectButton = new JButton(controller.getLang().getCurrLang().CONNECTFUSEKIBUTTONDISCONNECT);
		disconnectButton.setEnabled(false);
		fusekiFrame.add(disconnectButton, constrains);
	}
	
	private void createLogTextarea(){
		constrains.fill = GridBagConstraints.BOTH;
		constrains.anchor = GridBagConstraints.CENTER;
		constrains.gridwidth = 5;
		
		constrains.weightx = 1;	
		constrains.gridx = 0;
		constrains.gridy = 1;
		
		logTextarea = new JTextArea("empty");
		logTextarea.setMinimumSize(new Dimension(500, 500));
		logTextarea.setEditable(false);
		logTextarea.setBackground(fusekiFrame.getBackground());
		logTextarea.setBorder(BorderFactory.createLineBorder(Color.black));
		fusekiFrame.add(logTextarea, constrains);
		
	}

}
