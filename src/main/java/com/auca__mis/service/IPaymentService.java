package com.auca__mis.service;

import com.auca__mis.model.Country;
import com.auca__mis.model.Payment;

import java.util.List;

public interface IPaymentService {
    Payment savePayment(Payment payment);
    public List<Payment> findAll();
    Payment findById(Payment payment);
}
