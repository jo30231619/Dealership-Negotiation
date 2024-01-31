package dealership.negotiation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dealership.negotiation.controller.model.DealershipData;
import dealership.negotiation.dao.DealershipDao;
import dealership.negotiation.entity.Dealership;

@Service
public class NegotiationService {
	
	@Autowired DealershipDao dealershipDao;
	
	@Transactional(readOnly = false)
	public DealershipData saveDealership(DealershipData dealershipData) {
		Dealership dealership = dealershipData.toDealership();
		Dealership dbDealership = dealershipDao.save(dealership);
		
		return new DealershipData(dbDealership);
	}

}
