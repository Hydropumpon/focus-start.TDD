package mocks;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class LogicConsumerTest {

   private LogicConsumer consumer;

    @Before
    public void init() {
        DifficultEnormousLogicGenerator generator = new DifficultEnormousLogicGenerator();
        AnotherDifficultLogic logic = new AnotherDifficultLogic(generator);
        consumer = new LogicConsumer(logic);
    }

    @Test
    public void whenUseConsumerThenAssertNotNull() {
        consumer.useLogic();
        assertNotNull(consumer);
    }

    @Test(expected = NullPointerException.class)
    public void getNpeTest() {
        consumer.getNpe();
    }

}