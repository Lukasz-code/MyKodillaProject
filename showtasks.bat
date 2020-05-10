call runcrud
if "%ERRORLEVEL%" == "0" goto startchrome
echo.
echo SHOWTASKS has errors - breaking work
goto fail

:startchrome

start chrome.exe open  http://localhost:8080/crud/v1/task/getTasks

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
