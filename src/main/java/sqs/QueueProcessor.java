package sqs;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class QueueProcessor implements RequestHandler<SQSEvent, Void> {

    @Override
    public Void handleRequest(SQSEvent event, Context context) {
        for (SQSEvent.SQSMessage msg : event.getRecords()) {
            System.out.println("Info: Received Message - " + msg.getMessageId());
            System.out.println("Info: Message Body");
            System.out.println("\t" + msg.getBody());
        }
        return null;
    }
}