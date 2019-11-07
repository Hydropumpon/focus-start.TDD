package mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LogicConsumerMockTest {

    @Mock
    AnotherDifficultLogic mockLogic;

    LogicConsumer consumer;

    @Before
    public  void init() {
        MockitoAnnotations.initMocks(this);
        consumer = new LogicConsumer(mockLogic);
    }

    @Test
    public void useConsumerTest() {
        when(mockLogic.getResult()).thenReturn(10L);
        consumer.useLogic();
        verify(mockLogic, times(1)).getResult();
    }
}
