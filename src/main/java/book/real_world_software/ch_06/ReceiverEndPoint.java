package book.real_world_software.ch_06;

/**
 * Adapter interface for pushing information out to a UI port.
 * 코어로부터 이벤트를 수신함
 */
public interface ReceiverEndPoint {
    void onTwoot(Twoot twoot);
}
