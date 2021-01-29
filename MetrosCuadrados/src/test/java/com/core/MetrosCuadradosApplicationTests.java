package com.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class MetrosCuadradosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnJSONResponse() throws Exception
	{
		this.mockMvc.perform(post("/cotizar")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"nombre\": \"Casa barrio General Paz\",\n" +
						"    \"direccion\": \"Av. 27 de Septiembre 2545\",\n" +
						"    \"habitaciones\": [\n" +
						"        {\n" +
						"            \"nombre\": \"Living\",\n" +
						"            \"ancho\": 5,\n" +
						"            \"largo\": 6\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\": \"Habitacion\",\n" +
						"            \"ancho\": 4,\n" +
						"            \"largo\": 4\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\": \"Baño\",\n" +
						"            \"ancho\": 2,\n" +
						"            \"largo\": 3\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"totalMetrosCuadrados\": 52.0,\n" +
						"    \"precioCasa\": 41600.0,\n" +
						"    \"habitacionMasGrande\": {\n" +
						"        \"nombre\": \"Living\",\n" +
						"        \"ancho\": 5.0,\n" +
						"        \"largo\": 6.0\n" +
						"    },\n" +
						"    \"metrosCuadradosPorHabitacion\": {\n" +
						"        \"Baño\": 6.0,\n" +
						"        \"Living\": 30.0,\n" +
						"        \"Habitacion\": 16.0\n" +
						"    }\n" +
						"}"));
	}

}
