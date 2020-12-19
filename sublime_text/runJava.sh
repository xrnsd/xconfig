#!/bin/bash
dirPathLocal=$(pwd)
cd ${JAVA_HOME}/bin
[ -f "$1.class" ] && rm "${1}.class"
for file in "${1}.java"
do
	echo "Compiling ${file}........"
	javac "${file}"
done
if [ -f "${1}.class" ];then
	echo "-----------OUTPUT-----------"
	java "${1}"
else
	echo "${1} is no exist "
fi
cd $dirPathLocal