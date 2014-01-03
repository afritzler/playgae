package controllers;

import java.util.List;

import play.mvc.Controller;
import models.Contestant;
import models.Vote;
import controllers.CRUD.For;

@For(Contestant.class)
public class Contestants extends CRUD {
	
	public static void listContestants() {
    	List<Contestant> contestants = Contestant.all(Contestant.class).fetch();
    	boolean hasVoted = false;
    	
		// check if IP addess has been used yet. If so ignore vote
		String requestIP = request.remoteAddress;
		//hasVoted = Vote.hasAlreadyVoted(requestIP);
    	
        render(contestants, hasVoted);
	}
	
}
