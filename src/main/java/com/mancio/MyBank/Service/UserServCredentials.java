package com.mancio.MyBank.Service;

import com.mancio.MyBank.dao.UserDao;
import com.mancio.MyBank.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServCredentials implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServCredentials.class);

    @Autowired
    private UserDao user_dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = user_dao.findByMail(username);
        if (null == user) {
            LOG.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return user;
    }
}
