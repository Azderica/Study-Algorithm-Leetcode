package com.myepark.programmers.basics;

import java.util.Stack;

public class 주식가격 {
    class Stock {
        int index;
        int price;

        public Stock(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stocks = new Stack<>();

        stocks.add(new Stock(0, prices[0]));
        for (int i = 1; i < prices.length; i++) {
            int cnt = 0;
            while (stocks.peek().price > prices[i]) {
                Stock stock = stocks.pop();
                answer[stock.index] = i - stock.index;
                if (stocks.isEmpty())
                    break;
            }
            stocks.add(new Stock(i, prices[i]));
        }
        while(!stocks.isEmpty()) {
            Stock stock = stocks.pop();
            answer[stock.index] = prices.length - 1 - stock.index;
        }

        return answer;
    }
}
