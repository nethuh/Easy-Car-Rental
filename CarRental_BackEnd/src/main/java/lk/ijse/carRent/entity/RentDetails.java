package lk.ijse.carRent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(RentDetail_PK.class)
public class RentDetails {

    @Id
    private String carID;
    @Id
    private String rentID;

    private String driverID;

    @ManyToOne
    @JoinColumn(name = "rentID",referencedColumnName = "rentID",insertable = false,updatable = false)
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "carID",referencedColumnName = "car_Id",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverID",referencedColumnName = "user_Id",insertable = false,updatable = false)
    private Driver driver;
}
