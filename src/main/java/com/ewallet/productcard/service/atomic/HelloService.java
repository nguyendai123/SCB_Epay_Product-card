package com.ewallet.productcard.service.atomic;

import com.ewallet.objects.ProcessObject;
import com.google.protobuf.util.JsonFormat;
import com.example.server.Request;
import com.example.server.Response;
import com.example.server.TestGrpc;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelloService {
    @GrpcClient("card-service-atomic")
    private TestGrpc.TestBlockingStub testBlockingStub;

    private final JsonFormat.Printer printer;


    @SneakyThrows
    public Response receiveGreeting(ProcessObject processObject) {
        Request request = Request.newBuilder()
                .setRequestId(processObject.getRequestID())
                .build();
        log.debug("{}: toAtomic: {}", processObject.getLmid(), printer.print(request));
        var response = testBlockingStub.test(request);
        log.debug("{}: frAtomic: {}", processObject.getLmid(), printer.print(response));
        return response;
    }
}
