package models;

import java.util.Date;

import siena.Model;

/**
 * Main model class to store the votes of the users.
 */
public class Vote extends Model {

	public Date timeStamp;
	
	public String submitterIpAddress;
	
	public String choice;
	
}
