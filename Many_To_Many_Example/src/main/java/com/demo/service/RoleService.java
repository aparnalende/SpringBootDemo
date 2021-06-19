package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	
	public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional
	public ResponseEntity<Object> addRole(Role role){
		
		Role newRole=new Role();
		newRole.setName(role.getName());
		newRole.setDescription(role.getDescription());
		List<Role> roleList=new ArrayList<>();
		roleList.add(newRole);
		for(int i=0;i<role.getUsers().size();i++) {
			if(!userRepository.findByEmail(role.getUsers().get(i).getEmail()).isPresent()) {
				User newUser=role.getUsers().get(i);
				newUser.setRoles(roleList);
				User savedUser=userRepository.save(newUser);
				if(!userRepository.findById(savedUser.getId()).isPresent())
					return ResponseEntity.unprocessableEntity().body("Role creation failed");
			}
			else
				return ResponseEntity.unprocessableEntity().body("User with emailId already present");
		}
		return ResponseEntity.ok("successfully created role");
	}
	
	public ResponseEntity<Object>deleteRole(Long id){
		if(roleRepository.findById(id).isPresent()) {
			if(roleRepository.getOne(id).getUsers().size()==0) {
				roleRepository.deleteById(id);
				if(roleRepository.findById(id).isPresent()) {
					 return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
				 } else return ResponseEntity.ok().body("Successfully deleted specified record");
            } else return ResponseEntity.unprocessableEntity().body("Failed to delete,  Please delete the users associated with this role");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

    /** Update a Role */
    public ResponseEntity<Object> updateRole(Long id, Role role) {
        if(roleRepository.findById(id).isPresent()){
            Role newRole = roleRepository.findById(id).get();
            newRole.setName(role.getName());
            newRole.setDescription(role.getDescription());
            Role savedRole = roleRepository.save(newRole);
            if(roleRepository.findById(savedRole.getId()).isPresent())
                return ResponseEntity.accepted().body("Role saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update Role");

        } else return ResponseEntity.unprocessableEntity().body("Specified Role not found");
    }

}
