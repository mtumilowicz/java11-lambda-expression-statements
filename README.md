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
