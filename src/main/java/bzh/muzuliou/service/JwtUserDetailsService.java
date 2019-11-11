package bzh.muzuliou.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import bzh.muzuliou.entity.Role;
import bzh.muzuliou.entity.UserInfo;
import bzh.muzuliou.reprository.UserInfoRepository;


@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = userInfoRepository.findByUsername(username);
        if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
    	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    	}

    	private Set getAuthority(UserInfo user) {
            Set authorities = new HashSet<>();
    		user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
    		});
    		return authorities;
    	    
    	}
    	
    	  public UserInfo getUserByUsername(String username) throws SQLException  {

    		    UserInfo user = userInfoRepository.findByUsername(username);
    	        if(user == null){
    				throw new SQLException("Invalid username or password.");
    			}
    	    	return user;
    	    	}

    	    	
}

