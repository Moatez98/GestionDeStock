package tn.moatez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import tn.moatez.dto.AccountDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String email ;
    private String username ;
    private String password ;
    private boolean verified;
    private boolean enabled;
    public static Account mapDTOToEntity(AccountDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto , Account.class);
    }
}
