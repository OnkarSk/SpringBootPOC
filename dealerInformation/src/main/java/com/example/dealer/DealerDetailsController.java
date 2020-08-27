package com.example.dealer;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealerDetailsController {
    @Autowired
    private DealerDetailsServiceImpl  dealerDetailsServiceImpl;
    Logger logger = LoggerFactory.getLogger(DealerDetailsController.class);
    
    @GetMapping(value = "/dealer-search", produces = MediaType.APPLICATION_XML_VALUE) 
    public Iterable<DealerDetails> findAllXML() {
       Iterable<DealerDetails> dealers = dealerDetailsServiceImpl.findAll();
       return dealers;
    }

    @GetMapping(value = "dealer") 
    public Iterable<DealerDetails> findAll() {
       Iterable<DealerDetails> dealers = dealerDetailsServiceImpl.findAll();
       return dealers;
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping("/dealer") 
    public ResponseEntity saveDealer(@RequestBody DealerDetails dealer) throws CustomException {
    	ModelMapper modelMapper = new ModelMapper();
          try {
       	   DealerDetails dealerResponse = modelMapper.map(dealerDetailsServiceImpl.saveDealer(dealer), DealerDetails.class);
       	  System.out.println(dealerResponse);
       	   return new ResponseEntity<>( HttpStatus.CREATED) ;
       	   
          }
          catch(Exception e) {
           logger.error("Internal Server Error");
       	   throw new CustomException();
          }

    }
    
    @GetMapping("/dealer/{id}") 
    public ResponseEntity<DealerDetails> findByID(@PathVariable("id") Long id)  throws CustomException{
       ModelMapper modelMapper = new ModelMapper();
       try {
    	   DealerDetails dealerResponse = modelMapper.map(dealerDetailsServiceImpl.findByID(id), DealerDetails.class);
    	  
    	   return new ResponseEntity<>(dealerResponse, HttpStatus.FOUND) ;
    	   
       }
       catch(Exception e) {
    	   logger.error("ID not exist");
    	   throw new CustomException();
       }

       
    }
    
    @SuppressWarnings("rawtypes")
	@PutMapping("/dealer") 
    public ResponseEntity updateDealer(@RequestBody DealerDetails dealer) throws CustomException {
    	ModelMapper modelMapper = new ModelMapper();
        try {
     	   DealerDetails dealerResponse = modelMapper.map(dealerDetailsServiceImpl.updateDealer(dealer), DealerDetails.class);
     	  System.out.println(dealerResponse);
     	   return new ResponseEntity<>( HttpStatus.CREATED) ;
     	   
        }
        catch(Exception e) {
        	logger.error("Record not created");
     	   throw new CustomException();
        }

    }
    
    @DeleteMapping("/dealer/{id}") 
    public void deleteByID(@PathVariable("id") Long id) throws CustomException {
    	try {
    		 dealerDetailsServiceImpl.deleteByID(id);
    	}
      catch(Exception e) {
    	  logger.error("Record not found");
    	  throw new CustomException();
      }
    }
    

}