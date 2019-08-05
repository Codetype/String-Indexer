## String Indexer
String Indexer maps input string by letter occurrence to words, 
which contains each letter. Current version of indexer omits different letter cases.
All words are considered only once and should be placed in alphabetical order. 
### Given example

#### Input: 
```$xslt
ala ma kota, kot koduje w Javie kota
```
#### Output:
```$xslt
a: ala, javie, kota, ma
d: koduje
e: javie, koduje
i: javie
j: javie, koduje
k: koduje, kot, kota
l: ala
m: ma
o: koduje, kot, kota
t: kot, kota
u: koduje
v: javie
w: w
```
 
### Solutions
Lets consider two solution of problem, simple sequential version and 
the other one with ConcurrentHashMap and parallel stream.
#### Sequential version
 
| Type of input | Performance time |
| :---   | :---: |
| Empty Input | 1.0 ms |
| Input with repeats | 4.0 ms |
| Input with special characters | 1.0 ms |
| Input with different letter cases| 2.0 ms |
| Long Input | 14.0 ms |
| Book text | 1.1594444 s |

#### Parallel version

| Type of input | Performance time |
| :---   | :---: |
| Empty Input | 1.0 ms |
| Input with repeats | 5.0 ms |
| Input with special characters | 4.0 ms |
| Input with different letter cases| 3.0 ms |
| Long Input | 7.0 ms|
| Book text | 0.3688266 s |
