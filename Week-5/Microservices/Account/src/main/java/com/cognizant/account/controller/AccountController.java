package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    @GetMapping
    @RequestMapping("accounts/{number}")
    public AccountDetailsResponse getAccountDetails(@PathVariable String number){
        return new AccountDetailsResponse(number, "savings", 234343L);
    }

    public static class AccountDetailsResponse{
        String number;
        String type;
        long balance;

        AccountDetailsResponse(String number, String type, long balance){
            this.balance = balance;
            this.type = type;
            this.number = number;
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

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }
    }
}
