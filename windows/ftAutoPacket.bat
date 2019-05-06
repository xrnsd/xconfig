@echo off
set src_dir=C:\tools\RESEARCHDOWNLOAD_R17.0.0001\Bin\ImageFiles
set des_dir=X:\sp7731c_M\idh\out\target\product\sp7731c_1h10_32v4

cd /d %src_dir%

for /f %%a in ('dir /o-d /tc /b .') do (
set dirName=%%a
goto end
)
:end

echo %dirName%

xcopy /F /Y %des_dir%\boot.img %src_dir%\%dirName%
xcopy /F /Y %des_dir%\persist.img %src_dir%\%dirName%
xcopy /F /Y %des_dir%\sysinfo.img %src_dir%\%dirName%
xcopy /F /Y %des_dir%\cache.img %src_dir%\%dirName%
xcopy /F /Y %des_dir%\fdl1.bin %src_dir%\%dirName%
xcopy /F /Y %des_dir%\fdl2.bin %src_dir%\%dirName%
xcopy /F /Y %des_dir%\prodnv.img %src_dir%\%dirName%
xcopy /F /Y %des_dir%\recovery.img %src_dir%\%dirName%
echo f|xcopy /F /Y %des_dir%\SC7720_UMS_prime.xml %src_dir%\%dirName%\SC77xx.xml
xcopy /F /Y %des_dir%\u-boot.bin %src_dir%\%dirName%
xcopy /F /Y %des_dir%\u-boot-spl-16k.bin %src_dir%\%dirName%
xcopy /F /Y %des_dir%\userdata.img %src_dir%\%dirName%
xcopy /F /Y %des_dir%\charge_logo.bmp %src_dir%\%dirName%
xcopy /F /Y %des_dir%\logo480.bmp %src_dir%\%dirName%
xcopy /F /Y %des_dir%\system.img %src_dir%\%dirName%

rem echo.&pause