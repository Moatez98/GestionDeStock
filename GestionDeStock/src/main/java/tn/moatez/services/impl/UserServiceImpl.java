package tn.moatez.services.impl;

import org.springframework.stereotype.Service;
import tn.moatez.model.User;
import tn.moatez.repository.UserRepository;
import tn.moatez.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> obtenirTousLesUtilisateurs() {
        return userRepository.findAll();
    }

    @Override
    public User obtenirUtilisateurParIdentifiant(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User sauvegarderUtilisateur(User user) {
        return userRepository.save(user);
    }

    @Override
    public User mettreAJourUtilisateur(Long id, User user) {
        if(userRepository.existsById(id)){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User desactiverUtilisateur(Long id) {
        if(userRepository.existsById(id)){
            User user = userRepository.findById(id).orElseThrow();
            user.setActive(false);
            userRepository.save(user);
            return user;
        }
        return null;
    }
}
