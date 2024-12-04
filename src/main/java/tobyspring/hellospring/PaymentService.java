package tobyspring.hellospring;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class PaymentService {
    public Payment prepare(Long orderId, String currency, BigDecimal foreginCurrencyAmount)throws Exception{
        // 1. 환율 가져오기
        URL url = new URL("https://open.er-api.com/v6/latest/USD" + currency);
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        // 2. 금액 계산
        // 3. 유효 시간 계산
        return new Payment(orderId, currency, foreginCurrencyAmount, BigDecimal.ZERO,BigDecimal.ZERO, LocalDateTime.now());
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }


}

