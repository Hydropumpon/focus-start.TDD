package mocks;

public class LogicConsumer {

    private AnotherDifficultLogic logic;

    //!!!throw npe
    private String name = null;

    public LogicConsumer(AnotherDifficultLogic logic) {
        this.logic = logic;
    }

    public void useLogic() {
        System.out.println(logic.getResult());
    }

    public void getNpe(){
        name.length();
    }
}
