package testfunc;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it
     * using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("HttpExample")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = { HttpMethod.GET,
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameterTimer calcTimer = new Timer();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            List<Integer> list = new LinkedList<Integer>();
            for (int j = 0; j < 3000; j++) {
                list.add(i + j);
            }
            list.clear();
            list = null;
        }

        long calcTime = System.currentTimeMillis() - startTime;

        return request.createResponseBuilder(HttpStatus.OK).body("Hello Time taken is, " + calcTime).build();
    }
}
