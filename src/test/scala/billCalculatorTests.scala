package CafeManager

import org.scalatest.FlatSpec

class BillCalcTests extends FlatSpec{
  "BillCalc passed a list of items " should
    "return a standard bill" in {
    val items = Array("Cola", "Coffee", "Cheese Sandwich")
    val calculator: BillCalc =  new BillCalc()
    val bill = calculator.CalcPrice(items)
    var expected: BigDecimal = 3.50
    assert(bill == expected)
  }

  "BillCalc passed a list of items " should
    "return a bill with cold food service charge" in {
    val items = Array("Cola", "Coffee", "Cheese Sandwich")
    val calculator: BillCalc =  new BillCalc()
    val bill =  calculator.CalcPriceWithServiceCharge(items)
    var expected: BigDecimal = 3.85
    assert(bill == expected)
  }


  "BillCalc passed a list of items " should
    "return a bill with hot food service charge" in {
    val items = Array("Cola", "coffee", "Steak Sandwich")
    val calculator: BillCalc =  new BillCalc()
    val bill =  calculator.CalcPriceWithServiceCharge(items)
    var expected: BigDecimal = 7.20
    assert(bill == expected)
  }

    "BillCalc passed a list of items " should
     "return a bill with hot food service charge not above £20" in {
    val items = Array("Cola", "Coffee", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
        "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
        "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
        "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")
    val calculator: BillCalc =  new BillCalc()
    val billWithServiceCharge =  calculator.CalcPriceWithServiceCharge(items)
    val billWithoutServiceCharge =  calculator.CalcPrice(items)
    assert(billWithServiceCharge - billWithoutServiceCharge <= 20)

 
  }


}