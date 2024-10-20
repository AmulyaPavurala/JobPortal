package com.jp.b.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.b.Entity.User;
import com.jp.b.Repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository; // Ensure you have a UserRepository

	    public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User getUserById(Long id) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        return optionalUser.orElse(null); // Return null if not found
	    }

	    public User updateUser(Long id, User userDetails) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            user.setUsername(userDetails.getUsername());
	            user.setEmail(userDetails.getEmail());
	            user.setPassword(userDetails.getPassword());
	            user.setRole(userDetails.getRole());
	            user.setFullName(userDetails.getFullName());
	            user.setPhoneNumber(userDetails.getPhoneNumber());
	            user.setProfileSummary(userDetails.getProfileSummary());
	            return userRepository.save(user);
	        } else {
	            return null; // Return null if not found
	        }
	    }

	    public boolean deleteUser(Long id) {
	        if (userRepository.existsById(id)) {
	            userRepository.deleteById(id);
	            return true; // Successfully deleted
	        } else {
	            return false; // User not found
	        }
    }
}
