package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 *
 * Main application controller
 *
 */
public class Application extends Controller {

	/**
	 * Get all contestants and render the main page.
	 */
    public static void index() {
    	render();
    }

}