package com.mydiscord.Controllers;

import com.mydiscord.Exceptions.AccountPayloadInformationAlreadyExistsException;
import com.mydiscord.Exceptions.CannotCreateAccountException;
import com.mydiscord.Models.Role;
import com.mydiscord.Models.RoleName;
import com.mydiscord.Models.User;
import com.mydiscord.Payloads.AccountPayload;
import com.mydiscord.Security.JwtProvider;
import com.mydiscord.Security.JwtResponse;
import com.mydiscord.Services.AccountService;
import com.mydiscord.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AccountPayload account) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountPayload account) throws AccountPayloadInformationAlreadyExistsException, CannotCreateAccountException {
        if (validateEmail(account.getEmail()) && validateUsername(account.getUsername())) {
            User user = createUser(account);
            user.setRoles(setDefaultListRoles());

            accountService.store(user);
            return ResponseEntity.ok(user);
        }
        throw new CannotCreateAccountException("Something went wrong during the creation of account.");
    }

    private User createUser(AccountPayload accountPayload) {
        return new User(accountPayload.getEmail(), accountPayload.getUsername(), encoder.encode(accountPayload.getPassword()));
    }

    private Set<Role> setDefaultListRoles() {
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findByName((RoleName.ROLE_USER)).orElseThrow(() -> new RuntimeException("USER_ROLE wasn't found. (" + RoleName.ROLE_USER + ")"));
        roles.add(role);
        return roles;
    }

    private boolean validateEmail(String email) throws AccountPayloadInformationAlreadyExistsException {
        if (!accountService.existsByEmail(email)) {
            return true;
        } else {
            throw new AccountPayloadInformationAlreadyExistsException("Email is in used.");
        }
    }

    private boolean validateUsername(String username) throws AccountPayloadInformationAlreadyExistsException {
        if (!accountService.existsByUsername(username)) {
            return true;
        } else {
            throw new AccountPayloadInformationAlreadyExistsException("Username is in used.");
        }
    }
}
