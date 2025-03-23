package telran.java57.conversion_web_service.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import telran.java57.conversion_web_service.dto.AmountDto;
import telran.java57.conversion_web_service.dto.ResponseDto;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class CurrencyConverterController {
    public static String api_key= "4010d4f0697eae9194c3c67c23cff5c7";
    public static String base_uri = "http://data.fixer.io/api/";
    @PostMapping("/convert-usd-ils")
    public double convertUsdToIls(@RequestBody AmountDto amountDto) throws URISyntaxException {
        double amount = amountDto.getAmount();
    RestTemplate restTemplate = new RestTemplate();
    UriComponentsBuilder builder = UriComponentsBuilder.fromUri(new URI(base_uri + "latest"))
            .queryParam("access_key",api_key)
            .queryParam("base","EUR")
            .queryParam("symbols","ILS");
    URI uri = builder.build().toUri();
    RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET,uri);
       ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);

    amount = response.getBody().getRates().get("ILS")*amount;
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());

    return amount;

    }
}
