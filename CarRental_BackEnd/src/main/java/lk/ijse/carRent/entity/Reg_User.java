package lk.ijse.carRent.entity;

import lk.ijse.carRent.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reg_User {
    @Id //uniquely identify each RegUser object in the database
    private String user_Id;

    @Embedded //attributes within the name object will be stored in the same table as the RegUser entity
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String license_No;
    private String nic_Img;
    private String license_Img;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
