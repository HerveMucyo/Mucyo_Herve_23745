package com.auca__mis.controller;

import com.auca__mis.model.AcademicUnit;
import com.auca__mis.model.Country;
import com.auca__mis.model.Payment;
import com.auca__mis.model.Student;
import com.auca__mis.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
public class PaymentController {
    private IPaymentService iPaymentService;

    @Autowired
    public PaymentController(IPaymentService iPaymentService) {
        this.iPaymentService = iPaymentService;
    }

    @GetMapping("/payment")
    private String showPayment(Model model) {
        model.addAttribute("payment", new Payment());
        return "paymentForm";
    }
    @PostMapping("/payment/create")
    public String createCountry(@ModelAttribute("payment") Payment payment,Model model) {
//        Payment payment1 = iPaymentService.findById(payment.getStud_Id());

        payment.setId(UUID.randomUUID());
        payment.setDate(LocalDate.now());
        payment.setAmount(payment.getAmount());
        iPaymentService.savePayment(payment);
        return "redirect:/payment";
    }
}
