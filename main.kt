import java.util.*

enum class ANSWERS(val value: String) {
    THIRD_SUCCESS("{(([])[])[]}"),
    THIRD_FAILED("{([)}")
}

fun firstQuestion() {
        val arr1 = listOf(1, 1, 0, 1, 1, 0, 0, 0, 1)
        var score1 = 0
        var score2 = 0

        for (i in 0..arr1.size) {
            if (arr1[i] == 1) {
                score1 += 1

                if (arr1[i + 1] == 0) {
                    break
                }
            }
        }

        val reverseArray1 = arr1.reversed()
        for (i in 0..reverseArray1.size) {
            if (reverseArray1[i] == 1) {
                score2 += 1

                if (reverseArray1[i + 1] == 0) {
                    break
                }
            }
        }

        val score = if (score1 > score2) score1 else score2
        println("RESULT TEST: $score")
    }


    fun secondQuestion(word: CharArray) {
        if (word.size <= 1) {
            println("RESULT TEST: ${word[0]}")
        } else {
            println("RESULT TEST: ${word[word.size.minus(1)]}")
            secondQuestion(word.copyOfRange(0, word.size.minus(1)))
        }
    }

    fun thirdQuestion(value: ANSWERS) {
        val word = if (value == ANSWERS.THIRD_SUCCESS) ANSWERS.THIRD_SUCCESS.value else ANSWERS.THIRD_FAILED.value
        val result = if (isBalancedBrackets(word)) "YES" else "NO"
        println("RESULT TEST: $result")
    }

    private fun isBalancedBrackets(word: String): Boolean {
        if (word.isEmpty()) return false
        val alphabetStack = Stack<Char>()
        for (i in word.indices) {
            val char = word.toCharArray()[i]
            if (char == '(' || char == '{' || char == '[') {
                alphabetStack.push(char)
            } else if (char == ')' || char == '}' || char == ']') {
                if (!alphabetStack.isEmpty()) {
                    val lastChar = alphabetStack.pop()
                    if (lastChar == '(' && char != ')') {
                        return false
                    } else if (lastChar == '{' && char != '}') {
                        return false
                    } else if (lastChar == '[' && char != ']') {
                        return false
                    }
                } else {
                    return false
                }
            }
        }

        return alphabetStack.isEmpty()
    }

fun main() {
    println("SOAL KE 1 ====================================")
    firstQuestion()
    println("==============================================")
    println("")
    println("SOAL KE 2 ====================================")
    secondQuestion(charArrayOf('p', 'e', 'r', 's', 'i', 'b'))
    println("==============================================")
    println("")
    println("SOAL KE 3 ====================================")
    thirdQuestion(ANSWERS.THIRD_SUCCESS)
}