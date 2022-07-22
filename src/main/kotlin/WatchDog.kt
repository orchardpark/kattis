import kotlin.math.sqrt

class WatchDog {
    fun getPosition(s: Int, hatches: List<Pair<Int, Int>>) : String
    {
        for(i in 0..s)
        {
            for(j in 0 .. s)
            {
                // check if pair (i,j) exists in hatches
                if(hatches.contains(Pair(i,j)))
                {
                    continue;
                }
                else{
                    // find the max euclidean distance from (i,j) to the hatches
                    hatches.map{ Pair(it.first - i, it.second - j) }.maxByOrNull { it.first * it.first + it.second * it.second }?.let {
                        // if (i,j) is within the square that goes from (0,0) to (s,s) if extended in any direction by the max euclidean distance, the position is found
                        val distance = sqrt((it.first * it.first + it.second * it.second).toDouble());
                        if(i-distance >=0 && i+distance<=s && j-distance >=0 && j+distance<=s)
                        {
                            return "$i $j";
                        }
                    }
                }
            }
        }
        return "poodle";
    }
}

fun main(args: Array<String>)
{
    // Read the number of testcases from the first line of the input
    val testCases = readLine()!!.toInt()
    // For each test case, read two integers S and H
    for (i in 1..testCases)
    {
        val (s, h) = readLine()!!.split(" ").map { it.toInt() }
        // for each hatch H, read the x and y coordinates of the hatch and store these coordinates
        // in a list of pairs.
        val hatches = mutableListOf<Pair<Int, Int>>()
        for (j in 1..h)
        {
            val (x,y) = readLine()!!.split(" ").map { it.toInt() }
            hatches.add(Pair(x,y))
        }
        // Get position of the latch
        val position = WatchDog().getPosition(s, hatches)
        // Print the position of the latch
        println(position)
    }
}