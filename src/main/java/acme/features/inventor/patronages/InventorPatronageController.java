package acme.features.inventor.patronages;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronages.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronageController extends AbstractController<Inventor, Patronage>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorPatronageListService		listService;

		@Autowired
		protected InventorPatronageShowService		showService;
		
		@Autowired
		protected InventorPatronageAcceptService	acceptService;
		
		@Autowired
		protected InventorPatronageDenieService		denieService;
		
		// Constructors -----------------------------------------------------------

		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
			
			super.addCommand("accept", "update", this.acceptService);
			super.addCommand("denie", "update", this.denieService);
		}
		

}
