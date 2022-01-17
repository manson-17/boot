package com.example.boot.service;

import com.example.boot.entity.Role;
import com.example.boot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    HashSet<Role> findRolesByNames(String[] names);
}
