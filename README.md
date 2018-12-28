[![Build Status](https://travis-ci.com/mtumilowicz/java11-lambda-expression-statements.svg?branch=master)](https://travis-ci.com/mtumilowicz/java11-lambda-expression-statements)

# java11-lambda-expression-statements
https://docs.oracle.com/javase/specs/jls/se11/html/jls-14.html#jls-14.8

https://stackoverflow.com/questions/41482574/lambda-special-void-compatibility-rule-statement-expression

# preface
Certain kinds of expressions may be used as 
statements by following them with semicolons.

* ExpressionStatement:
    ```
    StatementExpression ;
    ```
* StatementExpression:
    * Assignment 
    * PreIncrementExpression 
    * PreDecrementExpression 
    * PostIncrementExpression 
    * PostDecrementExpression 
    * MethodInvocation 
    * ClassInstanceCreationExpression
    
An expression statement is executed by evaluating the expression; 
if the expression has a value, the value is discarded.

# project description
* assigning a function (`boolean add(E e)`) to `Consumer`
    ```
    var list = new LinkedList<String>();
    Consumer<String> add = list::add;
    
    add.accept("a");
    
    assertThat(list, hasSize(1));
    ```
* function passed as a `Consumer`
    ```
    var source = List.of(1, 2, 3);
    var target = new LinkedList<Integer>();
    
    source.forEach(target::add);
    
    assertThat(target, is(source));
    ```
* `Consumer` that increment the field
    ```
    private int x = 5; // field
    
    // then in code
    Consumer<String> increment = s -> x++;
    
    increment.accept("a");
    increment.accept("a");
    increment.accept("a");
    increment.accept("a");
    
    assertThat(x, is(9));
    ```
* class creation
    ```
    Consumer<Integer> create = X::new;
    
    create.accept(1);
    create.accept(1);
    
    assertThat(X.counter, is(2));
    ```
    where
    ```
    class X {
        static int counter;
    
        X(int i) {
            counter++;
        }
    }
    ```