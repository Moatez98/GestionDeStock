package tn.moatez.services;

import tn.moatez.dto.UserDTO;


import java.util.*;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(Long id , UserDTO userDTO);

}
