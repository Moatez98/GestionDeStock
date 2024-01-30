package tn.moatez.services.impl;

import org.springframework.stereotype.Service;
import tn.moatez.dto.RoleDTO;
import tn.moatez.dto.UserDTO;
import tn.moatez.model.User;
import tn.moatez.repository.RoleRepository;
import tn.moatez.repository.UserRepository;
import tn.moatez.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> usersEntity = userRepository.findAll();
        return usersEntity.stream()
                .map(UserDTO::mapEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public UserDTO getUserById(Long id) {
        User entity = userRepository.findById(id).orElse(null);
        if (entity != null)
            return UserDTO.mapEntityToDto(entity);
        return null;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        RoleDTO roleDTO = RoleDTO.
                mapEntityToDTO(roleRepository.findRoleByName("client"));
        userDTO.setRolesDTO(Collections.singleton(roleDTO));
        userDTO.setEnabled(true);
        userDTO.setVerified(false);
        User entity = userRepository
                .save(User.mapDtoToEntity(userDTO));
        return UserDTO.mapEntityToDto(entity);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User entity = userRepository
                    .save(User.mapDtoToEntity(userDTO));
            return UserDTO.mapEntityToDto(entity);
        }
        return null;
    }
}
