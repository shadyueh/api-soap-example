package br.gov.am.manaus.semef.tributario.api.soap.services;

import br.gov.am.manaus.semef.tributario.api.soap.dtos.IPTUDebitoConsultaDTO;
import br.gov.am.manaus.semef.tributario.api.soap.entities.IPTUDebito;

import java.util.List;

public interface IIPTUConsultaDebitoService {
    List<IPTUDebito> getIPTUDebito(String cpf, String mesAnoExercicio);

    List<IPTUDebito> getAllDebitos();

    List<IPTUDebitoConsultaDTO> getDebitosByCodigoBarras(String barcode);
}
