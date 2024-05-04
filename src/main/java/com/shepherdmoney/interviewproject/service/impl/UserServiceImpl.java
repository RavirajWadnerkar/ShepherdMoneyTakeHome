package com.shepherdmoney.interviewproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shepherdmoney.interviewproject.model.User;
import com.shepherdmoney.interviewproject.repository.UserRepository;
import com.shepherdmoney.interviewproject.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import com.shepherdmoney.interviewproject.vo.request.CreateUserPayload;
import com.shepherdmoney.interviewproject.vo.response.UserView;

import jakarta.annotation.PostConstruct;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	private ModelMapper modelMapper;
	@PostConstruct
    public void initializeModelMapper() {
        modelMapper = new ModelMapper();
    }
	@Override
	public UserView createUpdateUser(CreateUserPayload createUserPayload) {
		User user = modelMapper.map(createUserPayload, User.class);
	    
	    // Check if the user exists based on the ID
	    if (user.getId() != 0) {
	        Optional<User> userOptional = userRepository.findById(user.getId());
	        if (userOptional.isEmpty()) {
	            return null; // User with the provided ID not found
	        }
	    }
	    
	    // Save the user to the repository
	    User savedUser = userRepository.save(user);
	    
	    // Map the saved user to UserView
	    return modelMapper.map(savedUser, UserView.class);
		
	}
	@Override
	public List<UserView> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserView> userViewList = userList.stream()
                .map(user -> modelMapper.map(user, UserView.class))
                .collect(Collectors.toList());

		return userViewList;
	}
	@Override
	public UserView getUser(int userId) {
		if(userId > 0) {
		Optional<User> user = userRepository.findById(userId);
		UserView userView = modelMapper.map(user.get(), UserView.class);

		return userView;
		}
		else {
			return null;
		}
	}
	@Override
	public Boolean deleteUser(int userId) {
		if (userRepository.existsById(userId)) {
	        userRepository.deleteById(userId);
	        return true; // Deletion successful
	    } else {
	        return false; // User not found
	    }
	}

}
