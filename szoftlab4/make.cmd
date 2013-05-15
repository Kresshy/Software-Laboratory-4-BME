::@echo off

:: Beallitasok
set bin=bin\
set src=src\
set files=hu\miracleworkers\
set pkgmodel=model\*
set pkgcontroller=controller\*
set pkgview=view\*
set pkgswing=swing\*
set class=hu.miracleworkers.controller.Main

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
javac -d %bin% %src%%files%%pkgmodel% %src%%files%%pkgcontroller% %src%%files%%pkgview% %src%%files%%pkgswing%
echo Forrasfajlok leforditva.

:: Futtatas
echo Futtatas...
start java -cp %bin% %class%
echo Futtatas kesz.

pause
