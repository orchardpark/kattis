class Matrix(val a: Int, val b: Int, val c: Int, val d: Int) {

    private fun determinant(): Int {
        return a*d-b*c;
    }

    private fun multiply(factor: Int): Matrix{
        return Matrix(a*factor, b*factor, c*factor, d*factor)
    }

    fun inverse(): Matrix{
        val factor = 1/determinant();
        return Matrix(d, -b, -c, a).multiply(factor)
    }
}

fun readCase(): Matrix? {
    val firstLine = readLine() ?: return null
    val secondLine = readLine() ?: return null
    val empty = readLine()
    val firstRow  = firstLine.split(" ").map { sNum -> sNum.toInt() }
    val secondRow  = secondLine.split(" ").map { sNum -> sNum.toInt() }
    val a = firstRow[0]
    val b = firstRow[1]
    val c = secondRow[0]
    val d = secondRow[1]
    return Matrix(a, b,c,d)

}

fun main(args: Array<String>){
    var caseNum = 1;
    var m: Matrix?;
    while(true){
        m = readCase()
        if(m==null) break
        else{
            val invM = m.inverse()
            println(String.format("Case %d:", caseNum))
            println(String.format("%d %d", invM.a, invM.b))
            println(String.format("%d %d", invM.c, invM.d))
            caseNum++;
        }
    }
}