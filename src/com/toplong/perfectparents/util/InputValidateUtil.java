package com.toplong.perfectparents.util;



public class InputValidateUtil {
	public static boolean isPhone(String phone){
		if(phone.matches("[1][34578]\\d{9}")){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNickname(String nickname){
		if(nickname.matches("[A-Za-z0-9]{6,18}")){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isUsername(String username){
		if(username.matches("^[A-Za-z_][A-Za-z0-9]{5,17}")){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isVercode(String vercode){
		if(vercode.matches("[0-9]{6}")){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isPassword(String password){
		if(password.matches("[A-Za-z0-9]{6,18}")){
			return true;
		}else{
			return false;
		}
	}
}
