package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DrawLotteryUtil {

	public static int drawGift(List<Gift> giftList) {

		if (null != giftList && giftList.size() > 0) {
			List<Double> orgProbList = new ArrayList<Double>(giftList.size());
			for (Gift gift : giftList) {
				// ��˳�򽫸�����ӵ�������
				orgProbList.add(gift.getProb());
			}

			return draw(orgProbList);

		}
		return -1;
	}

	public static int draw(List<Double> giftProbList) {

		List<Double> sortRateList = new ArrayList<Double>();

		// ��������ܺ�
		Double sumRate = 0D;
		for (Double prob : giftProbList) {
			sumRate += prob;
		}

		if (sumRate != 0) {
			double rate = 0D; // ������ռ����
			for (Double prob : giftProbList) {
				rate += prob;
				// ����һ������������ɵļ���(������ʺͲ�Ϊ1)
				sortRateList.add(rate / sumRate);
			}

			// �������һ���������������
			double random = ThreadLocalRandom.current().nextDouble();
			sortRateList.add(random);
			Collections.sort(sortRateList);

			// ���ظ�������ڱ��������е�����
			return sortRateList.indexOf(random);
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(ThreadLocalRandom.current().nextDouble());
		Gift iphone = new Gift();
		iphone.setId(101);
		iphone.setName("ƻ���ֻ�");
		iphone.setProb(0.1D);

		Gift thanks = new Gift();
		thanks.setId(102);
		thanks.setName("�ٽ�����");
		thanks.setProb(0.5D);

		Gift vip = new Gift();
		vip.setId(103);
		vip.setName("�ſ��Ա");
		vip.setProb(0.4D);

		List<Gift> list = new ArrayList<Gift>();
		list.add(vip);
		list.add(thanks);
		list.add(iphone);

		for (int i = 0; i < 100; i++) {
			int index = drawGift(list);
			System.out.println(list.get(index));
		}
	}
}