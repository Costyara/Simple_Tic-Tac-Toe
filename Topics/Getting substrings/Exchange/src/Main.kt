fun main() {
    val input = readln()
    println(input.last() + input.substring(1, input.lastIndex) + input.first())
}