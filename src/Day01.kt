fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        var isFirst = true
        var previous = -1
        input.forEach { current ->
            val currentCast = current.toInt()
            if (!isFirst) {
                if (currentCast > previous) count++
                previous = currentCast
            } else {
                isFirst = false
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        var i = 1
        var previous: List<Int> = input.subList(0, 3).map { it.toInt() }

        while (i + 3 <= input.size) {
            val currentTarget = input.subList(i, i + 3).toList()
            if (currentTarget.size == 3) {
                val current = currentTarget.map { it.toInt() }.toList()
                var currentSum = 0
                current.forEach { currentSum += it }

                var previousSum = 0
                previous.forEach { previousSum += it }

                if (currentSum > previousSum) count++

                previous = current
            }
            i += 1
        }
        return count
    }

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}
