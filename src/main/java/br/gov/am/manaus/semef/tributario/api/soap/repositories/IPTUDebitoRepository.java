package br.gov.am.manaus.semef.tributario.api.soap.repositories;

import br.gov.am.manaus.semef.tributario.api.soap.dtos.IPTUDebitoConsultaDTO;
import br.gov.am.manaus.semef.tributario.api.soap.entities.IPTUDebito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPTUDebitoRepository extends CrudRepository<IPTUDebito, Long> {

    List<IPTUDebito> findByNumeroParcelaAndAno(String cpf, String date);

    List<IPTUDebitoConsultaDTO> findByCodigoBarras(String barcode);
}
