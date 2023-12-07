package book.real_world_software.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


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

}