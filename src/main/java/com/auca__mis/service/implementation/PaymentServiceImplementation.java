package com.auca__mis.service.implementation;

import com.auca__mis.dao.PaymentDao;
import com.auca__mis.dao.TeacherDao;
import com.auca__mis.model.Payment;
import com.auca__mis.model.Teacher;
import com.auca__mis.service.IPaymentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PaymentServiceImplementation implements IPaymentService {
    private PaymentDao paymentDao;


    @Override
    public Payment savePayment(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    @Override
    public Payment findById(Payment payment) {
        return this.paymentDao.findById(payment.getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with code: " + payment.getId()));

    }
}
