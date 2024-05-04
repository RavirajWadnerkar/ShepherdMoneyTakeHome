package com.shepherdmoney.interviewproject.controller;

import com.shepherdmoney.interviewproject.service.UserService;
import com.shepherdmoney.interviewproject.utils.GeneralResponseEntity;
import com.shepherdmoney.interviewproject.vo.request.CreateUserPayload;
import com.shepherdmoney.interviewproject.vo.response.UserView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	@Autowired
	UserService userService;
    // TODO: wire in the user repository (~ 1 line)

    @PutMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserPayload payload) {
        // TODO: Create an user entity with information given in the payload, store it in the database
        //       and return the id of the user in 200 OK response
    	UserView userView =userService.createUpdateUser(payload);
        return  GeneralResponseEntity.generateResponse("created user!!",HttpStatus.OK,userView);
    }
    
    @GetMapping("/getallusers")
    public ResponseEntity<Object> getAllUsers() {
        // TODO: Create an user entity with information given in the payload, store it in the database
        //       and return the id of the user in 200 OK response
    	List<UserView> userView =userService.getAllUsers();
        return  GeneralResponseEntity.generateResponse("got all users successfully!!",HttpStatus.OK,userView);
    }
    
    @GetMapping("/getuser")
    public ResponseEntity<Object> getUsers(@RequestParam int userId) {
        // TODO: Create an user entity with information given in the payload, store it in the database
        //       and return the id of the user in 200 OK response
    	UserView userView =userService.getUser(userId);
        return  GeneralResponseEntity.generateResponse("got user successfully!!",HttpStatus.OK,userView);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Object> deleteUser(@RequestParam int userId) {
        // TODO: Return 200 OK if a user with the given ID exists, and the deletion is successful
        //       Return 400 Bad Request if a user with the ID does not exist
        //       The response body could be anything you consider appropriate
    	Boolean userDeleted = userService.deleteUser(userId);
    	if(userDeleted) {
    		return GeneralResponseEntity.generateResponse("user deleted successfully!!", HttpStatus.OK, userDeleted);
    	}else {
    		return GeneralResponseEntity.generateResponse("user not deleted!!", HttpStatus.OK, userDeleted);
    	}
        
    }
}
