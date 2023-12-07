package book.real_world_software.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class BusinessRuleEngineTest {
//    private final BusinessRuleEngine businessRuleEngine;

    @BeforeEach
    void init() {
//        this.businessRuleEngine = new BusinessRuleEngine();
    }

    @Test
    void showHaveNoRulesInitially() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertThat(businessRuleEngine.count()).isEqualTo(0);
    }


    @Test
    void shouldAddTwoActions() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        assertThat(businessRuleEngine.count()).isEqualTo(2);
    }

    // 모킹을 run() 이 실행되었을 때 이를 확인하는 기법
    // 1. mock 생성
    // 2. 메서드가 호출되었는지 확인
    @Test
    void shouldExecuteAction() {
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        final Action mockAction = mock(Action.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).perform();
    }

}