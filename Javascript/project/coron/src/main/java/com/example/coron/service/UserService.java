package com.example.coron.service;

import com.example.coron.dto.AccountInfo;
import com.example.coron.entity.User;
import com.example.coron.exception.NotFoundException;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("Not found email = " + email);
        });
    }

    public void updateAccount(String email, AccountRequest request) {
        User user= userRepository.findByEmail(email).orElseThrow(()-> {
            throw new NotFoundException("Not found email: "+ email);
        });
        user.setName(request.getName());
        user.setPhone(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        userRepository.save(user);
    }

    public AccountInfo getAccountInfo(String email){
        User user= userRepository.findByEmail(email).orElseThrow(()-> {
            throw new NotFoundException("Not found email: "+ email);
        });
        AccountInfo accountInfo= AccountInfo.builder()
                .name(user.getName())
                .phoneNumber(user.getPhone())
                .address(user.getAddress()).build();
        return accountInfo;
    }
}