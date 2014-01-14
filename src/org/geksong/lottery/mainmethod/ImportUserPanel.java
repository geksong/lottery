package org.geksong.lottery.mainmethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/******************************
 * Create Time: 2014-1-14 下午2:00:08<br>
 * Author: zs.zeng<br>
 * File name: ImportUserPanel.java <br>
 * Version: 1.0<br>
 * Function: <br>
 * Modify Time: 2014-1-14 下午2:00:08<br>
 * Change Log:<br>
 ******************************************/
public class ImportUserPanel extends JPanel {
	private static final long serialVersionUID = -2284044223438675845L;
	private JFrame frame = null;
	private JTextField userFilePathText = null;
	public ImportUserPanel(JFrame frame) {
		super();
		this.frame = frame;
		this.setSize(400, 300);
		this.userFilePathText = userFilePathTextField();
		this.add(userFilePathText, null);
		this.add(importSureButton(), null);
		this.add(showChoseFileDialogButton(), null);
		this.setLayout(null);
	}
	public JTextField userFilePathTextField() {
		JTextField ufpt = new JTextField();
		ufpt.setBounds(10, 30, 250, 30);
		return ufpt;
	}
	public JButton importSureButton() {
		JButton isb = new JButton();
		isb.setText("导入");
		isb.setBounds(270, 30, 60, 30);
		isb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userFilePath = userFilePathText.getText();
				if(null == userFilePath || "".equals(userFilePath)) {
					JOptionPane.showMessageDialog(frame, "不存在的用户文件", "错误", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						LotteryMain.loadUser(userFilePath);
						LotteryMain.reInitUserList(LotteryMain.userMap);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "不存在的用户文件", "错误", JOptionPane.ERROR_MESSAGE);
					}
					frame.setContentPane(new LotteryIndexPanel(frame));
				}
			}
		});
		return isb;
	}
	public JButton showChoseFileDialogButton() {
		JButton scfdb = new JButton();
		scfdb.setText("选择数据源文件");
		scfdb.setBounds(100, 80, 100, 30);
		scfdb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(frame);
				if(jfc.getSelectedFile() != null) {
					userFilePathText.setText(jfc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		return scfdb;
	}
}
