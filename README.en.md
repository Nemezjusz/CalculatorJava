# Java Calculator

Implementation of a calculator based on the following rules:

|           |operator | digit | equal sign | Clear |
------------|---------|-------|------------|-------|
operator    | a       | b     | c          | d     |
digit       | e       | f     | g          | d     |
equal sign  | h       | i     | j          | d     |
Clear       | d       | d     | d          | d     |  


a)  operator - operator:   a new operator overrides the old one - this does not change the value of the arguments;

b)  operator - digit:   a new digit will be inserted as a component of the value of the second argument of the operator;

c)  operator - equal sign:  we calculate the value of the expression as:

[value of the first argument]  operator  [value of the first argument]

d)  we clear all operator values - restoring the calculator's initial state;

e)  we set the first argument and save the operator;

f)  we continue to retrieve values for the same argument - the next digits of the same number;

g)  if an operator was saved, we perform the operation and save the result;

h)  the current result becomes the first argument, and we save the operator.

i)  we clear previous settings, start the calculation from the beginning, the digit starts retrieving components of the first argument number.

j)  we repeat the last operation if there was one, if not, then no change.

More details and examples of operation can be found at: http://programowanie.orzechowski.it/dodk.html


## GUI
<img width="322" alt="Screenshot 2023-12-05 at 14 37 23" src="https://github.com/Nemezjusz/KalkulatorJava/assets/50834734/8a4c1769-1f24-484c-9527-477777d1f98f">