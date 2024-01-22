package tn.moatez.services;

import tn.moatez.model.User;

import java.util.*;

public interface UserService {
    List<User> obtenirTousLesUtilisateurs();
    User obtenirUtilisateurParIdentifiant(Long id);
    User sauvegarderUtilisateur(User user);

    User mettreAJourUtilisateur(Long id , User user);

    User desactiverUtilisateur(Long id);
}
