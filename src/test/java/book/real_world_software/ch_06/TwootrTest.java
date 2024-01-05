package book.real_world_software.ch_06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// 포트, 어댑터
class TwootrTest {

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        Twootr twootr = new Twootr();
        // 유효 사용자의 로그온 메세지 수신
        SenderEndPoint endPoint = twootr.onLogon("userId", "userPassword", new ReceiverEndPoint());

        // 로그온 메서드는 새 엔드포인트 반환

        // 엔드포인트 유효성을 확인하는 assertion

    }

    @Test
    @DisplayName("잘못된 패스워드")
    public void shouldNotBeAuthenticateUserWithWrongPassword() {

    }

}