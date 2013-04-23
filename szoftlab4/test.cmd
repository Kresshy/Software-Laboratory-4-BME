@echo off

:: Beallitasok
set bin=bin\
set files=test\
set class=hu.miracle.workers.Main

:: Kepernyotorles
cls

:: Konyvtarvaltas
cd /d %~dp0

:: Tesztfuttatas
java -cp %bin% %class% < %files%%1

pause
