@echo off
call mvn clean install >> build.log
cd target && java -jar OOPsie.jar
cd ..