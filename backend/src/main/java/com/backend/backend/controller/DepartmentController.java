package com.backend.backend.controller;

import com.backend.backend.payload.DTO.departmentDto.CreateDepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.DepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.UpdateDepartmentDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody CreateDepartmentDto createDepartmentDto) {
        return ResponseEntity.ok(departmentService.createDepartment(createDepartmentDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DepartmentDto> updateDepartment(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateDepartmentDto updateDepartmentDto) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, updateDepartmentDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deleteDepartment(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
}
