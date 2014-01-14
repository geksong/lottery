package org.geksong.lottery.mainmethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/******************************
 * Create Time: 2014-1-14 下午1:35:10<br>
 * Author: zs.zeng<br>
 * File name: LotteryIndexPanel.java <br>
 * Version: 1.0<br>
 * Function: <br>
 * Modify Time: 2014-1-14 下午1:35:10<br>
 * Change Log:<br>
 ******************************************/
public class LotteryIndexPanel extends JPanel {
	private static final long serialVersionUID = -8922770451396920980L;
	private JFrame frame = null;
	public LotteryIndexPanel(JFrame frame) {
		super();
		this.frame = frame;
		this.setSize(400, 300);
		this.setLayout(null);
		this.add(initImportUserButton(), null);
		this.add(initLotterySettingButton(), null);
		this.add(initStartLotteryButton(), null);
	}
	private JButton initImportUserButton() {
		JButton importUserButton = new JButton();
		importUserButton.setBounds(30, 30, 100, 30);
		importUserButton.setText("导入用户信息");
		importUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new ImportUserPanel(frame));
			}
		});
		return importUserButton;
	}
	private JButton initLotterySettingButton() {
		JButton lotSettingButton = new JButton();
		lotSettingButton.setBounds(140, 30, 100, 30);
		lotSettingButton.setText("奖项设置");
		return lotSettingButton;
	}
	private JButton initStartLotteryButton() {
		JButton startLotteryButton = new JButton();
		startLotteryButton.setBounds(200, 90, 100, 60);
		startLotteryButton.setText("开始抽奖");
		startLotteryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new LotteryPanel(frame));
			}
		});
		return startLotteryButton;
	}
}
