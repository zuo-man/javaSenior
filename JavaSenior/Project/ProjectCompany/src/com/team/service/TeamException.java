package com.team.service;

/**
 * @Description	自定义异常类
 * @version
 * @date 2021年10月3日下午4:52:47
 */

public class TeamException extends Exception{//继承与Exception，遍历运行异常，遍历时也会报错
	 static final long serialVersionUID = -3387516993124229948L;
	 
	 public TeamException() {
		 super();
	 }
	 
	 public TeamException(String msg) {
		 super(msg);
	 }

}
