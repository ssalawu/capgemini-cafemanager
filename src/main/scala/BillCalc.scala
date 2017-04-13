package CafeManager

class BillCalc {


  def CalcPrice( items:Array[String] ) : BigDecimal = {
    var sum:BigDecimal = 0
    for (item <- items) {
      val i = item.toLowerCase
      if (i == "cola"){
        sum = sum + 0.50
      } else if (i == "coffee"){
        sum = sum + 1.00
      } else if (i == "cheese sandwich"){
        sum = sum + 2.00
      } else if (i == "steak sandwich"){
        sum = sum + 4.50
      }
    }
    return sum
  }

  def CalcPriceWithServiceCharge( items:Array[String] ) : BigDecimal = {
    var sum:BigDecimal = 0
    var service:BigDecimal = 0
    var food:Boolean = false
    var hotFood:Boolean = false

    for (item <- items) {
      val i = item.toLowerCase
      if (i == "cola"){
        sum = sum + 0.50
      } else if (i == "coffee"){
        sum = sum + 1.00
      } else if (i == "cheese sandwich"){
        sum = sum + 2.00
        if (hotFood == false){
          food = true
        }
      } else if (i == "steak sandwich"){
        sum = sum + 4.50
        hotFood = true
        food = false
      }
    }

    if (food == true){
      service = sum * 0.1
    } else if (hotFood == true){
      service = sum * 0.2
      if (service > 20){
        service = 20
      }
    }
    sum = sum + service
    return sum
  }

}