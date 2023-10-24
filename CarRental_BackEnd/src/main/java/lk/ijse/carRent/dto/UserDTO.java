package lk.ijse.carRent.dto;

import lk.ijse.carRent.enums.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UserDTO {
    private String user_Id;
    private RoleType role_Type;
    private String user_Name;
    private String password;

    public UserDTO(RoleType role_Type, String user_Name, String password) {
        this.role_Type = role_Type;
        this.user_Name = user_Name;
        this.password = password;
    }
}

