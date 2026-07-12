package com.example.review.DTO;

public class Fund {
    private long senderAccountNumber;
    private long beneficiaryAccountNumber;

    public long getAmountTransfered() {
        return amountTransfered;
    }

    public void setAmountTransfered(long amountTransfered) {
        this.amountTransfered = amountTransfered;
    }

    public long getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public long getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(long senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    private long amountTransfered;
}
