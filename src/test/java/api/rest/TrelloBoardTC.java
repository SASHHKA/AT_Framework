package api.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import io.restassured.response.Response;
import mapper.models.CreateOrganizationResponse;
import mapper.models.GetOrganizationResponse;
import mapper.models.PutOrganizationResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class TrelloBoardTC {
    String key = "ba4cafbca3d32f5359579cf29d655c57";
    String token = "eb22d5987ae75b466c09d25049140b6c1518f8c3a3495f4717a48efa1502fef7";

    @BeforeTest
    void initRestAsured() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                new Jackson2ObjectMapperFactory() {
                    @Override
                    public ObjectMapper create(Type cls, String charset) {
                        ObjectMapper om = new ObjectMapper().findAndRegisterModules();
                        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        return om;
                    }

                }
        ));
    }

    @Test
    void createTest() {
        String name = UUID.randomUUID().toString();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("name", name);
        pathParams.put("key", key);
        pathParams.put("token", token);

        //Create Board


        Response postResponse = given()
                .queryParams(pathParams)
                .when()
                .contentType("application/json")
                .post("https://api.trello.com/1/boards");


        postResponse.then()
                .assertThat()
                .statusCode(200);

        CreateOrganizationResponse createOrganizationResponse = postResponse.body().as(CreateOrganizationResponse.class);


        //Get Organisation
        String id = createOrganizationResponse.getId();
        Response getResponse = given()
                .when()
                .accept("application/json")
                .get("https://api.trello.com/1/boards/" + id + "?key=" + key + "&token=" + token + "");

        getResponse.then()
                .assertThat()
                .statusCode(200);

        GetOrganizationResponse getOrganizationResponse = getResponse.body().as(GetOrganizationResponse.class);
        String getId = getOrganizationResponse.getId();


        //Put Organisation
        String newDisplayName = UUID.randomUUID().toString();
        String newDesc = UUID.randomUUID().toString();
        Map<String, String> putPathParams = new HashMap<>();
        putPathParams.put("key", key);
        putPathParams.put("token", token);
        putPathParams.put("displayName", newDisplayName);
        putPathParams.put("desc", newDesc);


        Response putResponse = given()
                .queryParams(putPathParams)
                .when()
                .accept("application/json")
                .put("https://api.trello.com/1/boards/" + getId + "");

        putResponse.then()
                .assertThat()
                .statusCode(200);

        PutOrganizationResponse putOrganizationResponse = putResponse.body().as(PutOrganizationResponse.class);


        //Get Updated Organization
        String getUpdatedId = putOrganizationResponse.getId();
        Response getUpdateResponse = given()
                .when()
                .accept("application/json")
                .get("https://api.trello.com/1/boards/" + getUpdatedId + "?key=" + key + "&token=" + token + "");

        getUpdateResponse.then()
                .assertThat()
                .statusCode(200);

    }
}
