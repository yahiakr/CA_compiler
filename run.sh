#!/bin/sh

javacc AFCOMPOSER.jj
mv *.java ./Classes
javac -d bin ./Classes/*.java
cd bin
java AFCOMPOSER