package com.example.boot.repository;

import com.example.boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByName(String name);

    default HashSet<Role> getRolesByNames(String[] names) {
        Set<Role> roleSet = Arrays.stream(names).map(s -> findRoleByName(s)).collect(Collectors.toSet());
        return (HashSet<Role>) roleSet;
    }

}
