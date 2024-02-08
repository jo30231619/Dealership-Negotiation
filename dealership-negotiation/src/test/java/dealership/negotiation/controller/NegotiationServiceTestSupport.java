package dealership.negotiation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import dealership.negotiation.controller.model.DealershipData;
import dealership.negotiation.entity.Dealership;

public class NegotiationServiceTestSupport {
	
	private static final String DEALERSHIP_TABLE = "dealership";

	// @formatter:off
	private DealershipData addDealership1 = new DealershipData(
			1L,
			"Hundai of Fort Myers",
			"1234 main st sw",
			"Hatton",
			"Fl",
			"33988",
			"(410) 555-8788"
			);
	
	private DealershipData addDealership2 = new DealershipData(
			2L,
			"Hundai of Naples",
			"1234 Crane st w",
			"Oberon",
			"Fl",
			"35988",
			"(451) 666-7777"
			); 
	// @formatter:on
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NegotiationController negotiationController;
	
	protected DealershipData buildAddDealership(int which) {
		return which == 1 ? addDealership1 : addDealership2;
	}
	
	protected int rowsInLocationtable() {
		return JdbcTestUtils.countRowsInTable(jdbcTemplate, DEALERSHIP_TABLE);
	}
	
	protected DealershipData addDealership (DealershipData DealershipData) {
		Dealership dealership = DealershipData.toDealership();
		DealershipData clone = new DealershipData(dealership);
		
		clone.setDealershipId(null);
		return negotiationController.createDealership(clone);
	}
}
