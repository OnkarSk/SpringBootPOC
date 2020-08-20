package com.example.dealer;

public interface DealerDetailsService {

	 public Iterable<DealerDetails> findAll(); 
	 public DealerDetails saveDealer(DealerDetails dealer); 
	 public DealerDetails findByID(Long id);
	 public DealerDetails updateDealer(DealerDetails dealer); 
	 public void deleteByID(Long id);
}
