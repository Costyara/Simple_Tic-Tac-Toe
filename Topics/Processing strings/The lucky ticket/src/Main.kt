const val N = 6
fun main() {
    val digits = readln().map { it.digitToInt() }
    val lucky = digits.subList(0, N / 2).sum() == digits.subList(N / 2, N).sum()
    println(if (lucky) "Lucky" else "Regular")
}