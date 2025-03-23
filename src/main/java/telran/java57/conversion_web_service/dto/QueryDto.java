package telran.java57.conversion_web_service.dto;

import lombok.Data;

@Data
public class QueryDto {
    private String from;
    private String to;
    private double amount;
}
