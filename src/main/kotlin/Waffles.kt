@file:JvmName("Solution2")

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val t = scanner.nextLong()
    for (i in 1..t) {
        val r = scanner.nextInt()
        val c = scanner.nextInt()
        val arr = ArrayString2D(r, c, scanner)
        println("Array #$1: $arr\n${arr.toGrid()}")
        val n = arr.getUniqueValues().size

    }
}



class ArrayInt2D (val rows: Int, val cols: Int, scanner: Scanner, val fill: Int = 0) {

    val vals = Array(rows) {Array(cols) { fill } }

    init {
        for (row in 1..rows) {
            for (col in 1..cols) {
                vals[row-1][col-1] = scanner.nextInt()
            }
        }
    }

    override fun toString() = Arrays.deepToString(vals)

    fun transform(operation: (Int) -> Int) {
        for (row in 1..rows) {
            for (col in 1..cols) {
                vals[row-1][col-1] = operation(vals[row-1][col-1])
            }
        }
    }

    fun toGrid(): String {
        val builder = StringBuilder()
        for (row in 1..rows) {
            for (col in 1..cols) {
                builder.append(vals[row-1][col-1])
            }
            builder.append("\n")
        }
        return builder.toString()
    }

    fun forEach(operation: (Int) -> Unit) {
        vals.forEach { row -> row.forEach { operation.invoke(it) } }
    }

    inline fun forEachIndexed(operation: (x: Int, y: Int, Int) -> Unit) {
        vals.forEachIndexed { idx, row -> row.forEachIndexed { idy, t -> operation.invoke(idx, idy, t) } }
    }
}
