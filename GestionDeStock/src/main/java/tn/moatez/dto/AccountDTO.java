package tn.moatez.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import tn.moatez.model.Account;

@Data
public class AccountDTO {
    private Long id ;
    private String email;
    private String username ;
    private String password ;
    private boolean verified ;
    private boolean enabled ;


    public static AccountDTO mapEntityToDTO(Account entity){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Account, AccountDTO>() {
            @Override
            protected void configure() {
                skip(destination.getPassword());
            }
        });
        return modelMapper.map(entity , AccountDTO.class);
    }
}
