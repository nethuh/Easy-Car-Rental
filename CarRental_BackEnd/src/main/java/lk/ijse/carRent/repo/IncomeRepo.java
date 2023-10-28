package lk.ijse.carRent.repo;

import lk.ijse.carRent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface IncomeRepo extends JpaRepository<Rent, String> {
    @Query(value = "SELECT payment.date,count(payment.paymentID),sum(payment.total) FROM Rent INNER JOIN Payment ON Rent.rentID = Payment.rentID GROUP BY date", nativeQuery = true)
    ArrayList dailyIncome();

    @Query(value = "SELECT (MONTHNAME(date )) ,count(payment.paymentID),sum(payment.total)FROM Rent INNER JOIN Payment ON Rent.rentID = Payment.rentID  GROUP BY extract(MONTH FROM(date))", nativeQuery = true)
    ArrayList MonthlyIncome();

    @Query(value = "SELECT (YEAR(date )) ,count(payment.paymentID),sum(payment.total)FROM Rent INNER JOIN Payment ON Rent.rentID = Payment.rentID  GROUP BY extract(YEAR FROM(date))", nativeQuery = true)
    ArrayList AnnuallyIncome();
}
