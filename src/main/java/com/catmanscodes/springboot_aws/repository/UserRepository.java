package com.catmanscodes.springboot_aws.repository;

import com.catmanscodes.springboot_aws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
