package tn.moatez.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import tn.moatez.model.User;

import java.util.Date;

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

    public static UserDTO mapEntityToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO  dto = modelMapper.map(user, UserDTO.class);
        if(user.getAccount()!=null)
            dto.setAccountDTO(AccountDTO.mapEntityToDTO(user.getAccount()));
        return dto;
    }

}
