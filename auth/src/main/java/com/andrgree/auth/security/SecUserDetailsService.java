package com.andrgree.auth.security;

import com.andrgree.auth.model.SecPrivilege;
import com.andrgree.auth.model.SecRole;
import com.andrgree.auth.model.SecUser;
import com.andrgree.auth.repository.SecUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service("dbUserDetailsService")
@Transactional
public class SecUserDetailsService implements UserDetailsService {

    private final SecUserRepository secUserRepository;

    public SecUserDetailsService(final SecUserRepository secUserRepository) {
        this.secUserRepository = secUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<SecUser> accountByUsername = secUserRepository.findByUsername(username);
        if (!accountByUsername.isPresent()) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }
        final SecUser account = accountByUsername.get();
        if (account.getRoles() == null || account.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("User not authorized.");
        }
        return new User(account.getUsername(), account.getPassword(), account.isEnabled(), true, true, true, getAuthorities(account.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(final Collection<SecRole> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(final Collection<SecRole> roles) {
        final List<String> privileges = new ArrayList<String>();
        final List<SecPrivilege> collection = new ArrayList<SecPrivilege>();
        for (final SecRole role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final SecPrivilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}