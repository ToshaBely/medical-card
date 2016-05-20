package com.bsu.bely.medical.utils;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Role;
import com.bsu.bely.medical.entity.type.RoleType;
import org.springframework.security.core.context.SecurityContextHolder;

public class DoctorUtils {
    public static boolean hasDoctorRole(Doctor doctor, RoleType roleType) {
        for(Role role : doctor.getRoles()) {
            if (roleType.equals(role.getRole())) {
                return true;
            }
        }
        return false;
    }

    public static String getCurrentDoctorLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
