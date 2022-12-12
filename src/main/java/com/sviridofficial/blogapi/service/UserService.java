package com.sviridofficial.blogapi.service;

import com.sviridofficial.blogapi.model.user.User;
import com.sviridofficial.blogapi.payload.ApiResponse;
import com.sviridofficial.blogapi.payload.InfoRequest;
import com.sviridofficial.blogapi.payload.UserIdentityAvailability;
import com.sviridofficial.blogapi.payload.UserProfile;
import com.sviridofficial.blogapi.payload.UserSummary;
import com.sviridofficial.blogapi.security.UserPrincipal;

public interface UserService {

	UserSummary getCurrentUser(UserPrincipal currentUser);

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, UserPrincipal currentUser);

	ApiResponse deleteUser(String username, UserPrincipal currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}