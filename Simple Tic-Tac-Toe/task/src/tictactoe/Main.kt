package tictactoe

fun main() {
    var xOrO = 'X'
    var condition = true
    var printWin = ""
    val field: MutableList<CharArray> = MutableList(3){ CharArray(3){' '} }
    printField(field)

    while (condition) {
        try {
            print("Enter the coordinates: ")
            val (row, cell) = readln().split(" ").map { it.toInt() - 1}
            if (field[row][cell] == 'X' || field[row][cell] == 'O') {
                println("This cell is occupied! Choose another one!")
            } else {
                field[row][cell] = xOrO
                if (xOrO == 'X') xOrO = 'O' else xOrO = 'X'
                printField(field)
                printWin = win(field)
                if (printWin == "X wins" || printWin == "O wins" ||printWin == "Draw") {
                    println(printWin)
                    condition = false
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Coordinates should be from 1 to 3!")
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        }
    }
}

fun printField(field: List<CharArray>) {
    println("---------")
    for (row in field) {
        print("| ")
        for (cell in row) {
            print("$cell ")
        }
        println("|")
    }
    println("---------")
}

fun win(field: List<CharArray>): String {
    return if (field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X' ||
        field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X' ||
        field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X' ||
        field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
        "X wins"
    }
    else if (field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O' ||
        field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O' ||
        field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O' ||
        field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
        "O wins"
    }
    else if (!field[0].contains(' ') && !field[1].contains(' ') && !field[2].contains(' ')) "Draw"
    else ""
}