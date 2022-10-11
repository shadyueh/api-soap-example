package br.gov.am.manaus.semef.tributario.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import br.gov.am.manaus.semef.tributario.api.soap.dtos.IPTUDebitoIdCodigoDTO;
import br.gov.am.manaus.semef.tributario.api.soap.services.IIPTUConsultaDebitoService;

@Sql({ "/data.sql" })
@SpringBootTest
class APIControlApplicationTests {

	@Autowired
	private IIPTUConsultaDebitoService iptuDebitoService;

	@Test
	void contextLoads() {
	}

	@Test
	void iptuDebitoDtoWorks() {
		List<IPTUDebitoIdCodigoDTO> res = iptuDebitoService.getDebitosByCodigoBarras("678876678");
		assertEquals(res.size(), 1);
		assertNotNull(res.get(0).getDebitoId());
	}

}
