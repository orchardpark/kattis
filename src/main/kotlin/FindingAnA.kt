class FindingAnA {
}

fun main(args: Array<String>)
{
    val s = readLine()!!.trim()
    val indexOfA = s.indexOf('a')
    println(s.substring(indexOfA))
}