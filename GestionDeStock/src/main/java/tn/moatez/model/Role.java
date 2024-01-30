package tn.moatez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import tn.moatez.dto.RoleDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name ;
    public Role(String name){
        this.name = name ;
    }
    public static Role mapDTOToEntity(RoleDTO roleDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(roleDTO, Role.class);
    }
}
