package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.RoleDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.role.CreateRoleRequest;
import com.bms.weddingorganizationcompanysystem.request.role.UpdateRoleRequest;
import com.bms.weddingorganizationcompanysystem.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@Slf4j
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody CreateRoleRequest request) {
        roleService.createRole(request);

        log.info(ControllerLogMessage.Role.ROLE_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@PathVariable String id,
                                           @RequestBody UpdateRoleRequest request) {
        roleService.updateRole(id, request);

        log.info(ControllerLogMessage.Role.ROLE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);

        log.info(ControllerLogMessage.Role.ROLE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findRole(@PathVariable String id) {
        RoleDto role = roleService.findRole(id);

        log.info(ControllerLogMessage.Role.ROLE_FOUND + id);
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAllRoles() {
        List<RoleDto> roles = roleService.findAllRoles();

        log.info(ControllerLogMessage.Role.ROLE_LISTED);
        return ResponseEntity.ok(roles);
    }
}
