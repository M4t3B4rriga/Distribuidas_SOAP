package com.soap.client;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.soap.wsdl.Add;
import com.soap.wsdl.AddResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {
    public AddResponse getAddResponse(int number1, int number2) {
        Add request = new Add();
        request.setIntA(number1);
        request.setIntB(number2);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");
        AddResponse addResponse = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, soapActionCallback);
        return addResponse;
    }
}
