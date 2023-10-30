package lk.ijse.carRent.dto;

import lk.ijse.carRent.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reg_UserDTO {
    private String user_Id;
    private Name name;//embeded
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String license_No;
    private MultipartFile nic_Img;//handle file uploads.
    private MultipartFile license_Img;//handle file uploads.

    private UserDTO user;
}
