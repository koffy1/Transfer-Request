package com.example.transferrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller // This means that this class is a Controller
public class MainController {
    @Autowired
    private BalancesRepository balancesRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "home";
	}

    @RequestMapping(value="/payment",method=RequestMethod.GET)
	public String payment() {
		return "payment";
	}

    @Transactional
    @RequestMapping(value="/payment",method=RequestMethod.POST)
	public String paymentProcess(@RequestParam String sender, 
@RequestParam String receiver, @RequestParam Double amount) {
    String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    String reference = date + amount + receiver;
    Double balance;
    Balances senderBalance = balancesRepository.findByAccountNumber(sender);
    if (senderBalance == null) {
        Balances senderBalances = new Balances();
        balance = 50000.00;
    } else {
        balance = senderBalance.getBalance();
    }
    senderBalance.setAccountNumber(sender);
    senderBalance.setBalance((Double) (balance - amount));

    Transactions transaction = new Transactions();
    transaction.setSenderAccount(sender);
    transaction.setReceiverAccount(receiver);
    transaction.setAmount((Double) amount);
    transaction.setReference(reference);

    transactionsRepository.save(transaction);
    balancesRepository.save(senderBalance);

    return "/success";
	}
}