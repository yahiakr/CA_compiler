#!/bin/sh

javacc Simple1.jj
mv *.java ./Classes
javac -d bin ./Classes/*.java
cd bin
java Simple1

rm *.class