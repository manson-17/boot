package com.example.boot.service;

import com.example.boot.entity.Role;
import com.example.boot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findRoleByName(String name) {
        return repository.findRoleByName(name);
    }

    @Override
    public List<Role> findAllRoles() {
        return repository.findAll();
    }

    @Override
    public HashSet<Role> findRolesByNames(String[] names) {
        return repository.getRolesByNames(names);
    }
}
