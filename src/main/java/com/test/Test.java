package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Test {

	class LuckdrawPrize {

		// ����
		private String name;

		// �н�����, �ٷ���
		private Double odds;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getOdds() {
			return odds;
		}

		public void setOdds(Double odds) {
			this.odds = odds;
		}
	}

	private double total = 100;

	public LuckdrawPrize doDrawPrize() {
		LuckdrawPrize luckdrawPrize = new LuckdrawPrize();
		luckdrawPrize.setName("weixin1");
		luckdrawPrize.setOdds(50.0);
		LuckdrawPrize luckdrawPrize1 = new LuckdrawPrize();
		luckdrawPrize1.setName("weixin2");
		luckdrawPrize1.setOdds(30.0);
		LuckdrawPrize luckdrawPrize2 = new LuckdrawPrize();
		luckdrawPrize2.setName("weixin3");
		luckdrawPrize2.setOdds(20.0);
		List<LuckdrawPrize> prizeList = new ArrayList<>();
		prizeList.add(luckdrawPrize);
		prizeList.add(luckdrawPrize1);
		prizeList.add(luckdrawPrize2);

		List<Double> oddsList = prizeList.stream().map(LuckdrawPrize::getOdds)
				.collect(Collectors.toList());

		List<Double> sortRateList = new ArrayList<Double>();

		// �������һ���������������
		double random = ThreadLocalRandom.current().nextDouble();
		sortRateList.add(random);
		Collections.sort(sortRateList);

		double v = ThreadLocalRandom.current().nextDouble(100);

		oddsList.add(v);
		Collections.sort(oddsList);

		// ���ظ�������ڱ��������е�����
		int index = oddsList.indexOf(v) - 1;
		if (index < 0) {
			index = 0;
		}
		return prizeList.get(index);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {

			Test test = new Test();
			LuckdrawPrize luckdrawPrize = test.doDrawPrize();
			System.out.println(luckdrawPrize.name + "-"
					+ luckdrawPrize.getOdds());
		}
	}

}
