@echo off
>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"
if '%errorlevel%' NEQ '0' (
goto UACPrompt
) else ( goto gotAdmin )
:UACPrompt
echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
echo UAC.ShellExecute "%~s0", "", "", "runas", 1 >> "%temp%\getadmin.vbs"
"%temp%\getadmin.vbs"
exit /B
:gotAdmin
if exist "%temp%\getadmin.vbs" ( del "%temp%\getadmin.vbs" )
pushd "%CD%"
CD /D "%~dp0"


set src_dir=C:\tools\RESEARCHDOWNLOAD_R17.0.0001\Bin\ImageFiles
set des_dir=X:\sp7731c_M\idh\out\target\product\sp7731c_1h10_32v4

cd /d %src_dir%

for /f %%a in ('dir /o-d /tc /b .') do (
set dirName=%%a
goto end
)
:end

echo %dirName%

rem xcopy /F /Y %des_dir%\boot.img %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\persist.img %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\sysinfo.img %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\cache.img %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\fdl1.bin %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\fdl2.bin %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\prodnv.img %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\recovery.img %src_dir%\%dirName%
rem echo f|xcopy /F /Y %des_dir%\SC7720_UMS_prime.xml %src_dir%\%dirName%\SC77xx.xml
rem xcopy /F /Y %des_dir%\u-boot.bin %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\u-boot-spl-16k.bin %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\userdata.img %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\charge_logo.bmp %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\logo480.bmp %src_dir%\%dirName%
rem xcopy /F /Y %des_dir%\system.img %src_dir%\%dirName%

rem del %src_dir%\%dirName%\boot.img
rem del %src_dir%\%dirName%\persist.img
rem del %src_dir%\%dirName%\sysinfo.img
rem del %src_dir%\%dirName%\cache.img
rem del %src_dir%\%dirName%\fdl1.bin
rem del %src_dir%\%dirName%\fdl2.bin
rem del %src_dir%\%dirName%\prodnv.img
rem del %src_dir%\%dirName%\recovery.img
rem del %src_dir%\%dirName%\SC77xx.xml
rem del %src_dir%\%dirName%\u-boot.bin
rem del %src_dir%\%dirName%\u-boot-spl-16k.bin
rem del %src_dir%\%dirName%\userdata.img
rem del %src_dir%\%dirName%\charge_logo.bmp
rem del %src_dir%\%dirName%\logo480.bmp
rem del %src_dir%\%dirName%\system.img


rem mklink /j %src_dir%\%dirName%\boot.img %des_dir%\boot.img
rem mklink /j %src_dir%\%dirName%\persist.img %des_dir%\persist.img
rem mklink /j %src_dir%\%dirName%\sysinfo.img %des_dir%\sysinfo.img
rem mklink /j %src_dir%\%dirName%\cache.img %des_dir%\cache.img
rem mklink /j %src_dir%\%dirName%\fdl1.bin %des_dir%\fdl1.bin
rem mklink /j %src_dir%\%dirName%\fdl2.bin %des_dir%\fdl2.bin
rem mklink /j %src_dir%\%dirName%\prodnv.img %des_dir%\prodnv.img
rem mklink /j %src_dir%\%dirName%\recovery.img %des_dir%\recovery.img
rem mklink /j %src_dir%\%dirName%\SC77xx.xml %des_dir%\SC7720_UMS_prime.xml
rem mklink /j %src_dir%\%dirName%\u-boot.bin %des_dir%\u-boot.bin
rem mklink /j %src_dir%\%dirName%\u-boot-spl-16k.bin %des_dir%\u-boot-spl-16k.bin
rem mklink /j %src_dir%\%dirName%\userdata.img %des_dir%\userdata.img
rem mklink /j %src_dir%\%dirName%\charge_logo.bmp %des_dir%\charge_logo.bmp
rem mklink /j %src_dir%\%dirName%\logo480.bmp %des_dir%\logo480.bmp
rem mklink /j %src_dir%\%dirName%\system.img %des_dir%\system.img


rem move %src_dir%\%dirName%\DSP_DM_G2.bin %src_dir%
rem move %src_dir%\%dirName%\nvitem.bin %src_dir%
rem move %src_dir%\%dirName%\nvitem_wcn.bin %src_dir%
rem move %src_dir%\%dirName%\SC7702_pike_modem_AndroidM.dat %src_dir%
rem move %src_dir%\%dirName%\SC8800G_pike_wcn_dts_modem.bin %src_dir%

move %src_dir%\%dirName% %src_dir%\%dirName%_%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%
mklink /h %src_dir%\%dirName% %des_dir%

echo.&pause