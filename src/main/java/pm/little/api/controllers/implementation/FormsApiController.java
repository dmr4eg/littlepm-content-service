package pm.little.api.controllers.implementation;

import jakarta.annotation.Generated;
import pm.little.api.controllers.FormsApi;
import pm.little.api.models.FormBlueprint;
import pm.little.api.models.FormField;
import pm.little.api.models.FormFieldMapper;
import pm.little.api.models.FormsFormBlueprintUuidFieldsFieldUuidPutRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;


import java.util.Optional;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-26T00:36:51.210059+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
@Controller
@RequestMapping("${openapi.projectDay.base-path:}")
public class FormsApiController implements FormsApi {

    private final NativeWebRequest request;

    @Autowired
    public FormsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
