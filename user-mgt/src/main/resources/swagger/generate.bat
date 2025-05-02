@echo off

:: Change to the project root directory (where pom.xml exists)
cd /d %~dp0
cd ../../../..

CALL mvn clean generate-sources
:: Run Maven code generation (without the missing profile)
CALL mvn generate-sources

pause
