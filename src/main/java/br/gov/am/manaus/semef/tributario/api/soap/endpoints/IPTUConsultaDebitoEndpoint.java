package br.gov.am.manaus.semef.tributario.api.soap.endpoints;

import br.gov.am.manaus.semef.tributario.api.soap.services.IIPTUConsultaDebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class IPTUConsultaDebitoEndpoint {

    @Autowired
    private IIPTUConsultaDebitoService iptuDebitoService;

    @PayloadRoot(namespace = "urn:iso:std:iso:20022:tech:xsd:bill:info:candidate:in", localPart = "IPTUTypeRequest")
    @ResponsePayload
    public IPTUTypeResponse getIptuDebito(@RequestPayload IPTUTypeRequest req) {
        IPTUTypeResponse res = new IPTUTypeResponse();
        res.setPrprtyEnrollment("999888999");
        return res;
    }
}
