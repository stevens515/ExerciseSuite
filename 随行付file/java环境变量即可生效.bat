echo off

color 0a
mode con cols=60 lines=20
echo ��ǰJDK �汾:
java -version
ping 127.0.0.1 -n 2 -w 1000 > nul
echo.

:menu
echo =============================================
echo ��ѡ��Ҫ�л���jdk�汾
echo 1���л���1.6�汾
echo 2���л���1.7�汾
echo 3���л���1.8�汾
echo 4���л���1.7_win32�汾
echo 5���˳�
echo =============================================
echo.
set /p ch=�����룺
if %ch% equ 1 set javapath=%JAVA8_HOME% && goto enable
if %ch% equ 2 set javapath=%JAVA7_HOME% && goto enable
if %ch% equ 3 set javapath=%JAVA8_HOME% && goto enable
if %ch% equ 4 set javapath=%JAVA7_HOME_32% && goto enable
if %ch% equ 5 goto exit
cls
echo ��ȷ����������(%ch%)�Ƿ���ȷ��
goto menu

:enable
setx JAVA_HOME %javapath% /M
echo �Ѿ��ɹ�Ϊ���л���JDK�汾��
echo Press any key to exit...
pause >nul
exit