package com.minet.transaction;

public class TransactionController {
    private final TransactionModel model = new TransactionModel();
    private final TransactionView view = new TransactionView();

    public void requestReceiptNumber(){
        String receiptNo = view.showReceiptMessage();

        model.setReciptNo(receiptNo);
    }

}
