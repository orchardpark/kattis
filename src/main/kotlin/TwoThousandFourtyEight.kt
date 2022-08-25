class TwoThousandFourtyEight {
}

data class Cell(var value: Int, var hasMerged: Boolean)

fun toCellArray(matrix: Array<IntArray>): Array<Array<Cell>>
{
    val cellMatrix = Array(4){Array(4){Cell(0, false)}}
    for(i in 0 until 4)
    {
        for (j in 0 until 4)
        {
            cellMatrix[i][j] = Cell(matrix[i][j], false)
        }
    }
    return cellMatrix
}

fun toMatrix(cellMatrix: Array<Array<Cell>>) : Array<IntArray>
{
    val matrix = Array(4){IntArray(4){0} }
    for(i in 0 until 4)
    {
        for (j in 0 until 4)
        {
            matrix[i][j] = cellMatrix[i][j].value
        }
    }
    return matrix
}

fun moveTiles(matrix: Array<IntArray>, direction: Int): Array<IntArray> {
    val cellMatrix = toCellArray(matrix)
    var dx = 0
    var dy = 0
    when (direction) {
        0 -> {
            dx = -1
        }
        1 -> {
            dy = -1
        }
        2 -> {
            dx = 1
        }
        else -> {
            dy = 1
        }
    }
    var hasMoved = true
    while(hasMoved) {
        hasMoved =false
        for (k in 0 until 4)
            for (l in 0 until 4) {
                var i = 0
                var j = 0
                when (direction) {
                    0 -> {
                        i=k
                        j=l
                    }
                    1 -> {
                        i=k
                        j=l
                    }
                    2 -> {
                        j = 3-k
                        i = l
                    }
                    3 -> {
                        j = k
                        i = 3-l
                    }
                }
                if (i + dy < 0 || i + dy >= 4 || j + dx < 0 || j + dx >= 4 || cellMatrix[i][j].value==0) continue
                if (cellMatrix[i + dy][j + dx].value == 0) {
                    cellMatrix[i + dy][j + dx] = cellMatrix[i][j].also { cellMatrix[i][j] = Cell(0, false) }
                    hasMoved = true
                }
                else if(cellMatrix[i + dy][j + dx].value <= 1024
                    && cellMatrix[i + dy][j + dx].value == cellMatrix[i][j].value
                    && !cellMatrix[i + dy][j + dx].hasMerged && !cellMatrix[i][j].hasMerged)
                {
                    cellMatrix[i + dy][j + dx].value*=2
                    cellMatrix[i + dy][j + dx].hasMerged=true
                    cellMatrix[i][j]=Cell(0,false)
                    hasMoved=true
                }
            }
    }
    return toMatrix(cellMatrix)
}

fun main(args: Array<String>) {
    // Read 4x4 matrix of numbers from stdin
    val matrix = Array(4) { IntArray(4) { 0 } }
    for (i in 0 until 4) {
        readLine()!!.split(" ").map { it.toInt() }.toIntArray().copyInto(matrix[i])
    }
    // Read direction (int) from stdin
    val direction = readLine()!!.toInt()
    val result = moveTiles(matrix, direction)
    // Print result
    for (i in 0 until 4) {
        // print the i-th row
        println(result[i].joinToString(" "))
    }

}