import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

class Moneymatters {
}

class Graph{
    private val adjacencyList: HashMap<Int, HashSet<Int>> = HashMap()
    fun addEdge(source: Int, destination: Int){
        adjacencyList.computeIfAbsent(source) { HashSet() }.add(destination)
        adjacencyList.computeIfAbsent(destination) { HashSet() }.add(source)
    }
    fun getNeighbors(source: Int): HashSet<Int>?{
        return adjacencyList[source]
    }
}

val g: Graph = Graph()
val nodes = IntArray(10000)
val visited = HashSet<Int>()

fun settleDebtDfs(currentNode: Int): Int{
    if(visited.contains(currentNode)) return 0
    visited.add(currentNode)
    var score = nodes[currentNode]
    val neighbors = g.getNeighbors(currentNode)
    neighbors?.forEach { n ->
        run {
            if (!visited.contains(n)) {
                score += settleDebtDfs(n)
            }
        }
    }
    return score
}

fun settleDebt(node: Int): Boolean{
    val res = settleDebtDfs(node)
    return res==0
}

fun solve(){
    // read input
    val (n, m) = readLine()!!.split(" ").map { num -> num.toInt() }
    for(i in 0 until n){
        val credit = readLine()!!.toInt()
        nodes[i] = credit
    }
    for(i in 0 until m){
        val (from, to) = readLine()!!.split(" ").map { num -> num.toInt() }
        g.addEdge(from, to)
    }
    // try to settle debts
    var possible = true
    for(i in 0 until n){
        possible = settleDebt(i)
        if(!possible) break
    }
    if(possible){
        println("POSSIBLE")
    } else{
        println("IMPOSSIBLE")
    }
}

fun main(args: Array<String>){
    solve()
}