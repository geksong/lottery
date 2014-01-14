package org.geksong.lottery.mainmethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.geksong.lottery.common.LotteryMachine;

/******************************
 * Create Time: 2014-1-14 下午3:31:36<br>
 * Author: zs.zeng<br>
 * File name: LotteryPanel.java <br>
 * Version: 1.0<br>
 * Function: <br>
 * Modify Time: 2014-1-14 下午3:31:36<br>
 * Change Log:<br>
 ******************************************/
public class LotteryPanel extends JPanel {
	private static final long serialVersionUID = 8104218597240057618L;
	private JFrame frame = null;
	private JLabel userLabel = null;
	public LotteryPanel(JFrame frame) {
		super();
		this.setSize(400, 300);
		this.setLayout(null);
		this.frame = frame;
		this.userLabel = initUserNumLabel();
		this.add(initUserLabel(), null);
		this.add(userLabel, null);
		this.add(initLotButton(), null);
	}
	private JLabel initUserLabel() {
		JLabel label = new JLabel();
		label.setText("中奖号码：");
		label.setBounds(20,30,90,30);
		return label;
	}
	private JLabel initUserNumLabel() {
		JLabel label = new JLabel();
		label.setText("000");
		label.setBounds(80,30,60,30);
		return label;
	}
	private JButton initLotButton() {
		JButton button = new JButton();
		button.setText("抽奖");
		button.setBounds(50, 80, 80, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						int j = 100;
						String userNum = "";
						while(j > 0) {
							int i = LotteryMachine.getRandom(LotteryMain.userList.size());
							userNum = LotteryMain.userList.get(i);
							userLabel.setText(userNum);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							j--;
						}
					}
				});
				th.start();
			}
		});
		return button;
	}
}
