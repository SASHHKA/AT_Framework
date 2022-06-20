package api;


import client.TrelloHTTPClient;
import mapper.ResponseMapper;
import mapper.models.GetOrganizationResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

import static mapper.ResponseMapper.*;
import static org.testng.Assert.assertEquals;

public class UpdateOrganizationTC {

    @DataProvider
    public Object[][] updateOrganizationDP() {
        return new Object[][] {
                {"Test1", "Test1", "description1", "Test2", "Test2", "description2"}

        };
    }

    // End to end flow

    @Test(dataProvider = "updateOrganizationDP")
    public void updateOrganizationTest(String organizationName, String linkName, String description, String newOrganizationName, String newLinkName, String newDescription) throws InterruptedException, IOException, URISyntaxException {
        TrelloHTTPClient client = new TrelloHTTPClient();
        HttpResponse<String> createOrganizationResponse = client.createOrganization(organizationName, linkName, description);
        assertEquals(createOrganizationResponse.statusCode(), 200);
        String organizationId = ResponseMapper.organizationResponseToObject(createOrganizationResponse).getId();
        System.out.println(organizationId);
        HttpResponse<String> updateOrganizationResponse = client.updateOrganization(organizationId, newOrganizationName, newLinkName, newDescription);
        assertEquals(updateOrganizationResponse.statusCode(), 200);
        GetOrganizationResponse actual = getOrganizationResponseToObject(client.getOrganization(organizationId));
        GetOrganizationResponse expected = new GetOrganizationResponse();
        expected.setName(newLinkName);
        expected.setDisplayName(newOrganizationName);
        expected.setDesc(newDescription);
        expected.setId(String.valueOf(organizationId));
        assertEquals(actual, expected);

    }
}
