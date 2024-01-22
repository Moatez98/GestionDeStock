package tn.moatez.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private String nom ;
    @Column(nullable = false)
    private String prenom ;
    @Column(nullable = false , unique = true)
    private String nom_de_utilisateur;
    @Column(nullable = false , unique = true)
    private String email ;
    @Column(nullable = false)
    private String mot_de_passe ;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_de_naisance ;
    @Column(nullable = false)
    private String numero_de_telephone ;
    private boolean  verifie ;
    private boolean active ;
    private String genre ;
}
