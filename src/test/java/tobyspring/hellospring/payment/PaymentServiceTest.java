package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.Assertions.*;

class PaymentServiceTest {

    private Clock clock;

    @BeforeEach
    void init() {
        clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @DisplayName("prepare 메서드가 요구사항 3가지를 잘 수행하는지 검증한다.")
    @Test
    void prepare() {
        //given
        getPayment(valueOf(100),valueOf(1000), this.clock);
        getPayment(valueOf(500),valueOf(5000), this.clock);
        getPayment(valueOf(1000),valueOf(10000), this.clock);

        //원화환산금액의 유효시간 계산
//        assertThat(payment.getValidUtil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getValidUtil()).isBefore(LocalDateTime.now().plusMinutes(30));

     }

     @DisplayName("유효시간은 설정한 시간에서 30분 이후이다")
     @Test
     void test() {
         //given
         PaymentService paymentService = new PaymentService(new ExRateProviderStub(valueOf(1000)), clock);
         Payment payment = paymentService.prepare(1L, "USD", TEN);

         //when
         LocalDateTime now = LocalDateTime.now(clock);
         LocalDateTime expectedValidUtil = now.plusMinutes(30);

         //then
         Assertions.assertThat(payment.getValidUtil()).isEqualTo(expectedValidUtil);

      }




    private static void getPayment(BigDecimal exRate, BigDecimal convertedAmount, Clock clock)  {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);

        //when
        Payment payment = paymentService.prepare(1L, "USD", TEN);

        //then
        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);

        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
    }


}