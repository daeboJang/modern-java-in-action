package book.real_world_software.ch_06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


// 포트, 어댑터
class TwootrTest {
    private Twootr twootr;

    private SenderEndPoint endPoint;
    private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

    @BeforeEach
    public void setUp() {
        twootr = new Twootr();
    }

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        // 유효 사용자의 로그온 메세지 수신
        Optional<SenderEndPoint> endPoint = twootr.onLogon("userId", "userPassword", receiverEndPoint);

        // 로그온 메서드는 새 엔드포인트 반환

        // 엔드포인트 유효성을 확인하는 assertion
        assertThat(endPoint.isPresent()).isEqualTo(false);

    }

    @Test
    @DisplayName("잘못된 패스워드")
    public void shouldNotBeAuthenticateUserWithWrongPassword() {

    }

    private void logon() {
        this.endPoint = logon(TestData.USER_ID, receiverEndPoint);
    }

    private SenderEndPoint logon(final String userId, final ReceiverEndPoint receiverEndPoint) {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(userId, TestData.PASSWORD, receiverEndPoint);
//        assertTrue("Failed to logon", endPoint.isPresent());
        return endPoint.get();
    }
}