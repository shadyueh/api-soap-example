package br.gov.am.manaus.semef.tributario.api.soap.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "IPTUDebito")
public class IPTUDebito implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long debitoId;

    @Column(name = "imposto")
    private String imposto;

    @Column(name = "matricula")
    private long matricula;

    @Column(name = "ano")
    private int ano;

    @Column(name = "parcela")
    private int numeroParcela;

    @Column(name = "dtvenc")
    private Date dataVencimento;

    @Column(name = "codigodebarras")
    private String codigoBarras;

    @Column(name = "vloriginal")
    private BigDecimal valorOriginal;

    @Column(name = "vlcorrecao")
    private BigDecimal valorCorrecao;

    @Column(name = "vlmultas")
    private BigDecimal valorMultas;

    @Column(name = "vljuros")
    private BigDecimal valorJuros;

    @Column(name = "vltotal")
    private BigDecimal valorTotal;

}
