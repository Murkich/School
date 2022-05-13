package com.Golub.school.service;

import com.Golub.school.entity.Admin;
import com.Golub.school.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findAdminByIduser(int id) { return adminRepository.findAdminByUsers_Iduser(id);}

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public List<Admin> findAdminByName(String name) {
        return adminRepository.findAdminByName(name);
    }

    public List<Admin> findAdminBySurname(String surname) {
        return adminRepository.findAdminBySurname(surname);
    }

    public Admin findAdminById(int id) {
        return adminRepository.findAdminByIdadmin(id);
    }

    public void deleteAdmin(Admin admin) {
        adminRepository.delete(admin);
    }
}
