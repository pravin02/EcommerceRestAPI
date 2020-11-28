package org.pk.ecommerce.controllers;

import org.pk.ecommerce.Constants;
import org.pk.ecommerce.entities.UserDetails;
import org.pk.ecommerce.models.CustomResponse;
import org.pk.ecommerce.models.UserRole;
import org.pk.ecommerce.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

/**
 * @author Pravin P Patil
 */
@RestController
@RequestMapping("/api/users")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userService;


    /**
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public ResponseEntity<CustomResponse> getUserByUserId(@PathVariable("userId") Long userId) {
        Optional<UserDetails> userDetails = this.userService.findUserByUserId(userId);
        CustomResponse customResponse = new CustomResponse();
        if (userDetails.isPresent()) {
            customResponse.setStatus(true);
            customResponse.setData(userDetails.get());
            return ResponseEntity.ok(customResponse);
        } else {
            customResponse.setMessage("User not found by this user id " + userId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);
        }
    }


    /**
     * @param userDetails
     * @return
     */
    @PostMapping
    public ResponseEntity<CustomResponse> saveUser(@RequestBody UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomResponse(false, Constants.FAILURE_MESSAGE));
        }

        userDetails.setUserRole(UserRole.CUSTOMER);
        userDetails = this.userService.addOrUpdateUser(userDetails);

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomResponse(false, Constants.FAILURE_MESSAGE));
        }
        return ResponseEntity.ok(new CustomResponse(true, Constants.SUCCESS_MESSAGE));
    }
}
