package tn.moatez.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import tn.moatez.model.User;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String phone_number;
    private boolean verified;
    private boolean enabled;
    private String genre;
    private AccountDTO accountDTO;
    private Set<RoleDTO> rolesDTO ;
    public static UserDTO mapEntityToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO  dto = modelMapper.map(user, UserDTO.class);
        if(user.getAccount()!=null)
            dto.setAccountDTO(AccountDTO.mapEntityToDTO(user.getAccount()));
        if(!user.getRoles().isEmpty())
            dto.setRolesDTO(user.getRoles().stream().map(RoleDTO::mapEntityToDTO)
                    .collect(Collectors.toSet()));
        return dto;
    }

}
