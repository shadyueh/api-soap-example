package br.gov.am.manaus.semef.tributario.api.soap.endpoints;

import br.gov.am.manaus.semef.tributario.api.soap.configs.WebServiceConfig;
import br.gov.am.manaus.semef.tributario.api.soap.models.GetCountryRequest;
import br.gov.am.manaus.semef.tributario.api.soap.models.GetCountryResponse;
import br.gov.am.manaus.semef.tributario.api.soap.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
