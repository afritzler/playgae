package models;

import java.util.Date;

import siena.Entity;
import siena.Generator;
import siena.Id;
import siena.Model;

/**
 * Main model class to store the votes of the users.
 */
@Entity
public class Vote extends Model {

    @Id(Generator.AUTO_INCREMENT)
    public Long id;
	
	public Date timeStamp;
	
	public String submitterIpAddress;
	
	public String choice;
	
}