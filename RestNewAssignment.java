package masai.com;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Test;

public class RestNewAssignment {

    @SuppressWarnings("unchecked")
	@Test
    public void placeAnOrder() {
        JSONObject js = new JSONObject();
        js.put("id", 1);
        js.put("petId", 101);
        js.put("quantity", 2);
        js.put("shipDate", "2025-05-13T11:03:08.957Z");
        js.put("status", "placed");
        js.put("complete", true);

        given()
            .contentType("application/json")
            .body(js.toJSONString())
        .when()
            .post("https://petstore.swagger.io/v2/store/order")
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void getOrderById() {
        given()
        .when()
            .get("https://petstore.swagger.io/v2/store/order/1")  // Use actual order ID
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void getInventory() {
        given()
        .when()
            .get("https://petstore.swagger.io/v2/store/inventory")
        .then()
            .statusCode(200)
            .log().all();
    }

    @Test
    public void deleteOrder() {
        given()
        .when()
            .delete("https://petstore.swagger.io/v2/store/order/1")  // Use existing order ID
        .then()
            .statusCode(200)
            .log().all();
    }
}
