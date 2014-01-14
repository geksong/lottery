package org.geksong.lottery.mainmethod;

import javax.swing.JFrame;

/******************************
 * Create Time: 2014-1-14 下午12:52:18<br>
 * Author: zs.zeng<br>
 * File name: LotteryMainFrame.java <br>
 * Version: 1.0<br>
 * Function: <br>
 * Modify Time: 2014-1-14 下午12:52:18<br>
 * Change Log:<br>
 ******************************************/
public class LotteryMainFrame extends JFrame {
	private static final long serialVersionUID = 5459037520040775742L;
	public LotteryMainFrame() {
		super();
		this.setSize(400, 300);
		this.getContentPane().setLayout(null);
		this.add(new LotteryIndexPanel(this), null);
		this.setTitle("抽奖");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
