package com.AmbGo.Back.cleint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.AmbGoSocketConn.RideRequest.RideNotificationServiceGrpc.RideNotificationServiceBlockingStub;

import io.grpc.ManagedChannel;

@Component 
public class GrpcClient {
    
    @Value ("${grpc.server.port:9090}")
    private int grpcServerPort;

    @Value("${grpc.server.host:localhost}")
    private String grpcServerHost;

    private ManagedChannel channel;

    private RideNotificationServiceBlockingStub rideNotificationServiceStub;

    @PostConstruct 
    public void init(){
        channel = ManagedChannelBuilder.forAddress(grpcServerHost, grpcServerPort)
                    .usePlaintext()
                    .build();

         rideserviceStub = RideServiceGrpc.newBlockingStub(channel);
    }

    public boolean acceptRide(Integer driverId, Integer bookingId){
        RideAcceptenceRequest request = RideAcceptenceRequest.newBuilder().setDriverId(driverId)
                                                        .setBookingId(bookingId).build();

        RideAcceptanceResponse response = rideserviceStub.acceptRide(request);

        return response.getSuccess();
    }
    
}
