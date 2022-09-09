# Discrete-Mathematics-Calculator
a Discrete Mathematics Calculators for Object Oriented Programming course.

The program support three feature:
1. Creating an expression using recursion.
<img width="251" alt="1111" src="https://user-images.githubusercontent.com/103560553/189334053-e1558302-acaf-483d-89f8-01d5af0727d5.PNG">


For example, this code:

Expression e = new Not(
                  new Xor(
                     new And(
                        new Val(true),
                        new Or(
                           new Var("x"),
                           new Var("y")
                        )
                     ),
                     new Var("x")
                  )
               );


will represent this recursion tree:

<img width="252" alt="Capture" src="https://user-images.githubusercontent.com/103560553/189334162-ab17828b-1d7c-49f3-94e2-499611f45dc2.PNG">

following this class hierarchy:


<img width="408" alt="1" src="https://user-images.githubusercontent.com/103560553/189334077-4359b9d4-9f9a-445e-95a5-b34ff7e77388.PNG">


2. Nandify and Norify expressions and convert them to logically equal expressions according to this logic:

\* https://en.wikipedia.org/wiki/NAND_logic

\* https://en.wikipedia.org/wiki/NOR_logic

3.  "simplify" the expression to make it more friendly to humans, by creating a new expression which is a simplified version of the current one.

Example usage:
 ((x & F) ^ (y | F)) --> (y)
 
 following logic of this type:
 x & 1 = x

x & 0 = 0

x & x = x

x | 1 = 1

x | 0 = x

x | x = x

The result should appear in this format:



<img width="451" alt="Capture" src="https://user-images.githubusercontent.com/103560553/184178745-48a02b8c-5763-4031-a55a-8e0c2b92ac64.PNG">
