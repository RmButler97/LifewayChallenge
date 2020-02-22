package com.ryanbutler.resttest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanbutler.resttest.bean.Result;
import com.ryanbutler.resttest.bean.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class RestTestApplication {

	public static void main(String[] args) {
		// create object mapper instance
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			// read json file and convert to user object
			User user[] = mapper.readValue(new File("data.json"), User[].class);
			
			// create a result object
			Result resultObj[] = new Result[user.length];
			
			// initialize count array to keep count of words in current field
			int count[] = new int [user.length];
			// initialize total to keep track of running total of words
			int total = 0;
			String tempId;
			String tempMsg;
			int match;
			char c;
			
			
			for (int i=0; i<user.length; i++) {
				tempId = user[i].getId();
				match = 0;
				for (int j=0; j<i; j++) {
					if (tempId.equals(user[j].getId())) {
						match++;
					}
				}
				
				// if the id does not match any previous ids
				if (match == 0) {
					tempMsg = user[i].getMessage();
					
					// if message is not empty, set count to 1
					if (tempMsg.charAt(0) != ' ') {
						count[i] = 1;
					}
					
					for (int x=0; x<tempMsg.length(); x++) {
						// convert string to char at index x
						c = tempMsg.charAt(x);
						
						// if there is a space, increase count
						if (c == ' ') {
							count[i]++;
						}
					}
				}
			}
			
			
			for (int x=0; x<user.length; x++) {
				total += count[x];
				resultObj[x] = new Result(total);
				
				// write resultObj object to result.json file
				mapper.writeValue(new File("result.json"), resultObj);
				
				System.out.println("count = " + total);
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
