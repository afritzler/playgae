package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	/**
	 * Get all contestants and render the main page.
	 */
    public static void index() {
    	
    	List<Contestant> contestants = Contestant.all(Contestant.class).fetch();
    	
        render(contestants);
    }

}