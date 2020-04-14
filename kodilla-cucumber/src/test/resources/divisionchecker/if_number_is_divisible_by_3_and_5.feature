Feature: if number is divisible by 3 and 5?

  Scenario Outline: Number divides by 3 or 5
    Given I enter <number>
    When I am checking if the number is divisible
    Then I should say <answer>
    Examples:
      | number | answer     |
      | 15     | "FizzBuzz" |
      | 10     | "Buzz"     |
      | 9      | "Fizz"     |
      | 6      | "Fizz"     |
      | 5      | "Buzz"     |
      | 3      | "Fizz"     |
      | 2      | "None"     |
      | 4      | "None"     |
      | 7      | "None"     |

