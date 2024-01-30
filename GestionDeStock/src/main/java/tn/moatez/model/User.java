package tn.moatez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import tn.moatez.dto.RoleDTO;
import tn.moatez.dto.UserDTO;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(nullable = false)
    private String phone_number;
    private String genre;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Account account;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public static User mapDtoToEntity(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        User entity = modelMapper.map(dto, User.class);
        if (dto.getAccountDTO() != null)
            entity.setAccount(Account.mapDTOToEntity(dto.getAccountDTO()));
        if(!dto.getRolesDTO().isEmpty())
            entity.setRoles(dto.getRolesDTO().stream()
                    .map(Role::mapDTOToEntity).collect(Collectors.toSet()));
        return entity;
    }
    public User clone()throws CloneNotSupportedException{
        return (User) super.clone();
    }

}
