package br.gov.am.manaus.semef.tributario.api.soap.services;

import br.gov.am.manaus.semef.tributario.api.soap.entities.IPTUDebito;
import br.gov.am.manaus.semef.tributario.api.soap.repositories.IPTUDebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPTUConsultaConsultaDebitoService implements IIPTUConsultaDebitoService {

    @Autowired
    private IPTUDebitoRepository iptuDebitoRepository;

    @Override
    public List<IPTUDebito> getIPTUDebito(String cpf, String mesAnoExercicio) {
        List<IPTUDebito> list = new ArrayList<>();
        iptuDebitoRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public List<IPTUDebito> getAllDebitos() {
        List<IPTUDebito> list = new ArrayList<>();
        iptuDebitoRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
