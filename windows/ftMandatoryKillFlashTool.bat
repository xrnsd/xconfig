@echo off
Echo 先等待7秒。。等待启动其他软件
Echo 正在杀死进程...

taskkill /f /t /fi "imagename eq ResearchDownload.exe" 
echo.&pause
rem echo.&pause