package models;

import play.modules.siena.EnhancedModel;
import siena.Entity;
import siena.Generator;
import siena.Id;
import siena.Model;

/**
 * Main contestant model.
 */
@Entity
public class Contestant extends EnhancedModel {

    @Id(Generator.AUTO_INCREMENT)
    public Long id;
    
    public String name;
    
    public String description;
    
    public String contentHTML;
    
//    public static boolean exists(long id) {
//    	Contestant contestant = Contestant.findById(id);
//    	if (contestant != null)
//    		return true;
//    	else
//    		return false;
//    }
	
}
