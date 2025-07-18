package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping
    @RequestMapping("loans/{number}")
    public LoanDetailsResponse getLoanDetails(@PathVariable String number){
        return new LoanDetailsResponse(number, "car", 400000L, 3258L, 18L);
    }

    public static class LoanDetailsResponse{
        String number, type;
        long loan, emi, tenure;

        public LoanDetailsResponse(String number, String type, long loan, long emi, long tenure) {
            this.number = number;
            this.type = type;
            this.loan = loan;
            this.emi = emi;
            this.tenure = tenure;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getLoan() {
            return loan;
        }

        public void setLoan(long loan) {
            this.loan = loan;
        }

        public long getEmi() {
            return emi;
        }

        public void setEmi(long emi) {
            this.emi = emi;
        }

        public long getTenure() {
            return tenure;
        }

        public void setTenure(long tenure) {
            this.tenure = tenure;
        }
    }
}
