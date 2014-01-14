package org.geksong.lottery.mainmethod;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.geksong.lottery.common.LotteryMachine;

/******************************
 * Create Time: 2014-1-14 上午9:49:12<br>
 * Author: zs.zeng<br>
 * File name: LotteryMain.java <br>
 * Version: 1.0<br>
 * Function: <br>
 * Modify Time: 2014-1-14 上午9:49:12<br>
 * Change Log:<br>
 ******************************************/
public class LotteryMain {
	public static LinkedList<String> userList = new LinkedList<String>();
	public static Map<String, String> userMap = new HashMap<String, String>();
	public static Map<String, String> lotteryLogMap = new HashMap<String, String>();
	public static Map<String, Integer> lotteryPlain = new HashMap<String, Integer>();
	public static void loadLotteryLog() throws IOException {
		File lotteryLogFile = new File("C:/.lottery.txt");
		if(!lotteryLogFile.exists())
			return ;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bf = null;
		fis = new FileInputStream(lotteryLogFile);
		isr = new InputStreamReader(fis, "GBK");
		bf = new BufferedReader(isr);
		String res = null;
		while((res = bf.readLine()) != null) {
			String[] ress = res.split("\\s");
			lotteryLogMap.put(ress[0], ress[1]);
		}
		fis.close();
		isr.close();
		bf.close();
	}
	public static void writeLotteryLog() throws IOException {
		File lotteryLogFile = new File("C:/.lottery.txt");
		if(!lotteryLogFile.exists())
			lotteryLogFile.createNewFile();
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		fos = new FileOutputStream(lotteryLogFile);
		osw = new OutputStreamWriter(fos, "GBK");
		bw = new BufferedWriter(osw);
		String res = "";
		for(Entry<String, String> e : lotteryLogMap.entrySet()) {
			res += e.getKey() + "\t" + e.getValue() + "\n";
		}
		bw.write(res);
		bw.flush();
		fos.close();
		osw.close();
		bw.close();
	}
	public static void loadUser(String filePath) throws IOException {
		File userFile = new File(filePath);
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bf = null;
		fis = new FileInputStream(userFile);
		isr = new InputStreamReader(fis, "GBK");
		bf = new BufferedReader(isr);
		String res = null;
		while((res = bf.readLine()) != null) {
			String[] ress = res.split("\\s");
			if(!userMap.containsKey(ress[0])) {
				userMap.put(ress[0], ress[1]);
			}
		}
		fis.close();
		isr.close();
		bf.close();
	}
	public static void reInitUserList(Map<String, String> userMap) {
		for(Entry<String, String> e : userMap.entrySet()) {
			if(!userList.contains(e.getKey()) && !lotteryLogMap.containsKey(e.getKey())) {
				userList.add(e.getKey());
			}
		}
	}
	public static void main(String[] args) {
		try {
			loadLotteryLog();
			loadUser("F:/usermap.txt");
		} catch (IOException e) {
			System.out.println("不存在的用户列表文件");
		}
		for(Entry<String, String> e : userMap.entrySet()) {
			System.out.println(e.getKey() + "=>" + e.getValue());
		}
		reInitUserList(userMap);
		for(int i = 0; i < userList.size(); i++) {
			System.out.println(i + "==" + userList.get(i));
		}
		int id = LotteryMachine.getRandom(userList.size());
		String lotUser = userList.get(id);
		String userName = userMap.get(lotUser);
		System.out.println("中奖用户:" + lotUser + "  " + userName);
		lotteryLogMap.put(lotUser, userName);
		try {
			writeLotteryLog();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
