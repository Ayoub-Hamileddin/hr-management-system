package com.backend.backend.controller;


import com.backend.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final UserService userService;


//    @PostMapping("/set-password")
//    public ResponseEntity<String> activateEmployeeAccount(
//            @RequestBody  SetPasswordRequest setPasswordRequest
//    )
//    {
//        userService.setPassword(setPasswordRequest);
//       return ResponseEntity.ok("Password set successfully") ;
//    }
}
