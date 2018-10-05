package resources;

import java.awt.Color;

import javax.swing.BorderFactory;

public class Border {
  

	public Border() {
       Border[] border = { BorderFactory.createEtchedBorder(),
			    BorderFactory.createTitledBorder("Border types"),
			    BorderFactory.createLoweredBevelBorder(),
			    BorderFactory.createRaisedBevelBorder(),
			    BorderFactory.createEtchedBorder(),
			    BorderFactory.createLineBorder(Color.blue),
			    BorderFactory.createMatteBorder(10, 10, 10, 10, Color.blue),
			    BorderFactory.createEmptyBorder()
       };
 
  }

  
}
