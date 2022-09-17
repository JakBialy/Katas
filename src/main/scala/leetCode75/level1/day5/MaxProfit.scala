package leetCode75.level1.day5

object MaxProfit extends App {

  def maxProfit(prices: Array[Int]): Int = {
    prices.foldLeft(Acc(Int.MaxValue, 0)) { (a, stockPriceOfADay) =>
      val currentMin = a.minSoFar
      val currentMaxProfit = a.maxProfitSoFar

      if (stockPriceOfADay < currentMin) Acc(stockPriceOfADay, currentMaxProfit)
      else Acc(currentMin, Math.max(currentMaxProfit, stockPriceOfADay - currentMin))
    }.maxProfitSoFar
  }

  private case class Acc(minSoFar: Int, maxProfitSoFar: Int)

  println(maxProfit(Array(1, 2, 3, 4, 5, 6)))
}