package com.igorwojda.integer.countdown

// Kotlin idiomatic solution
private object CountDownSolution {
    private fun countDown(n: Int): List<Int> {
        // Create a range and convert it to a list
        return (n downTo 0).toList()
    }
}

// Recursive solution
private object CountDownSolution2 {
    private fun countDown(n: Int): List<Int> {
        // We want to keep return type unchanged while implementing recursive solution, so we will
        // use helper method defied inside countDown function.
        fun helper(n: Int): MutableList<Int> {
            if (n == 0) {
                return mutableListOf(0)
            }

            return mutableListOf(n).also { it.addAll(countDown(n - 1)) }
        }

        return helper(n).toList()
    }
}
