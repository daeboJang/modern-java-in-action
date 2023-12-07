package book.real_world_software.ch05;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private final List<Action> actions;

    public BusinessRuleEngine() {
        this.actions = new ArrayList<>();
    }

    public void addAction(final Action action) {
        this.actions.add(action);
    }

    public int count() {
        return this.actions.size();
    }

    public void run() {
//        for (Action action: this.actions) {
//            action.execute();
//        }
        this.actions.forEach(Action::execute);

//        throw new UnsupportedOperationException();
    }
}
