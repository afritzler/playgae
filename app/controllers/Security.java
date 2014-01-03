package controllers;

import org.apache.commons.lang.StringUtils;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
    	return true;
//        if (StringUtils.equals(username, "admin") && StringUtils.equals(password, "admin"))
//        	return true;
//        else
//        	return false;
    }
	
}
