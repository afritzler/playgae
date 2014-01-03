package models;

import java.util.Date;
import java.util.List;

import play.modules.siena.EnhancedModel;
import siena.Column;
import siena.DateTime;
import siena.Entity;
import siena.Generator;
import siena.Id;
import siena.Model;

/**
 * Main model class to store the votes of the users.
 */
@Entity
public class Vote extends EnhancedModel {

    @Id(Generator.AUTO_INCREMENT)
    public Long id;
	
    /**
     * Vote timestamp 
     */
    @Column("time_stamp")
    @DateTime
	public Date timeStamp;
	
	/**
	 * Remember the IP to void double submits
	 */
    @Column("submitter_ip_address")
	public String submitterIpAddress;
	
	/**
	 * The actual vote
	 */
    @Column("choice")
	public Long choice;

	/**
	 * Request user agent for statistics and validation purposes. 
	 */
    @Column("submitter_agent")
	public String submitterAgent;
	
    /**
     * Check if an IP address has been already used.
     * 
     * @param ipAddress
     * 		String representation of the request IP address
     * @return
     * 		true if a vote with this submit has been submitted
     * 		false if not
     */
	public static boolean hasAlreadyVoted(String ipAddress) {
		List<Vote> votes = Vote.all().filter("submitterIpAddress", ipAddress).fetch();
		if (votes != null && !votes.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Check if a contentant is a valid one. Avoid storing votes for non existing
	 * contestants.
	 * 
	 * @param choice
	 * @return
	 */
	public static boolean isContestantIdValid(long choice) {
		List<Contestant> contestants = Contestant.all(Contestant.class).fetch();
		if (contestants != null && !contestants.isEmpty())
			return true;
		else
			return false;
	}
	
}
