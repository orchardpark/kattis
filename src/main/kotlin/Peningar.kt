class Peningar {
}

fun main() {
    val input = readLine()!!.split(" ")
    val n = input.first().toInt()
    val d = input.last().toULong().mod(n.toUInt()).toInt()
    val m = readLine()!!.split(" ").map { it.toULong() }
    val mem = BooleanArray(n)
    var pos = 0
    var money = 0UL
    while(true)
    {
        // step
        pos = (pos + d) % n
        // stop if we have been here
        if (mem[pos])
            break;
        // take the money
        money += m[pos]
        // mark as visited
        mem[pos] = true
    }
    println(money)
}