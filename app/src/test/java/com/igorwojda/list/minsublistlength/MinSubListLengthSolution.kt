package com.igorwojda.list.minsublistlength

// Time complexity: O(n)
// Space complexity O(n)
// Use sliding window
private object OptimalSolution {
    fun minSubListLength(list: List<Int>, sum: Int): Int {
        var total = 0
        var start = 0
        var end = 0
        var minLen: Int? = null

        while (start < list.size) {
            // if current window doesn't add up to the given sum then move the window to right
            if (total < sum && end < list.size) {
                total += list[end]
                end++
            }
            // if current window adds up to at least the sum given then we can shrink the window
            else if (total >= sum) {
                minLen = min(minLen, end - start)
                total -= list[start]
                start++
            }
            // current total less than required total but we reach the end, need this or else we'll be in an infinite loop
            else {
                break
            }
        }

        return minLen ?: 0
    }

    private fun min(i1: Int?, i2: Int?): Int? {
        return when {
            i1 != null && i2 != null -> Math.min(i1, i2)
            i1 != null && i2 == null -> i1
            i1 == null && i2 != null -> i2
            else -> null
        }
    }
}

// Time complexity: O(n^2)
// Loop through all the elements and then loop through all sublists
private object NaiveSolution {
    fun minSubListLength(list: List<Int>, sum: Int): Int {
        return 0
    }
}
