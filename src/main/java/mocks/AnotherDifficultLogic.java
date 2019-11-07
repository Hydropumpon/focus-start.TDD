package mocks;

public class AnotherDifficultLogic {

    private DifficultEnormousLogicGenerator logic;

    public AnotherDifficultLogic(DifficultEnormousLogicGenerator logic) {
        this.logic = logic;
    }

    public long getResult() {
        return preCalculate();
    }

    private long preCalculate() {
        return logic.calculate()/2;
    }
}
