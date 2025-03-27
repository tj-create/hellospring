package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class PaymentTest {

    @DisplayName("환율을 계산해서 전환된 환전금액을 저장한다.")
    @Test
    void createPayment()  {
        //given
        //when
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        Payment payment = Payment.createPayment(
                1L, "USD", BigDecimal.TEN, new ExRateProviderStub(BigDecimal.valueOf(1000)), LocalDateTime.now(clock));

        //then
        Assertions.assertThat(payment.getExRate()).isEqualTo(BigDecimal.valueOf(1000));
        Assertions.assertThat(payment.getConvertedAmount()).isEqualTo(BigDecimal.valueOf(10000));

     }

     @DisplayName("유효시간을 계산해서 유효시간 이전이면 true를 유효시간 이후면 false를 리턴한다.")
     @Test
     void test()  {
         //given
         //when
         Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
         Payment payment = Payment.createPayment(
                 1L, "USD", BigDecimal.TEN, new ExRateProviderStub(BigDecimal.valueOf(1000)), LocalDateTime.now(clock));

         //then
         Assertions.assertThat(payment.isValidTime(clock)).isTrue();
         Assertions.assertThat(
                 payment.isValidTime(Clock.offset(clock, Duration.of(30, ChronoUnit.MINUTES)))
         ).isFalse();

      }


}
