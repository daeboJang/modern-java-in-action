package book.real_world_software.ch_05;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1. 팩트 - 규칙이 확인할 수 있느 정보
 * 2. 액션 - 수행하려는 동작
 * 3. 조건 - 언제 액션을 발생시킬지 지정
 * 4. 규칙(Rule) - 실행하려는  규칙을 지정, 보통 팩트,액션, 조건을 한 그룹으로 묶어 규칙으로 만듬
 */
public class BusinessRuleEngine {

//    private final List<Action> actions;
    private final List<Rule> rules;
    private final Facts facts;

    public BusinessRuleEngine(final Facts facts) {
        this.facts = facts;
        this.rules = new ArrayList<>();
    }

    public void addRule(final Rule rule) {
        this.rules.add(rule);
    }

    public int count() {
        return this.rules.size();
    }

    public void run() {
//        for (Action action: this.actions) {
//            action.execute();
//        }
//        this.actions.forEach(Action::perform);
        this.rules.forEach(rule -> rule.perform(facts));
//        throw new UnsupportedOperationException();
    }
}
