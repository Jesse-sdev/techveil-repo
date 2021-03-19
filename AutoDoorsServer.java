package grpc.test.office;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.test.office.opendoorGrpc.opendoorImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AutoDoorsServer extends opendoorImplBase {
	//logger helps in tracing errors by storing info about created methods into a log. Also used to print out logged info.
	private static final Logger logger = Logger.getLogger(AutoDoorsServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting Server...");
		//creating a new instance of the service to be used 
		AutoDoorsServer doorserver = new AutoDoorsServer();
		//initializing the port to be listened to
		int port = 50051;
	    
		//attempt to create the server...
		try {
			//creating a server builder for the server
			Server server = ServerBuilder.forPort(port)
					//registering the service
			    .addService(doorserver)
			    //finally build
			    .build()
			    //then can call start to begin listening on given port
			    .start();
			
			//to prevent main process from quiting by itself after running in background
			 server.awaitTermination();

		//..and catch to capture possible errors	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);	    		    	   
	}
	
	//this is the overridden server stub for unary service of opendoor
	@Override
	//default async operation on server side
	public void motionDetect(InputRequest request,  StreamObserver<OutputReply> responseObserver) {
		//using variables to store requests
		String motion=request.getMotion();
    	int distance= request.getDistance();
    	
		//initializing OutputReply and building 
		OutputReply.Builder reply = OutputReply.newBuilder();
		
		System.out.println("\nAutomatic sensors have registered...");
		//displays values of motion and distance sent in by client.
		 System.out.println("Motion detected? : " + motion + ", Distance to door : " + distance+ " meters"+ "\n");
		 
	     //gets reply back to client based on met conditions. 		
		 if(motion.equalsIgnoreCase("yes")&& distance <= 5) {
			 //if motion is detected and at a distance of 5 meters or less, the lights switch on and the doors open
			 reply.setLights("Automatic Lights turned on!");
			 reply.setDoors("\nAutomatic doors opened!");
			
	    	}
	    	else if(motion.equalsIgnoreCase("yes")&& distance >5) {
	    		//if the distance is greater than 5 meters but motion has been detected, the lights alone will turn on.
	    		reply.setLights("Automatic Lights turned on!");
	    		reply.setDoors("\nAutomatic doors closed!");

	    	}else {	 
	    		//otherwise, everything stays turned off/closed till either of the conditions above are met.
	    		reply.setLights("Automatic Lights turned off!");
	    		reply.setDoors("\nAutomatic doors closed!");
	    	}
		 
		 //onNext sends one set of data from server to client after another.
		 responseObserver.onNext(reply.build());
	     //onCompleted used to finish the responses.
	     responseObserver.onCompleted();
	}	
}

