package ru.netology

fun main() {

    val previosPeriodSpent = 12000_00
    val price = 600_00
    val stanardDiscount = 100_00
    val premiumDiscount = 5
    val melomaniacDiscount = 1
    val ifUserMelomaniac = true
    val discountStart = 1_000_00
    val premiumDscountStart = 10_000_00
    val totalPrice: Int

    println("За прошлый период вы потратили ${convertPriceToString(previosPeriodSpent)}")
    println("Вы совершаете покупку на ${convertPriceToString(price)}")

    if (previosPeriodSpent < discountStart) {
        val melomaniacDiscountSummary = if (ifUserMelomaniac) price * melomaniacDiscount / 100 else 0
        totalPrice = price - melomaniacDiscountSummary
        println("Сумма платежа с учетом скидок составляет  ${convertPriceToString(totalPrice)}")
    } else if (discountStart < previosPeriodSpent && previosPeriodSpent < premiumDscountStart) {
        val standardDiscountSummary = price - stanardDiscount
        val melomaniacDiscountSummary = if (ifUserMelomaniac) standardDiscountSummary * melomaniacDiscount / 100 else 0
        totalPrice = standardDiscountSummary - melomaniacDiscountSummary
        println("Сумма платежа с учетом скидок составляет  ${convertPriceToString(totalPrice)}")
    } else if (previosPeriodSpent > premiumDscountStart) {
        val premiumDiscountSummary = price * premiumDiscount / 100
        val melomaniacDiscountSummary = if (ifUserMelomaniac) premiumDiscountSummary * melomaniacDiscount / 100 else 0
        totalPrice = premiumDiscountSummary - melomaniacDiscountSummary
        println("Сумма платежа с учетом скидок составляет  ${convertPriceToString(totalPrice)}")
    }
}

fun convertPriceToString(price: Int): String {
    val priceValueRub = price / 100
    val priceValueCop = price % 100
    val priceValueCopFormatted: String = String.format("%02d", priceValueCop)
    return priceValueRub.toString() + " руб. " + priceValueCopFormatted + "коп."
}



