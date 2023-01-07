package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.RoleDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.RoleDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.role.RoleAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.role.RoleListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.role.RoleNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Role;
import com.bms.weddingorganizationcompanysystem.repository.RoleRepository;
import com.bms.weddingorganizationcompanysystem.request.role.CreateRoleRequest;
import com.bms.weddingorganizationcompanysystem.request.role.UpdateRoleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleDtoConverter converter;

    public RoleService(RoleRepository roleRepository,
                       RoleDtoConverter converter) {
        this.roleRepository = roleRepository;
        this.converter = converter;
    }

    public void createRole(final CreateRoleRequest request) {
        checkIfRoleExists(request.getName());

        Role role = Role.builder()
                .name(request.getName())
                .build();

        roleRepository.save(role);
        log.info(BusinessLogMessage.Role.ROLE_CREATED + request.getName());
    }

    public void updateRole(final String id, final UpdateRoleRequest request) {
        Role role = findRoleById(id);

        if (!role.getName().equals(request.getName())) {
            checkIfRoleExists(request.getName());
        }

        role.setName(request.getName());

        roleRepository.save(role);
        log.info(BusinessLogMessage.Role.ROLE_UPDATED + id);
    }

    public void deleteRole(final String id) {
        roleRepository.delete(findRoleById(id));
        log.info(BusinessLogMessage.Role.ROLE_DELETED + id);
    }

    public RoleDto findRole(final String id) {
        log.info(BusinessLogMessage.Role.ROLE_FOUND + id);
        return converter.convert(findRoleById(id));
    }

    public List<RoleDto> findAllRoles() {
        List<Role> roles = roleRepository.findAll();

        if (roles.isEmpty()) {
            log.error(BusinessLogMessage.Role.ROLE_LIST_EMPTY);
            throw new RoleListEmptyException(BusinessMessage.Role.ROLE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Role.ROLE_LISTED);
        return converter.convert(roles);
    }

    protected Role findRoleById(final String id) {
        return roleRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Role.ROLE_NOT_FOUND + id);
            throw new RoleNotFoundException(BusinessMessage.Role.ROLE_NOT_FOUND);
        });
    }

    private void checkIfRoleExists(final String name) {
        if (roleRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Role.ROLE_ALREADY_EXISTS + name);
            throw new RoleAlreadyExistException(BusinessMessage.Role.ROLE_ALREADY_EXISTS);
        }
    }
}
