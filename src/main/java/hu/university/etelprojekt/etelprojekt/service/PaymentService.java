package hu.university.etelprojekt.etelprojekt.service;

import hu.university.etelprojekt.etelprojekt.entity.Payment;
import hu.university.etelprojekt.etelprojekt.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Create or update a payment
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Find payment by its ID
    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    // Find payments by status
    public Optional<Payment> getPaymentByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    // Find payments by order ID
    public Optional<Payment> getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrder_OrderId(orderId);
    }

    // Find payments by payment method
    public Optional<Payment> getPaymentByMethod(String paymentMethod) {
        return paymentRepository.findByPaymentMethod(paymentMethod);
    }

    // Find payments by payment date
    public Optional<Payment> getPaymentsByDate(LocalDate paymentDate) {
        return paymentRepository.findByPaymentDate(paymentDate);
    }

    // Find payments by amount
    public List<Payment> getPaymentsByAmount(Double amount) {
        return paymentRepository.findByAmount(amount);
    }

    // Delete a payment by its ID
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
