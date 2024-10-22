package com.learn;

import com.learn.liquibase.database.entity.Role;
import com.learn.liquibase.database.entity.RoleStatus;
import com.learn.liquibase.database.entity.User;
import com.learn.liquibase.database.repositore.Impl.RoleRepositoryImpl;
import com.learn.liquibase.database.repositore.Impl.UserRepositoryImpl;
import com.learn.liquibase.database.repositore.RoleRepository;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Main {
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(String[] args) {
        RoleRepository roleRepository = new RoleRepositoryImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();

        System.out.println("Saving role ADMIN");
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        adminRole.setType(RoleStatus.ADMIN);
        roleRepository.create(adminRole);

        System.out.println("Saving role USER");
        Role userRole = new Role();
        userRole.setName("USER");
        userRole.setType(RoleStatus.USER);
        roleRepository.create(userRole);

        System.out.println("Saving role GUEST");
        Role guestRole = new Role();
        guestRole.setName("GUEST");
        guestRole.setType(RoleStatus.GUEST);
        roleRepository.create(guestRole);

        System.out.println("Saving role SUPER_ADMIN");
        Role superAdminRole = new Role();
        superAdminRole.setName("SUPER_ADMIN");
        superAdminRole.setType(RoleStatus.SUPER_ADMIN);
        roleRepository.create(superAdminRole);

        System.out.println("Saving User 1");
        User user = new User();
        user.setUsername("zhangsan");
        user.setPhoneNumber("1234567890");
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole, userRole));
        userRepository.create(user);

        System.out.println("Saving User 2");
        User userSecond = new User();
        userSecond.setUsername("Second user");
        userSecond.setPhoneNumber("0987654321");
        user.setEmail("test@gmail.com");
        user.setRoles(Arrays.asList(superAdminRole, guestRole));
        userRepository.create(userSecond);

        List<User> users = userRepository.findAll();
        User firstUser = users.getFirst();
        userRepository.findById(firstUser.getId()).ifPresentOrElse(System.out::println, () -> System.out.println("No user found"));

        System.out.println("\nFind user by non-existing ID:");
        userRepository.findById(100L).ifPresentOrElse(System.out::println, () -> System.out.println("No user found"));
    }
}
