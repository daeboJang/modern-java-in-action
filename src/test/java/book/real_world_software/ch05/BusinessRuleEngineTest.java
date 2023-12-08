package book.real_world_software.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class BusinessRuleEngineTest {
    private BusinessRuleEngine businessRuleEngine;
    private Action mockAction;
    private Facts mockFacts;

    @BeforeEach
    void init() {
        this.mockAction = mock(Action.class);
        this.mockFacts = mock(Facts.class);
        this.businessRuleEngine = new BusinessRuleEngine(this.mockFacts);
    }

    @Test
    void showHaveNoRulesInitially() {

        assertThat(businessRuleEngine.count()).isEqualTo(0);
    }


    @Test
    void shouldAddTwoActions() {
        businessRuleEngine.addAction(facts -> {
            final String jobTitle = facts.getFact("jobTitle");
            if ("CEO".equals(jobTitle)) {
                final String name = facts.getFact("name");
                // do something!!
            }
        });
        businessRuleEngine.addAction(facts -> {});

        assertThat(businessRuleEngine.count()).isEqualTo(2);
    }

    // 모킹을 run() 이 실행되었을 때 이를 확인하는 기법
    // 1. mock 생성
    // 2. 메서드가 호출되었는지 확인
    @Test
    void shouldExecuteAction() {

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).perform(mockFacts);
    }

    @Test
    public void shouldPerformformAndActionWithFacts() {

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).perform(mockFacts);
    }

}