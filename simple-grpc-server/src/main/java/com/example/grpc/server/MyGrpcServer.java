/*
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.grpc.server;

import com.example.grpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class MyGrpcServer {
    static public void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8090).addService(new GreetingServiceImpl()).addService(new DriverImpl()).build();
        server.start();
        System.out.println("1|1|tcp|127.0.0.1:8090|grpc");
        server.awaitTermination();
    }

    public static class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
        @Override
        public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            System.out.println(request);

            String greeting = "Hello " + request.getName();

            HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    public static class DriverImpl extends DriverGrpc.DriverImplBase {
        @Override
        public void metas(Empty request, StreamObserver<MetasResponse> responseObserver) {
            super.metas(request, responseObserver);
        }

        @Override
        public void init(InitRequest request, StreamObserver<Empty> responseObserver) {
            super.init(request, responseObserver);
        }

        @Override
        public void close(Empty request, StreamObserver<Empty> responseObserver) {
            super.close(request, responseObserver);
        }

        @Override
        public void ping(Empty request, StreamObserver<Empty> responseObserver) {
            super.ping(request, responseObserver);
        }

        @Override
        public void exec(ExecRequest request, StreamObserver<ExecResponse> responseObserver) {
            super.exec(request, responseObserver);
        }

        @Override
        public void tx(TxRequest request, StreamObserver<TxResponse> responseObserver) {
            super.tx(request, responseObserver);
        }

        @Override
        public void databases(Empty request, StreamObserver<DatabasesResponse> responseObserver) {
            super.databases(request, responseObserver);
        }

        @Override
        public void parse(ParseRequest request, StreamObserver<ParseResponse> responseObserver) {
            super.parse(request, responseObserver);
        }

        @Override
        public void audit(AuditRequest request, StreamObserver<AuditResponse> responseObserver) {
            super.audit(request, responseObserver);
        }

        @Override
        public void genRollbackSQL(GenRollbackSQLRequest request, StreamObserver<GenRollbackSQLResponse> responseObserver) {
            super.genRollbackSQL(request, responseObserver);
        }
    }
}
