import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        // Stub the method to return predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        MyService service = new MyService(mockApi);

        // Call the method
        service.fetchData();

        // Verify the interaction
        verify(mockApi).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {
        // Stub with argument matcher
        when(mockApi.getDataWithParam(anyString())).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchDataWithParam("test");

        assertEquals("Mock Data", result);

        // Verify with specific argument
        verify(mockApi).getDataWithParam(eq("test"));
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testVoidMethod() {
        MyService service = new MyService(mockApi);

        // Call the void method
        service.storeData("Test Data");

        // Verify the interaction
        verify(mockApi).saveData("Test Data");
    }

    // Exercise 5: Mocking and Stubbing with Multiple Returns
    @Test
    public void testMultipleReturns() {
        // Stub with multiple returns
        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenThrow(new RuntimeException("No more calls allowed"));

        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());

        // Third call should throw exception
        assertThrows(RuntimeException.class, service::fetchData);
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testInteractionOrder() throws Exception {
        MyService service = new MyService(mockApi);

        // Call methods
        service.processAndStore("Data");

        // Create inOrder verifier
        InOrder inOrder = inOrder(mockApi);

        // Verify order of calls
        inOrder.verify(mockApi).processData("Data");
        inOrder.verify(mockApi).saveData("Data");
    }

    // Exercise 7: Handling Void Methods with Exceptions
    @Test
    public void testVoidMethodWithException() throws Exception {
        // Stub void method to throw exception
        doThrow(new RuntimeException("Processing failed")).when(mockApi).processData("Bad Data");

        MyService service = new MyService(mockApi);

        // Verify exception is thrown
        assertThrows(RuntimeException.class, () -> service.processAndStore("Bad Data"));

        // Verify the interaction still happened
        verify(mockApi).processData("Bad Data");
    }
}