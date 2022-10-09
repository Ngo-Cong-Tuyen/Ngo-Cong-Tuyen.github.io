package com.example.coron.service;

import com.example.coron.dto.AccountInfo;
import com.example.coron.dto.UserDto;
import com.example.coron.entity.User;
import com.example.coron.exception.NotFoundException;
import com.example.coron.feedback.SimpleFeedback;
import com.example.coron.repository.UserRepository;
import com.example.coron.request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public Object[] findUserByEmail(String email){
        SimpleFeedback feedback = new SimpleFeedback();
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()){
            feedback.setValidate(false);
            feedback.setMessage("Not found User have email: "+ email);
            return new Object[]{feedback};
        }
        return new Object[]{feedback,user.get()};
    }



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

    public Object[] findUserById(Integer id){
        SimpleFeedback feedback= new SimpleFeedback();
        Optional<User> user= userRepository.findById(id);

        if (user.isEmpty()){
            feedback.setValidate(false);
            feedback.setMessage("Not found user have Id= "+ id);

            return new Object[]{feedback};
        }
        return new Object[]{feedback,user.get()};
    }

    public List<UserDto> getAllUserDto() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            List<String> roles = user.getRole();
            if (!roles.contains("ADMIN")) {
                UserDto userDto = UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .phone(user.getPhone())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .enabled(user.getEnabled()).build();
                userDtos.add(userDto);
            }
        });
        return userDtos;
    }

    public SimpleFeedback changeRoleEditor(Integer userId, Boolean signal) {
        SimpleFeedback feedback= new SimpleFeedback();
        Object[] userObject = findUserById(userId);
        SimpleFeedback findUserFeedback = (SimpleFeedback) userObject[0];
        if (!findUserFeedback.isValidate()) {
            return  findUserFeedback;
        }
        User user =(User) userObject[1];

        if (!user.getRole().contains("EDITOR") && signal){
            List<String> list = user.getRole();
            list.add("EDITOR");
            user.setRole(list);
        }
        if (user.getRole().contains("EDITOR") && !signal){
            user.setRole(Collections.singletonList("USER"));
        }
        userRepository.save(user);
        return feedback;
    }

    public SimpleFeedback controllerAccount(Integer userId, boolean signal) {
        SimpleFeedback feedback= new SimpleFeedback();
        Object[] userObject = findUserById(userId);
        SimpleFeedback findUserFeedback = (SimpleFeedback) userObject[0];
        if (!findUserFeedback.isValidate()) {
            return  findUserFeedback;
        }
        User user =(User) userObject[1];
        user.setEnabled(signal);
        userRepository.save(user);
        return feedback;
    }

    public Boolean checkAddress(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        String address= user.get().getAddress();
        int start = address.indexOf("(");
        int end = address.indexOf(")");
        if (start==-1|| end ==-1) return false;
        String subString = address.substring(start,end);
        List<String>  list = Arrays.asList(subString.split(","));
        if (list.size()==4) return true;
        return false;
    }
}