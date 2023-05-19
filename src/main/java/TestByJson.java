
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;

public class TestByJson {

    @Test
    void validateAddressByZipCode(){
        given()
                .when()
                .get("https://viacep.com.br/ws/01001000/json/")
                .then()
                .statusCode(200)
                .body("cep", containsString("01001-000"))
                .body("logradouro", containsString("Praça da Sé"))
                .body("complemento", containsString("lado ímpar"))
                .body("bairro", containsString("Sé"))
                .body("localidade", containsString("São Paulo"))
                .body("uf", containsString("SP"))
                .body("ibge", containsString("3550308"))
                .body("gia", containsString("1004"))
                .body("ddd", containsString("11"))
                .body("siafi", containsString("7107"));

    }
    @Test
    void validateAddressByStreetName(){
        given()
                .when()
                .get("https://viacep.com.br/ws/SC/Florianopolis/Rua+Marinas+do+Campeche/json/")
                .then()
                .statusCode(200)
                .body("[0].cep", containsString("88065-185"))
                .body("[0].logradouro", containsString("Rua Marinas do Campech"))
                .body("[0].bairro", containsString("Campeche"))
                .body("[0].localidade", containsString("Florianópolis"))
                .body("[0].uf", containsString(""))
                .body("[0].ibge", containsString("4205407"))
                .body("[0].ddd", containsString("48"))
                .body("[0].siafi", containsString("8105"));
    }

}
