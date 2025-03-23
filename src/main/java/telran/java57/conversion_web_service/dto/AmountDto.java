package telran.java57.conversion_web_service.dto;

import lombok.Data;

@Data
public class AmountDto {
    private double amount;

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}