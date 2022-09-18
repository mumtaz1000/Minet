package com.minet.transaction;

public class TransactionModel {

    private final String transactionFileName = "src/assets/TransactionRecord.txt";
    private String transactionNumber;
    private String reciptNo;

    public String getTransactionFileName() {
        return transactionFileName;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getReciptNo() {
        return reciptNo;
    }

    public void setReciptNo(String reciptNo) {
        this.reciptNo = reciptNo;
    }
    }
