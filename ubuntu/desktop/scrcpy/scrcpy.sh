#!/bin/bash

ftAdbConnectCheck()
{
    local deviceIdList=($(adb devices |grep -v "List of devices attached" |awk '{print $1}'))
    local deviceIdListUniq=($(echo "${deviceIdList[@]}"  | sed 's/ /\n/g' |sort |uniq))
    local deviceCount=${#deviceIdList[@]}
    local deviceCountUniq=${#deviceIdListUniq[@]}
    
    (( $deviceCount != 0 )) && (( $deviceCountUniq != 0 ))  && (( $deviceCount != $deviceCountUniq )) && \
        ftEcho "警告" "存在多个同ID设备,请手动移除设备"&& adb devices && return 1
        
    (( $deviceCount == 0 )) && ftEcho "提示" "未检测到设备，请确认连接是否正常" && return 1
    
    return 0
}

ftEcho(){
    local title=$1
    local connect=$2

    notify-send ["${title}"] "${connect}"
}

ftExce(){
    if ftAdbConnectCheck;then
        local timeStart=$(date +%s)
        local result=$(ADB=/home/xian/tools/android_sdk/platform-tools/adb /snap/bin/scrcpy)
        local timeEnd=$(date +%s)
        local timeTake=$(( timeEnd - timeStart ))
        (( $timeTake < 2 )) && ftEcho "错误" "${result:-'未知错误，请检查scrcpy是否正常'}"
    fi
}

ftExce
