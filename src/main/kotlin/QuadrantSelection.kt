class QuadrantSelection{}
fun main(args: Array<String>)
{
    // read x from stdin and parse as int
    val x = readLine()!!.toInt()
    // read y from stdin and parse as int
    val y = readLine()!!.toInt()

    // if in first quadrant
    if (x > 0 && y > 0)
    {
        println("1")
    }
    // if in second quadrant
    else if (x < 0 && y > 0)
    {
        println("2")
    }
    // if in third quadrant
    else if (x < 0 && y < 0)
    {
        println("3")
    }
    // if in fourth quadrant
    else if (x > 0 && y < 0)
    {
        println("4")
    }
}