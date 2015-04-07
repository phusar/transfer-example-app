package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result addTransfer() {
        JsonNode json = request().body().asJson();
        String name = json.findPath("name").asText();
        if(name == null) {
            return badRequest("Missing parameter [name]");
        } else {
            return ok("Hello " + name);
        }
    }

    public static Result testerForm() {
        return ok(testerForm.render());
    }

}
