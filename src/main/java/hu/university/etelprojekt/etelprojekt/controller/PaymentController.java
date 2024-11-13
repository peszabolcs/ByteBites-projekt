package hu.university.etelprojekt.etelprojekt.controller;

import hu.university.etelprojekt.etelprojekt.entity.Payment;
import hu.university.etelprojekt.etelprojekt.service.PaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Create or update a payment
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    // Get a payment by its ID
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Optional<Payment> payment = paymentService.getPaymentById(paymentId);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get payments by status
    @GetMapping("/status/{status}")
    public ResponseEntity<Payment> getPaymentByStatus(@PathVariable String status) {
        Optional<Payment> payment = paymentService.getPaymentByStatus(status);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get payments by order ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Payment> getPaymentByOrderId(@PathVariable Long orderId) {
        Optional<Payment> payment = paymentService.getPaymentByOrderId(orderId);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get payments by payment method
    @GetMapping("/method/{paymentMethod}")
    public ResponseEntity<Payment> getPaymentByMethod(@PathVariable String paymentMethod) {
        Optional<Payment> payment = paymentService.getPaymentByMethod(paymentMethod);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get payments by payment date
    @GetMapping("/date/{paymentDate}")
    public ResponseEntity<Optional<Payment>> getPaymentsByDate(@PathVariable String paymentDate) {
        LocalDate date = LocalDate.parse(paymentDate); // Assuming the date is passed as a string
        Optional<Payment> payments = paymentService.getPaymentsByDate(date);
        return payments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(payments);
    }

    // Get payments by amount
    @GetMapping("/amount/{amount}")
    public ResponseEntity<List<Payment>> getPaymentsByAmount(@PathVariable Double amount) {
        List<Payment> payments = paymentService.getPaymentsByAmount(amount);
        return payments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(payments);
    }

    // Delete a payment by its ID
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }
}
