package book.real_world_software.ch_06;

import java.util.Objects;

/**
 * 6장. 트우터
 */
public class Twootr {

    public SenderEndPoint onLogon(final String userId, final String password, ReceiverEndPoint receiverEndPoint) {

        Objects.requireNonNull(userId, "userId");
        Objects.requireNonNull(password, "password");

        //무조건 성공 유저
//        return new User(userId, password);
        return null;
    }
}
