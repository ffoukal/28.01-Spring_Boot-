package com.example.diploma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	void shoulReturnDiplomaWithCongrats() throws Exception
	{
		this.mockMvc.perform(post("/diploma")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"nombre\": \"Lucas Martinez\",\n" +
						"    \"asignaturas\": [\n" +
						"        {\n" +
						"            \"nombre\": \"Analisis Matematico\",\n" +
						"            \"nota\": 8\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\": \"Analisis Matematico II\",\n" +
						"            \"nota\": 10\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\": \"Metodos Numericos\",\n" +
						"            \"nota\": 9\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\": \"Química\",\n" +
						"            \"nota\": 9\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"alumno\": {\n" +
						"        \"nombre\": \"Lucas Martinez\",\n" +
						"        \"asignaturas\": [\n" +
						"            {\n" +
						"                \"nombre\": \"Analisis Matematico\",\n" +
						"                \"nota\": 8\n" +
						"            },\n" +
						"            {\n" +
						"                \"nombre\": \"Analisis Matematico II\",\n" +
						"                \"nota\": 10\n" +
						"            },\n" +
						"            {\n" +
						"                \"nombre\": \"Metodos Numericos\",\n" +
						"                \"nota\": 9\n" +
						"            },\n" +
						"            {\n" +
						"                \"nombre\": \"Química\",\n" +
						"                \"nota\": 9\n" +
						"            }\n" +
						"        ]\n" +
						"    },\n" +
						"    \"promedio\": 9.0,\n" +
						"    \"mensaje\": \"Extendemos nuestras felicitaciones por su excelente desempenio\"\n" +
						"}"));
	}

}
