package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static org.example.userGrpc.newBlockingStub;

public class ClientGrpc {
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",9082).usePlaintext().build();
        userGrpc.userBlockingStub userStub = newBlockingStub(channel);
        User.LoginRequest login= User.LoginRequest.newBuilder().setUserName("GRPC").setPassword("GRPC").build();
        User.LoginResponse response=userStub.login(login);
        System.out.println(response.getMsgResponse());
        channel.shutdown();
    }
}