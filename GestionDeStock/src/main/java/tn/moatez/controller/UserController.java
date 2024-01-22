package tn.moatez.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.moatez.model.User;
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
    @GetMapping("/obtenirTousLesUtilisateurs")
    public ResponseEntity<List<User>> obtenirTousLesUtilisateurs(){
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(userService.obtenirTousLesUtilisateurs());
    }
    @GetMapping("/obtenirUtilisateurParIdentifiant/{id}")
    public ResponseEntity<User> obtenirUtilisateurParIdentifiant(@PathVariable(name = "id") Long id){
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(userService.obtenirUtilisateurParIdentifiant(id));
    }
    @PostMapping("/sauvegarderUtilisateur")
    public ResponseEntity<User> sauvegarderUtilisateur(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.sauvegarderUtilisateur(user));
    }
    @PostMapping("/modifierUtilisateur/{id}")
    public ResponseEntity<User> modifierUtilisateur(@RequestBody User user,@PathVariable(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userService.sauvegarderUtilisateur(user));
    }
    @GetMapping("/desactiverUtilisateur/{id}")
    public ResponseEntity<User> desactiverUtilisateur(@PathVariable(name = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.desactiverUtilisateur(id));
    }



}
