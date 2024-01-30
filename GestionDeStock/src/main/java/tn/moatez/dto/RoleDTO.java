package tn.moatez.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import tn.moatez.model.Role;

@Data
public class RoleDTO {
    private long id ;
    private String name ;
    public static RoleDTO mapEntityToDTO(Role role){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(role, RoleDTO.class);
    }


}
