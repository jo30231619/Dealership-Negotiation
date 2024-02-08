package dealership.negotiation.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import dealership.negotiation.DealershipNegotiationApplication;
import dealership.negotiation.controller.model.DealershipData;

@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = DealershipNegotiationApplication.class)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"})
@SqlConfig(encoding = "utf-8")
class DealershipNegotiationTest extends NegotiationServiceTestSupport {

	@Test
	void testAddDealership() {
		// Given: A dealership request
		DealershipData request = buildAddDealership(1);
		DealershipData expected = buildAddDealership(1);
		// When: the dealership is added to the dealereship table
		DealershipData actual =  addDealership(request);
		// Then: the dealership returned is what is expected 
		assertThat(actual).isEqualTo(expected);
		// And: there is one row in the dealership table.
		assertThat(rowsInLocationtable()).isOne();
	}
}
