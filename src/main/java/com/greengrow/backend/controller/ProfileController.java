package com.greengrow.backend.controller;

import com.greengrow.backend.dto.ProfileDTO;
import com.greengrow.backend.mapping.ProfileMapper;
import com.greengrow.backend.response.ProfileResponse;
import com.greengrow.backend.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/api/green-grow/v1/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @GetMapping("{id}")
    public ResponseEntity<ProfileResponse> getProfileById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(profileMapper.toResponse(profileService.fetchById(id)), HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<ProfileResponse> saveProfile(@RequestBody ProfileDTO profileDTO){
        return new ResponseEntity<>(profileMapper.toResponse(profileService.createProfile(
                profileMapper.toEntity(profileDTO)
        )), HttpStatus.CREATED);
    }

}
