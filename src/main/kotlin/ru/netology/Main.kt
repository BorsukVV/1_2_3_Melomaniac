package ru.netology

fun main() {

    val price = 15000_00
    val stanardDiscount = 100_00
    val premiumDiscount = 5
    val melomaniacDiscount = 1
    val ifUserMelomaniac = true
    val discountStart = 1_000_99
    val premiumDscountStart = 10_000_99
    val totalPrice: Int
    val totalPercentagesAsWhole = 100

    println("Вы совершаете покупку на ${convertPriceToString(price)}")

    if (price < discountStart) {
        totalPrice = if (ifUserMelomaniac) {
            price * (totalPercentagesAsWhole - melomaniacDiscount) / totalPercentagesAsWhole
        } else {
            price
        }
        println("Сумма платежа с учетом скидок составляет  ${convertPriceToString(totalPrice)}")
    } else if (price in (discountStart + 1) until premiumDscountStart) {
        val afterStandardDiscount = price - stanardDiscount
        totalPrice = if (ifUserMelomaniac) {
            afterStandardDiscount * (totalPercentagesAsWhole - melomaniacDiscount) / totalPercentagesAsWhole
        } else {
            afterStandardDiscount
        }
        println("Сумма платежа с учетом скидок составляет  ${convertPriceToString(totalPrice)}")
    } else if (price > premiumDscountStart) {
        val afterPremiumDiscount = price * (totalPercentagesAsWhole - premiumDiscount) / totalPercentagesAsWhole
        totalPrice = if (ifUserMelomaniac) {
            afterPremiumDiscount * (totalPercentagesAsWhole - melomaniacDiscount)/ totalPercentagesAsWhole
        } else {
            afterPremiumDiscount
        }
        println("Сумма платежа с учетом скидок составляет  ${convertPriceToString(totalPrice)}")
    }
}

fun convertPriceToString(price: Int): String {
    val priceValueRub = price / 100
    val priceValueCop = price % 100
    val priceValueCopFormatted: String = String.format("%02d", priceValueCop)
    return priceValueRub.toString() + " руб. " + priceValueCopFormatted + "коп."
}



