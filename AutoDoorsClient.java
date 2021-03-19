package grpc.test.office;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.test.office.opendoorGrpc.opendoorBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

//client creates connection to server, calls server and gives it instructions. Which in return prints it out
public class AutoDoorsClient {

	private static final Logger logger = Logger.getLogger(AutoDoorsClient.class.getName());
		  
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;
		
		//uses channel to run all behind the scenes operations with resolvers, IP address and load-balancing
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		//choosing to use blocking stub which blocks code till data is returned from server
		opendoorBlockingStub  blockingStub = opendoorGrpc.newBlockingStub(channel);
		
		//new instance of client class
		AutoDoorsClient client = new AutoDoorsClient();
	    
	    //client server creation..
	    try {	    	 
	    	 //assigning a variable "request" to the building of InputRequest from the client
	    	 InputRequest request = InputRequest.newBuilder().setMotion("yes").setDistance(5).build();
	    	 
	    	 //using the stub selected, derive a response from the server based on the request passed in.
	    	 OutputReply response = blockingStub.motionDetect(request);
	    	 
	    	 //print out with logger. can use system.out.print instead
	    	 logger.info("Response from Server: " + response.getLights()+ response.getDoors());
	    	
	    	 //catch all possible exceptions
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }		
}
