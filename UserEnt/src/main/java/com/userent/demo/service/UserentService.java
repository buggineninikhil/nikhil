package com.userent.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userent.demo.entity.UsrEntity;
import com.userent.demo.repository.RecordNotFoundException;
import com.userent.demo.repository.Userrepo;

@Service
public class UserentService {

	@Autowired
	private Userrepo repo;
	
	 public List<UsrEntity> getAllMentors()
	    {
	        List<UsrEntity> UsrList = repo.findAll();
	         
	        if(UsrList.size() > 0) {
	            return UsrList;
	        } else {
	            return new ArrayList<UsrEntity>();
	        }
	    }
	 
	   public UsrEntity getUsrById(Long id) throws RecordNotFoundException
	    {
	        Optional<UsrEntity> Usr = repo.findById(id);
	         
	        if(Usr.isPresent()) {
	            return Usr.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	     
	    public UsrEntity createOrUpdateUsr(UsrEntity entity) throws RecordNotFoundException
	    {
	        Optional<UsrEntity> Usr = repo.findById(entity.getId());
	         
	        if(Usr.isPresent())
	        {
	            UsrEntity newEntity = Usr.get();
	            newEntity.setEmail(entity.getEmail());
	            newEntity.setFirstName(entity.getFirstName());
	            newEntity.setLastName(entity.getLastName());
	 newEntity.setActive(entity.getActive());
	 newEntity.setContactNumber(entity.getContactNumber());
	 newEntity.setLinkedinUrl(entity.getLinkedinUrl());
	 newEntity.setName(entity.getName());
	 newEntity.setPassword(entity.getPassword());
newEntity.setRegCode(entity.getRegCode());
newEntity.setRole(entity.getRole());
newEntity.setYearsOfExperience(entity.getYearsOfExperience());
	 newEntity = repo.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repo.save(entity);
	             
	            return entity;
	        }
	    }
	     
	    public void deleteUsrById(Long id) throws RecordNotFoundException
	    {
	        Optional<UsrEntity> Usr = repo.findById(id);
	         
	        if(Usr.isPresent())
	        {
	            repo.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	    
	    public List<UsrEntity> loginauth(Long id,String password,String role)
	    {
	    	 Optional<UsrEntity> Usr= repo.findById(id);
	    	if(Usr.isPresent())
	    	{
	    		
	        List<UsrEntity> UsrList = repo.findByPasswordAndRole(password,role);
	        if(UsrList.isEmpty())
	        {
	        	throw new RecordNotFoundException("No employee record exist for given id");
	        }
	        else
	        {
	        	return UsrList;
	        }
	        
	    	}
	    	
	    	else
	    	{
	    		 throw new RecordNotFoundException("No employee record exist for given id");
	    	}
	    }
	    
	    
	    
	  
/*	    UsrEntity ue = new UsrEntity();
	    public UsrEntity loginVerification(String password,String Role)
	    {
	    	
	    	ue=repo.findByPasswordAndRole(password, Role);
	    	return ue;
	    	
	    	
	    }*/
	 
}
