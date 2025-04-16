# TP1 ReadMe

## Test Structure
For each exercise, all tests (covering Line Coverage, Branch Coverage, and Condition Coverage) are combined into a single test class `ExoNameTest.java`. This is because the tests for these criteria often overlap significantly, as detailed below.

## Overlapping Coverage Criteria

### Exercise 1: Palindrome
- **Line, Branch, and Condition Coverage**: Combined into `PalindromeTest.java`. The tests cover all lines, branches, and conditions (e.g., `s == null`, `i < j`, `s.charAt(i) != s.charAt(j)`).

### Exercise 2: Anagram
- **Line, Branch, and Condition Coverage**: Combined into `AnagramTest.java`. Tests cover all combinations of `s1 == null || s2 == null`, `s1.length() != s2.length()`, and `c != 0`.

### Exercise 3: BinarySearch
- **Line, Branch, and Condition Coverage**: Combined into `BinarySearchTest.java`. Tests ensure `array == null`, `low <= high`, `array[mid] == element`, and `array[mid] < element` are evaluated for all outcomes.

### Exercise 4: QuadraticEquation
- **Line, Branch, and Condition Coverage**: Combined into `QuadraticEquationTest.java`. Tests cover `a == 0`, `delta < 0`, and `delta == 0` for all outcomes.

### Exercise 5: RomanNumeral
- **Line, Branch, and Condition Coverage**: Combined into `RomanNumeralTest.java`. Tests cover `n < 1 || n > 3999` and `n >= values[i]` for all outcomes.

### Exercise 6: FizzBuzz
- **Line, Branch, and Condition Coverage**: Combined into `FizzBuzzTest.java`. Tests cover `n < 1`, `n % 15 == 0`, `n % 3 == 0`, and `n % 5 == 0` for all outcomes.