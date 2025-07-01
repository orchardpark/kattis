class BuildingHighways {
}

fun main() {
    val N = readLine()!!.toULong()
    val A = readLine()!!.split(" ").map { it.toULong() }
    val sum = A.sum()
    val min = A.min()
    println(sum-min+min*(N-1UL))
}