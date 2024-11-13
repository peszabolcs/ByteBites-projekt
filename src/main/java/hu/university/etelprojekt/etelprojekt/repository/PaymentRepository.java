package hu.university.etelprojekt.etelprojekt.repository;

import hu.university.etelprojekt.etelprojekt.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByStatus(String status);

    Optional<Payment> findByOrder_OrderId(Long orderId);

    Optional<Payment> findByPaymentMethod(String paymentMethod);

    Optional<Payment> findByPaymentDate(LocalDate paymentDate); // Updated to LocalDate

    List<Payment> findByAmount(Double amount);
}
