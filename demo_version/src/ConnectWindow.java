import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConnectWindow extends JDialog implements ActionListener{
	private int  flagShow;
	private int width=400;
	private int height=270;
	
	private JButton okButton;
	
	private JRadioButton notConnectRadio;
	private JRadioButton serverModeRadio;
	private JRadioButton clientModeRadio;
	
	private JTextField ipField;
	
	private JLabel ipLabel;
	
	private NetWork netWork;
	
	private String mode="not";
	private String ip="0.0.0.0";
	
	public ConnectWindow() {
		this.setModal(true);
		this.setTitle("Connect Lan");
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(null);
		this.setResizable(false);
		this.pack();
		
		ButtonGroup modeGroup =new ButtonGroup();
		
		okButton=new JButton("OK");
		okButton.addActionListener(this);
		okButton.setActionCommand("ok");
		
		notConnectRadio =new JRadioButton("Not Connect", true);
		notConnectRadio.addActionListener(this);
		
		serverModeRadio =new JRadioButton("SERVER MODE");
		serverModeRadio.addActionListener(this);
		
		clientModeRadio=new JRadioButton("CLIENT MODE");
		clientModeRadio.addActionListener(this);
		
		mode="not";
		
		netWork=new NetWork();
		//netWork.setMode(mode);
		
		
		modeGroup.add(notConnectRadio);modeGroup.add(serverModeRadio);modeGroup.add(clientModeRadio);
		
		ipField =new JTextField();ipField.setEnabled(false);
		
		ipLabel =new JLabel("IP: ");ipLabel.setEnabled(false);
		
		JPanel top =new JPanel();
		top.setSize(350,50);
		top.setLocation(20,20);
		notConnectRadio.setPreferredSize(new Dimension(350,20));
		top.add(notConnectRadio);
		
		JPanel mid =new JPanel();
		mid.setSize(350,50);
		mid.setLocation(20,70);
		serverModeRadio.setPreferredSize(new Dimension(350,20));
		mid.add(serverModeRadio);
		
		JPanel bot =new JPanel();
		bot.setSize(350,50);
		bot.setLocation(20,120);
		clientModeRadio.setPreferredSize(new Dimension(350,20));
		bot.add(clientModeRadio);
		ipField.setPreferredSize(new Dimension(300,20));
		bot.add(ipLabel);
		bot.add(ipField);
		
		JPanel buttonContainPanel =new JPanel();
		buttonContainPanel.setSize(350,50);
		buttonContainPanel.setLocation(20,190);
		buttonContainPanel.add(okButton);
		
		this.add(top);
		this.add(mid);
		this.add(bot);
		this.add(buttonContainPanel);
	}
	
	public void Show(int lx, int ly) {
		this.setLocation(lx,ly);
		if(mode.equals("not")) {
			notConnectRadio.setSelected(true);
			ipField.setEnabled(false);
			ipLabel.setEnabled(false);
		}else if(mode.equals("server")) {
			serverModeRadio.setSelected(true);
			ipField.setEnabled(false);
			ipLabel.setEnabled(false);
		}else if(mode.equals("client")) {
			clientModeRadio.setSelected(true);
			ipLabel.setText(ip);
			ipField.setEnabled(true);
			ipLabel.setEnabled(true);
		}
		this.show(true);
		this.flagShow=1;
	}
	
	public void Hide() {
		this.flagShow=0;
		this.show(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tempMode="";
		String tempIp="0.0.0.0";
		if(notConnectRadio.isSelected()) {
			ipField.setEnabled(false);
			ipLabel.setEnabled(false);
			tempMode="not";
		}else if(serverModeRadio.isSelected()) {
			ipField.setEnabled(false);
			ipLabel.setEnabled(false);
			tempMode="server";
		}else if(clientModeRadio.isSelected()) {
			ipField.setEnabled(true);
			ipLabel.setEnabled(true);
			tempMode="client";
			tempIp=ipField.getText().trim();
		}
		switch (e.getActionCommand()) {
			case "ok":
				netWork.setMode(tempMode, tempIp);
				mode=tempMode;
				ip=tempIp;
				this.Hide();
				break;
		}
	}
}
