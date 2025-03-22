package tobyspring.hellospring;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private Long orderId;
    //바꿀 통화 이름
    private String currency;
    //바꿨을 때 얼마인지 정확한 소수점 계산을 위해 BigDecimal 사용
    private BigDecimal foreignCurrencyAmount;
    //환율 정보 마찬가지로 정확한 값이 입력되어야 하기 때문에 BigDecimal 사용
    private BigDecimal exRate;
    //변경 금액 ex) 달러 -> 원
    private BigDecimal convertedAmount;
    //유효 기간
    private LocalDateTime validUtil;

    //생성자로 값을 주입받는 경우 매개변수가 많을 때 값이 혼동되는 경우가 존재한다. 따라서 Builder 패턴으로 만드는게 적절하다.(Lombok 사용)
    public Payment(Long orderId, String currency, BigDecimal foreignCurrencyAmount, BigDecimal exRate, BigDecimal convertedAmount, LocalDateTime validUtil) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUtil = validUtil;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUtil() {
        return validUtil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUtil=" + validUtil +
                '}';
    }
}
