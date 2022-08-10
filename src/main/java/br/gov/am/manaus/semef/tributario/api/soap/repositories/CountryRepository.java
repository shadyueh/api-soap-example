package br.gov.am.manaus.semef.tributario.api.soap.repositories;

import br.gov.am.manaus.semef.tributario.api.soap.models.Country;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}