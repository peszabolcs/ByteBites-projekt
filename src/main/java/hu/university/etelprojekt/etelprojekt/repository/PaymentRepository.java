package hu.university.etelprojekt.etelprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.university.etelprojekt.etelprojekt.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find a payment by its ID
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
    Optional findById(Long paymentId);

    // Find payments by order ID
    List<Payment> findByOrderId(Long orderId);

    // Find payments by payment method
    List<Payment> findByPaymentMethod(String paymentMethod);

    // Find payments by status
    List<Payment> findByStatus(String status);

    // Custom query to find payments with specific order ID and status
    @Query("SELECT p FROM Payment p WHERE p.orderId = :orderId AND p.status = :status")
    List<Payment> findPaymentsByOrderIdAndStatus(@Param("orderId") Long orderId, @Param("status") String status);

    // Custom query to get all payments for a given payment method
    @Query("SELECT p FROM Payment p WHERE p.paymentMethod = :paymentMethod")
    List<Payment> findPaymentsByPaymentMethod(@Param("paymentMethod") String paymentMethod);
}
