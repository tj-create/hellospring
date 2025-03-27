package tobyspring.hellospring.learningtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {

    @DisplayName("일반 clock으로 설정했을 때 뒤에 설정한 시간이 앞에 설정한 시간보다 늦다.")
    @Test
    void clockTest(){
        //given
        Clock clock = Clock.systemDefaultZone();

        //when
        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        //then
        Assertions.assertThat(dt2).isAfter(dt1);


     }

     @DisplayName("고정된 clock을 사용하면 두 값이 동일하다.")
     @Test
     void fixedClockTest(){
         //given
         Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

         //when
         LocalDateTime dt1 = LocalDateTime.now(clock);
         LocalDateTime dt2 = LocalDateTime.now(clock);
         LocalDateTime dt3 = LocalDateTime.now(clock).plusHours(1);

         //then
         Assertions.assertThat(dt2).isEqualTo(dt1);
         Assertions.assertThat(dt3).isEqualTo(dt2.plusHours(1));

      }


}
