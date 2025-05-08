@echo off

:: Change directory to the project root where pom.xml is located
cd /d C:\Users\HazeX\Documents\GitHub\Spring-Projects\Backend-Spring-Bootcamp\graduation-project\toda-backend\user-mgt

:: Run Maven without the liquibase profile
CALL mvn process-sources "-Dcurrent.environment=local"

pause