package tests.mockito;

import exercises.mokito.ExternalApi;
import exercises.mokito.MyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MyServiceTest {
     @Test
     public void testExternalApi() {
         ExternalApi mockApi = Mockito.mock(ExternalApi.class);
         when(mockApi.getData()).thenReturn("Mock Data");
         MyService service = new MyService(mockApi);
         String result = service.fetchData();
         Assertions.assertEquals("Mock Data", result);
     }

     @Test
     public void testVerifyInteraction() {
         ExternalApi mockApi = Mockito.mock(ExternalApi.class);
         MyService service = new MyService(mockApi);
         service.fetchData();
         // service.fetchData();

         // Verify that the getData() method is invoked minimum of 1 time. This  will be successful as we have have called getData() method in other test.
         verify(mockApi).getData();

         // Verify that the getData() method is invoked minimum of 2 times. This
         // verify(mockApi, times(2)).getData();
     }

     @Test
     public void testVerifyInteractionsWithArguments(){
         ExternalApi mockApi = Mockito.mock(ExternalApi.class);
         MyService service = new MyService(mockApi);
         service.fetchData(10);
         // Verify with arguments
          verify(mockApi).getData(10);
     }
}
