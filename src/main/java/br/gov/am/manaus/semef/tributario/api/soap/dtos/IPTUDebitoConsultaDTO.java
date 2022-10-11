package br.gov.am.manaus.semef.tributario.api.soap.dtos;

import java.sql.Date;

public interface IPTUDebitoConsultaDTO {
    public long getDebitoId();
    public String getCodigoBarras();
    public Date getDataVencimento();
    public Double getValorTotal();
    public String getImposto();
}
