@echo off

:: Beallitasok
set bin=bin\
set src=src\
set files=hu\miracle\workers\*
set class=hu.miracle.workers.Main

:: Kepernyotorles
cls

:: Konyvtarvaltas
cd /d %~dp0

:: Korabbi fajlok eltavolitasa
echo Korabbi fajlok eltavolitasa...
rd /q /s %bin%
md %bin%

:: Forditas
echo Forditas...
javac -d %bin% %src%%files%
echo Forrasfajlok leforditva.

:: Futtatas
echo Futtatas...
start java -cp %bin% %class%
echo Futtatas kesz.

pause
