package br.gov.am.manaus.semef.tributario.api.soap.services;

import br.gov.am.manaus.semef.tributario.api.soap.dtos.IPTUDebitoIdCodigoDTO;
import br.gov.am.manaus.semef.tributario.api.soap.entities.IPTUDebito;

import java.util.List;

public interface IIPTUConsultaDebitoService {
    List<IPTUDebito> getIPTUDebito(String cpf, String mesAnoExercicio);

    List<IPTUDebito> getAllDebitos();

    List<IPTUDebitoIdCodigoDTO> getDebitosByCodigoBarras(String barcode);
}
