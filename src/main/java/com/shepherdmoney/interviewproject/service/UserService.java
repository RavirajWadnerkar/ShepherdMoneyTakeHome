package com.shepherdmoney.interviewproject.service;

import java.util.List;

import com.shepherdmoney.interviewproject.vo.request.CreateUserPayload;
import com.shepherdmoney.interviewproject.vo.response.UserView;

public interface UserService {
public UserView createUpdateUser(CreateUserPayload createUserPayload);
public List<UserView> getAllUsers();
public UserView getUser(int userId);
public Boolean deleteUser(int userId);
}
