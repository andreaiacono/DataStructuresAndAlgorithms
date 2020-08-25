@file:JvmName("Solution")

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val t = scanner.nextLong()
    for (i in 1..t) {
        val p = scanner.nextInt()
        val q = scanner.nextInt()
        val arr = ArrayString2D(p, 3, scanner)
        println("Case #$i: ${getPosition(arr, q)}")
    }
}

fun getPosition(arr: ArrayString2D, q: Int): String {
    val rectangles = mutableListOf<Rectangle>()
    for (row in 0 until arr.rows) {
        val x = arr.vals[row][0].toInt()
        val y = arr.vals[row][1].toInt()
        when (arr.vals[row][2]) {
            'E' -> rectangles.add(row, Rectangle(x, q, 0, q))
            'W' -> rectangles.add(row, Rectangle(0, x, 0, q))
            'N' -> rectangles.add(row, Rectangle(0, q, y, q))
            'S' -> rectangles.add(row, Rectangle(0, q, 0, y))
        }
    }

    var minX = q
    var minY = q

    for (row in 0 until arr.rows) {
        for (col in 0 until arr.cols) {
            for (rectangle in rectangles) {
                if (rectangle.contains(row, col) && row <= minY && col <= minX) {
                    minY = row
                    minX = col
                }
            }
        }
    }

    return "$minY $minX"
}

data class Rectangle(val left: Int, val right: Int, val bottom: Int, val top: Int) {
    fun contains(x: Int, y: Int) = x in left..right && y in bottom..top
}

class ArrayString2D (val rows: Int, val cols: Int, scanner: Scanner, val fill: Char = ' ') {

    val vals = Array(rows) {Array(cols) { fill } }

    init {
        for (row in 1..rows) {
            for (col in 1..cols) {
                val line:String = scanner.next()
                vals[row-1][col-1] = line.toCharArray()[0]
            }
        }
    }

    override fun toString() = Arrays.deepToString(vals)

    fun getValues(): List<Char> {
        val list = mutableListOf<Char>()
        for (row in 1..rows) {
            list.addAll(vals[row-1])
        }
        return list
    }
    fun getUniqueValues(): Set<Char> {
        val set = mutableSetOf<Char>()
        for (row in 1..rows) {
            set.addAll(vals[row-1])
        }
        return set
    }
    fun transform(operation: (Char) -> Char) {
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

    fun forEach(operation: (Char) -> Unit) {
        vals.forEach { row -> row.forEach { operation.invoke(it) } }
    }
    inline fun forEachIndexed(operation: (x: Int, y: Int, Char) -> Unit) {
        vals.forEachIndexed { idx, row -> row.forEachIndexed { idy, t -> operation.invoke(idx, idy, t) } }
    }

}

