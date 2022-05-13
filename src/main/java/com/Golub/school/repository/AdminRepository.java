package com.Golub.school.repository;

import com.Golub.school.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByIdadmin(int id);

    List<Admin> findAdminBySurname(String surname);

    List<Admin> findAdminByName(String name);

    Admin findAdminByUsers_Iduser(int id);
}
