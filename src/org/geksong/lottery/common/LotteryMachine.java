package org.geksong.lottery.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/******************************
 *Copyright (c)  by iCafeMavin Information Technology Inc.
 * All right reserved.<br>
 * Create Time: 2013-5-21 下午4:13:19<br>
 * Author: zs.zeng<br>
 * File name: LotteryMachine.java <br>
 * Version: 1.0<br>
 * Function: 抽奖机<br>
 * Modify Time: 2013-5-21 下午4:13:19<br>
 * Change Log:<br>
 ******************************************/
public class LotteryMachine {
	/**
	 * 抽奖<br>
	 * <br>
	 * Author:zs.zeng<br>
	 * Create Date:2013-5-22 上午10:57:28<br>
	 * @param goodsMap key为奖品代号，value为奖品总数
	 * @return
	 */
	public static int lottery(Map<Integer, Integer> goodsMap) {
		int goodsNo = 0;
		int sum = 0;
		Set<Map.Entry<Integer, Integer>> se = goodsMap.entrySet();
		for(Map.Entry<Integer, Integer> me : se) {
			sum += me.getValue();
		}
		int b = getRandom(sum);
		int pre = 0;
		int cur = 0;
		for(Map.Entry<Integer, Integer> me : se) {
			cur = me.getValue();
			if(pre <= b && b < cur + pre) {
				goodsNo = me.getKey();
				break;
			}else {
				pre += cur;
			}
		}
		return goodsNo;
	}
	
	/**
	 * 抽奖机,物品代号可为任意的数据类型
	 * <br>
	 * Author:zs.zeng<br>
	 * Create Date:2013-5-31 下午3:15:57<br>
	 * @param goodsMap key为奖品代号，value为奖品数
	 * @return
	 */
	public static String doLottery(Map<String, Integer> goodsMap) {
		String goodsNo = null;
		int sum = 0;
		Set<Map.Entry<String, Integer>> se = goodsMap.entrySet();
		for(Map.Entry<String, Integer> me : se) {
			sum += me.getValue();
		}
		int b = getRandom(sum);
		int pre = 0;
		int cur = 0;
		for(Map.Entry<String, Integer> me : se) {
			cur = me.getValue();
			if(pre <= b && b < cur + pre) {
				goodsNo = me.getKey();
				break;
			}else {
				pre += cur;
			}
		}
		return goodsNo;
	}
	
	/**
	 * 获取0 - (num-1)之间的整数随机数
	 * <br>
	 * Author:zs.zeng<br>
	 * Create Date:2013-5-22 上午10:46:37<br>
	 * @param num
	 * @return
	 */
	public static int getRandom(int num) {
		int b = (int)(Math.random() * (num));
		return b;
	}
	
	public static void main(String[] args) {
		List<String> il = new LinkedList<String>();
		il.add("list");
		il.add("map");
		il.add("common");
		il.add("common");
		il.add("linux");
		for(int i = 0; i < il.size(); i++) {
			System.out.println(i + "=>" + il.get(i));
		}
		il.remove(1);
		for(int i = 0; i < il.size(); i++) {
			System.out.println(i + "=>" + il.get(i));
		}
	}
}
