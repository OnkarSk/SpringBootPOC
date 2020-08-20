package com.example.dealer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealerDetailsController {
    @Autowired
    private DealerDetailsServiceImpl  dealerDetailsServiceImpl;
  
    @GetMapping("/dealer") 
    public Iterable<DealerDetails> findAll() {
       Iterable<DealerDetails> dealers = dealerDetailsServiceImpl.findAll();
       return dealers;
    }

    @PostMapping("/dealer") 
    public DealerDetails saveDealer(@RequestBody DealerDetails dealer) {
    	ModelMapper modelMapper = new ModelMapper();
    	DealerDetails dealerResponse = modelMapper.map(dealerDetailsServiceImpl.saveDealer(dealer), DealerDetails.class);
       return dealerResponse;
    }
    
    @GetMapping("/dealer/{id}") 
    public DealerDetails findByID(@PathVariable("id") Long id) {
       ModelMapper modelMapper = new ModelMapper();
       DealerDetails dealerResponse = modelMapper.map(dealerDetailsServiceImpl.findByID(id), DealerDetails.class);
       return dealerResponse;
    }
    
    @PutMapping("/dealer") 
    public DealerDetails updateDealer(@RequestBody DealerDetails dealer) {
       ModelMapper modelMapper = new ModelMapper();
       DealerDetails dealerResponse = modelMapper.map(dealerDetailsServiceImpl.updateDealer(dealer), DealerDetails.class);
       return dealerResponse;
    }
    
    @DeleteMapping("/dealer/{id}") 
    public void deleteByID(@PathVariable("id") Long id) {
       dealerDetailsServiceImpl.deleteByID(id);
    }
}