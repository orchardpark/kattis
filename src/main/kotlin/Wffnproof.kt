class Wffnproof {
}

fun solve(wff: String){
    var res = ""
    var variables = mutableListOf<Char>()
    var numUnary = 0
    var binary = mutableListOf<Char>()
    for(c in wff){
        when {
            c.isLowerCase() -> {
                variables.add(c)
            }
            c=='N' -> {
                numUnary++;
            }
            else -> {
                binary.add(c)
            }
        }
    }
    // first binary operator
    if(binary.size > 0 && variables.size > 1){
        val operator = binary.last()
        val firstOperand = variables.last()
        variables.removeAt(variables.size-1)
        val secondOperand = variables.last()
        res = ""+operator + firstOperand + secondOperand
        binary.removeAt(binary.size-1)
        variables.removeAt(variables.size-1)
    }
    // remaining binary operators
    while(binary.size > 0 && variables.size > 0){
        val operator = binary.last()
        val secondOperator = variables.last()
        res = operator + res + secondOperator
        binary.removeAt(binary.size-1)
        variables.removeAt(variables.size-1)
    }
    // add unary operators
    if(res.isNotEmpty() && numUnary > 0){
        res = "N".repeat(numUnary) + res
    }
    // if no operators could be performed
    if(res.isEmpty()) {
        if (variables.size > 0) {
            res = "" + variables.last()
        } else {
            res = "no WFF possible"
        }
    }
    println(res)

}

fun main(args: Array<String>){
    var line: String
    while(true){
        line = readLine()!!
        if(line.equals("0")) break
        solve(line)
    }

}