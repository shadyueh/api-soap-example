package br.gov.am.manaus.semef.tributario.api.soap.endpoints;

import br.gov.am.manaus.semef.tributario.api.soap.configs.WebServiceConfig;
import br.gov.am.manaus.semef.tributario.api.soap.entities.IPTUDebito;
import br.gov.am.manaus.semef.tributario.api.soap.services.IIPTUDebitoService;
import br.gov.am.manaus.semef.tributario.ws.IPTUDebitoInfo;
import br.gov.am.manaus.semef.tributario.ws.GetAllIPTUDebitosResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class IPTUDebitoEndpoint {

    @Autowired
    private IIPTUDebitoService iptuDebitoService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getAllIPTUDebitosRequest")
    @ResponsePayload
    public GetAllIPTUDebitosResponse getAllIPTUDebitos() {
        GetAllIPTUDebitosResponse response = new GetAllIPTUDebitosResponse();
        List<IPTUDebitoInfo> iptuDebitoInfoList = new ArrayList<>();
        List<IPTUDebito> iptuDebitoList = iptuDebitoService.getAllDebitos();
        for (int i = 0; i < iptuDebitoList.size(); i++) {
            IPTUDebitoInfo ob = new IPTUDebitoInfo();
            BeanUtils.copyProperties(iptuDebitoList.get(i), ob);
            iptuDebitoInfoList.add(ob);
        }
        response.getIptuDebitoInfo().addAll(iptuDebitoInfoList);
        return response;
    }
}
