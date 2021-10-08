package com.dhacbang.DaikichiPathVar.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DaikichiPathVar_Controllers {
	
	@RequestMapping("/")
	public String index() {	
			return "Hello World";
	}

    @RequestMapping("/travel/{city}")
    public String greeting(@PathVariable("city") String city) {
    	
    	return "Congrats! You will soon travel to," + city + "!";
    }
    
    @RequestMapping("/lotto/{num}")
    public String greeting(@PathVariable("num") int num) {
    	if((num % 2) == 0) {
    		
    	return "You will take a grand journey in the near future, but be weary of tempting offers";
    	
    	} else {
    		
    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
    		
    	}
    }
}

