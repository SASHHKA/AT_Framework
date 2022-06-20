package mapper;

import mapper.models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class ResponseMapper {

    public static GetOrganizationResponse getOrganizationResponseToObject (HttpResponse<String> response) {
        GetOrganizationResponse getOrganizationResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            getOrganizationResponse = objectMapper.readValue(response.body(), GetOrganizationResponse.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return getOrganizationResponse;
    }
    public static CreateOrganizationResponse organizationResponseToObject(HttpResponse<String> response) {
        CreateOrganizationResponse createOrganizationResponse = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            createOrganizationResponse = objectMapper.readValue(response.body(), CreateOrganizationResponse.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return createOrganizationResponse;
    }


}
