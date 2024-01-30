package tn.moatez.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.moatez.dto.UserDTO;
import tn.moatez.services.UserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/User")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/Get-All-Users")
    public ResponseEntity<List<UserDTO>> obtenirTousLesUtilisateurs(){
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }
    @GetMapping("/Get-User-By-Id/{id}")
    public ResponseEntity<UserDTO> obtenirUtilisateurParIdentifiant(@PathVariable(name = "id") Long id){
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }
    @PostMapping("/Save-User")
    public ResponseEntity<UserDTO> sauvegarderUtilisateur(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUser(userDTO));
    }
    @PutMapping("/Update-User/{id}")
    public ResponseEntity<UserDTO> modifierUtilisateur(@RequestBody UserDTO userDTO,@PathVariable(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userService.updateUser(id,userDTO));
    }




}
