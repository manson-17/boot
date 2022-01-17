package com.example.boot.service;

import com.example.boot.entity.Role;
import com.example.boot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;


    @Override
    public List<Role> findAllRoles() {
        return repository.findAll();
    }

    @Override
    public HashSet<Role> findRolesByNames(String[] names) {
        Set<Role> roleSet = new HashSet<>();
        for (String name : names)
            if (name.equals("ROLE_ADMIN")){
                roleSet.add(findAllRoles().get(0));
            }
            else if (name.equals("ROLE_USER")){
                roleSet.add(findAllRoles().get(1));
            }
        return (HashSet<Role>) roleSet;
    }
}
