package controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import managers.ResultManager;
import managers.ResultManager.ResultRow;
import models.Vote;
import play.Logger;
import play.db.Model;
import play.mvc.Controller;
import play.mvc.Http.Header;
import play.mvc.With;
import controllers.CRUD.For;

@For(Vote.class)
public class Votes extends CRUD {

	/**
	 * Main vote controller accepting the artists name. Votes
	 * are only accepted if the IP address hasn't been used yet.
	 * 
	 * @param choice
	 */
	public static void vote(long choice) {		
		// check if IP address has been used yet. If so ignore vote
		String requestIP = request.remoteAddress;

//		if (Vote.hasAlreadyVoted(requestIP))
//			forbidden("You have already voted!");

		// get user agent
		Map<String, Header> requestHeader = request.headers;
		String requestAgent = "";
		if (requestHeader != null) {
			Header requestAgentHeader = requestHeader.get("user-agent");
			if (requestAgentHeader != null)
				requestAgent = requestAgentHeader.value();
		}
		
		// check if the choice is valid -> a valid artist ID exists
		if (!Vote.isContestantIdValid(choice)) 
			forbidden("No contestant found with this ID!");
		
		// store vote in DB
		Vote newVote = new Vote();
		newVote.choice = choice;
		newVote.timeStamp = new Date();
		newVote.submitterIpAddress = requestIP;
		newVote.submitterAgent = requestAgent;
		newVote.save();
		
		Logger.debug("User voted for contestant with ID %s from IP %s.", choice, requestIP);
		
		// render result page
		render();
	}
	
	/**
	 * Renders the overall result.
	 */
	public static void compactResults() {
		ResultManager resultManger = new ResultManager();
		List<ResultRow> results = resultManger.calculateResults();
		render(results);
	}
	
	public static void results() {
		ResultManager resultManger = new ResultManager();
		List<ResultRow> results = resultManger.calculateResults();
		render(results);
	}
	
}
