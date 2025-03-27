package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Clock;
import java.time.LocalDateTime;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TestPaymentConfig.class)
@ExtendWith(SpringExtension.class)
class PaymentServiceSpringTest {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private Clock clock;

    @DisplayName("prepare 메서드가 요구사항 3가지를 잘 수행하는지 검증한다.")
    @Test
    void prepare()  {
        //given
        Payment payment = paymentService.prepare(1L, "USD", valueOf(1000));


        assertThat(payment.getConvertedAmount()).isEqualTo(valueOf(1000000));
     }

     @DisplayName("유효 시간은 설정한 시간에서 30분 뒤이다.")
     @Test
     void test()  {
         //given
         Payment payment = paymentService.prepare(1L, "USD", TEN);

         //when
         LocalDateTime now = LocalDateTime.now(clock);
         LocalDateTime expectedValidUtil = now.plusMinutes(30);

         //then
         Assertions.assertThat(payment.getValidUtil()).isEqualTo(expectedValidUtil);
      }



}