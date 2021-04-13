package com.example.transferrequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Transactions {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "sender_account", nullable = false)
  private String senderAccount;

  @Column(name = "receiver_account", nullable = false)
  private String receiverAccount;

  private Double amount;

  @Column(name = "reference", nullable = false, unique = true)
  private String reference;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSenderAccount() {
    return senderAccount;
  }

  public void setSenderAccount(String senderAccount) {
    this.senderAccount = senderAccount;
  }

  public String getReceiverAccount() {
    return receiverAccount;
  }

  public void setReceiverAccount(String receiverAccount) {
    this.receiverAccount = receiverAccount;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }
}