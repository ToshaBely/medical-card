package com.bsu.bely.medical.service.login;


import com.bsu.bely.medical.dao.DoctorDAO;
import com.bsu.bely.medical.entity.login.CustomUserDetails;
import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Doctor doctor = doctorDAO.getDoctorByLogin(userName);
        if (doctor == null) {
            throw new UsernameNotFoundException("Wrong login");
        }
        List<GrantedAuthority> authorities = buildUserAuthority(doctor.getRoles());

        return new CustomUserDetails(doctor.getId(), doctor.getFirstName(), doctor.getLastName(), doctor.getLogin(), doctor.getPassword(), authorities);
    }


    private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {
        Set<GrantedAuthority> authoritySet = roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole().toString())).collect(Collectors.toSet());
        return new ArrayList<>(authoritySet);
    }
}
