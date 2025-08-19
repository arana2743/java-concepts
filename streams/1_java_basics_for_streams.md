# Streams in Java

## Video reference link:
https://www.youtube.com/watch?v=E10Q6-nWO9g
@ 1.54.37
### Java 8 introduced
- concept of minimal code
- addition of functional programming features
- key programming features that got added:
    - Streams
    - Lambdas
    - Date and Time APIs

#### Lambda expressions
- Lambda expression is an anonymous function (no name, no return type, no access modifier)
- Lambda expression can hold reference to functional interface.
- Or other way to say is Lambda expressions are used to implement functional interfaces in more concise manner.


### Types of Function Interfaces (provided with Java for ease)
1. Predicate
    - Predicate holds a condition and return a boolean to check the condition
    - abstract method is `test`
2. Function
    - Function holds a method type logic which can be applied
    - abtract method is `apply`
    - some default functions
        - 'andThen()' => helps in combining two Functions 
            - e.g. `Function1.andThen(Function2)`
            - in above Function1 will be applied first then Function2
        - 'compose()' => also help in combining two Functions
            - e.g., `Function1.compose(Function2)`
            - in above Function2 will be applied first then Function1
    - some static functions
        - 'identity()' => returns exactly the same argument back
    - For dual argument acceptance
        - BiFunction => used when we have to pass two arguments
    - UnaryOperator
        - shorthand for Function when both argument and returntype are of same datatype
    - BinaryOperator
        - shorthand for BiFunction when both arguments and returntype are of same datatype 
3. Consumer
    - Consumer accepts an argument but returns nothing.
    - abstract method is `accept`
4. Supplier
    - Supplier accepts no argument and returns a value
    - abstract methid is `get`

### Method Reference
- provides a way to use method without invoking
- used in place of lambda expressions

### Constructor Reference
- provides a way to call an object without invoking
- used in place of lambda expressions