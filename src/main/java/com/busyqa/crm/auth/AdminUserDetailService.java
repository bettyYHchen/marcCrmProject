package com.busyqa.crm.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserDetailService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AuthGroupRepository authGroupRepository;

    public AdminUserDetailService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(username);
        if(null==user) {
            throw new UsernameNotFoundException("cannot find username " + username);

        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
        return new AdminUserPrincipal(user, authGroups);
    }
}
