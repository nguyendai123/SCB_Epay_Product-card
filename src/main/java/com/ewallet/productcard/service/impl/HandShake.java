package com.ewallet.productcard.service.impl;


import com.ewallet.objects.ProcessObject;
import com.ewallet.objects.base.EWalletResponse;
import com.ewallet.productcard.dto.EWalletHandShakeObject;
import com.ewallet.productcard.service.atomic.HelloService;
import com.ewallet.service.FunctionBase;
import com.google.protobuf.util.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.ewallet.objects.Constants.EWalletResponseCode.SUCCESS;
import static com.ewallet.util.SerializerUtil.deserialize;
import static com.ewallet.util.SerializerUtil.serialize;

@Service("eWalletHandShake")
@Slf4j
@RequiredArgsConstructor
public class HandShake extends FunctionBase {

    private final HelloService helloService;
    private final JsonFormat.Printer printer;

    @Override
    @SneakyThrows
    public String execute(ProcessObject processObject) {
        var resultAtomic = helloService.receiveGreeting(processObject);
        EWalletResponse response = processObject.getResponseObject();
        var obj = deserialize(processObject.getRequestObject().getData(), EWalletHandShakeObject.class);
        obj.setDesKey("sfbn9823ufrwoiejfl2387rywikfrhdf9823425rrgdfG");
        obj.setPinPublicKeyExponent("njrkfi2yu0f9ip2oefjksdlfjsuidfy09fup2ji3flksdhf");
        obj.setPinPublicKeyModulus(printer.print(resultAtomic));
        response.setRespCode(SUCCESS);

        response.setData(serialize(obj));
        return processObject.response(response);
    }
}
