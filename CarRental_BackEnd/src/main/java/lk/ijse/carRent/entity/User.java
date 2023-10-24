package lk.ijse.carRent.entity;

import lk.ijse.carRent.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    private String user_Id;

    @Enumerated(EnumType.STRING)//stored as strings in the database.
    private RoleType role_Type;
    private String user_Name;
    private String password;

    //initialize a User object when creating or updating user records.
    public User(RoleType role_Type, String user_Name, String password) {
        this.role_Type = role_Type;
        this.user_Name = user_Name;
        this.password = password;
    }




}
