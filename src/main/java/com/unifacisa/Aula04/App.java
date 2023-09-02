package com.unifacisa.Aula04;


import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
	public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, getPessoas());
        System.out.println(writer);

       
        // Deserialize
        String jsonInput = "[{\"id\":1,\"nome\":\"Lucas\"},{\"id\":2,\"nome\":\"Maria\"},{\"id\":3,\"nome\":\"Jose\"}]";
        List<Pessoa> p = mapper.readValue(jsonInput, new TypeReference<List<Pessoa>>(){});
        System.out.println("Pessoa: " + p);
        
        // criar e salvar o o arquivo.json no computador
        try {
			FileWriter escrito = new FileWriter("arquivo.json");
			escrito.write(jsonInput);
			escrito.close();;
		} catch (Exception e) {
			System.out.println("Erro ao escrever no arquivo: "+ e.getMessage());
		}

    }
	
    private static List<Pessoa> getPessoas() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
        p1.setIdade(22);
        p1.setSobrenome("Fulano");
        p1.setCPF("12345678910");

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
        p2.setIdade(28);
        p2.setSobrenome("Almeida");
        p2.setCPF("123452181812");

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        p2.setIdade(59);
        p2.setSobrenome("Barros");
        p2.setCPF("14845959952");

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        return pessoas;

    }
}