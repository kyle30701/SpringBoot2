package com.SpringTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringTest.entity.User;
import com.SpringTest.mapper.userMapper;
import com.SpringTest.repository.userRepository;

import jakarta.annotation.Resource;

@Service
public class userService {
	
	@Resource
    private userMapper UserMapper;
 
    public User LoginIn(String username, String password) {
        return UserMapper.getInfo(username,password);
    }

	
@Autowired
private userRepository repo;

public List<User>listAll() {
        return repo.findAll();
    }
    
    public void save(User uB) {
        repo.save(uB);
    }
    
    public User get(long id) {
        return repo.findById(id).get();
    }
    
    public void delete(long id) {
        repo.deleteById(id);
    }

 
}

