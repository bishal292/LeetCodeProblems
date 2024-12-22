class Solution {
    public int maxProfit(int[] prices) {

        // Without using Kadane's Algorithm.

        // if(prices.length == 1) return 0;

        // // variable to store the lowest and highest price index in such way low is < high.
        // int costPrice = prices[0] < prices[1] ? 0 : 1;
        // int sellPrice = costPrice ^ 1;//if low is 0 the high is 1 and vice-versa
        // int profit = costPrice < sellPrice ? prices[sellPrice]- prices[costPrice] : 0;// if there is valid profit.......

        // for(int i = 2;i<prices.length;i++){
        //     if(prices[costPrice] > prices[i] && i != prices.length-1){//current price is even lower than the previous lowest price and is not last element in array.

        //     // change both as the sell price must be after the cost price
        //         costPrice = i;
        //         sellPrice = i;
        //     }else if(prices[sellPrice] < prices[i] || sellPrice < costPrice){ //if Current Selling Price is more than previous one or is smaller than the costPrice
        //         sellPrice = i;
        //     }
        //     if(sellPrice > costPrice){// if index of sellPrice is greater than costPrice then calculate profit
        //         profit = Math.max(profit,prices[sellPrice] - prices[costPrice] );
        //     }
        // }

        // return Math.max(profit , 0);//if there is loss instead of profit then return 0



        // Using Kadane's Algorithm

        int costPrice = prices[0];
        int profit = 0;
        for(int price: prices){
            if(price < costPrice)
                costPrice = price;
            else
                profit = Math.max(profit , price - costPrice);
        }
        return profit;
    }
}