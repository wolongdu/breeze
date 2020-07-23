#!/bin/sh
APP_NAME=sentinel-dashboard
#jar包路径
JAR_PATH='/usr/local/work/cloud'
#jar名称
JAR_NAME=sentinel-dashboard-1.7.2.jar
#日志路径
LOG_PATH='/usr/local/work/logs'
#PID  代表是PID文件
PID=$JAR_NAME\.pid
 
#使用说明，用来提示输入参数
usage() {
    echo "Usage: sh 执行脚本.sh [start|stop|restart|status]"
    exit 1
}
 
#检查程序是否在运行
is_exist(){
  pid=`ps -ef|grep $JAR_NAME|grep -v grep|awk '{print $2}' `
  #如果不存在返回1，存在返回0    
  if [ -z "${pid}" ]; then
   return 1
  else
    return 0
  fi
}
 
#启动方法
start(){
  is_exist
  if [ $? -eq "0" ]; then
    echo ">>> $APP_NAME is already running PID=${pid} <<<"
  else
    nohup java -Dserver.port=8600 -Dcsp.sentinel.dashboard.server=localhost:8600 -Dproject.name=sentinel-dashboard -jar $JAR_PATH/$JAR_NAME >> $LOG_PATH/$APP_NAME.log 2>&1 &
    echo $! > $PID
    echo ">>> start $APP_NAME successed PID=$! <<<"
   fi
  }
 
#停止方法
stop(){
  #is_exist
  pidf=$(cat $PID)
  #echo "$pidf" 
  echo ">>> PID = $pidf begin kill $pidf <<<"
  kill $pidf
  rm -rf $PID
  sleep 2
  is_exist
  if [ $? -eq "0" ]; then
    echo ">>> PID = $pid begin kill -9 $pid  <<<"
    kill -9  $pid
    sleep 2
    echo ">>> $APP_NAME process stopped <<<" 
  else
    echo ">>> $APP_NAME is not running <<<"
  fi 
}
 
#输出运行状态
status(){
  is_exist
  if [ $? -eq "0" ]; then
    echo ">>> $APP_NAME is running PID is ${pid} <<<"
  else
    echo ">>> $APP_NAME is not running <<<"
  fi
}
 
#重启
restart(){
  stop
  start
}
 
#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  *)
    usage
    ;;
esac
exit 0