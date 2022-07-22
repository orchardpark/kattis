class ThreeDPrintedStatues {
}

fun main(string: Array<String>)
{
    val n = readLine()!!.toInt()
    var numPrinters = 1
    var count = 1;
    while(numPrinters < n)
    {
        numPrinters *= 2
        count++
    }
    println(count)
}