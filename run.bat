@echo off
call mvn clean install -Dmaven.test.skip=true >> build.log
cd target && java -jar OOPsie.jar --illegal-access=warn 
cd ..