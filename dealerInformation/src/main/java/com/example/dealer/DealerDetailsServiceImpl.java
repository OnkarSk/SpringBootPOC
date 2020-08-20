package com.example.dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerDetailsServiceImpl implements DealerDetailsService  {

    @Autowired
    private DealerDetailsRepository dealerDetailsRepository;
    
	@Override
	public Iterable<DealerDetails> findAll() {
	    
	    return dealerDetailsRepository.findAll(); 
	     
	}

	@Override
	public DealerDetails saveDealer(DealerDetails dealer) {
		 Object ob = dealerDetailsRepository.save(dealer);
		 System.out.println(ob);
		 return dealer;
	}

	@Override
	public DealerDetails findByID(Long id) {
		return dealerDetailsRepository.findById(id).get();
		
	}

	@Override
	public DealerDetails updateDealer(DealerDetails dealer) {
		dealerDetailsRepository.save(dealer);
		 return dealer;
	}

	@Override
	public void deleteByID(Long id) {
		dealerDetailsRepository.deleteById(id);
	}

}
