package models;

import siena.Entity;
import siena.Generator;
import siena.Id;
import siena.Model;

/**
 * Main contestant model.
 */
@Entity
public class Contestant extends Model {

    @Id(Generator.AUTO_INCREMENT)
    public Long id;
    
    public String name;
    
    public String description;
    
    public String contentHTML;
	
}
