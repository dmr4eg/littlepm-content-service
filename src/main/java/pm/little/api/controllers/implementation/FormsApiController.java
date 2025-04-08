package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import pm.little.api.controllers.FormsApi;
import pm.little.api.models.FormBlueprint;
import pm.little.contentservice.FormService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.some-base-path:}") // Adjust path if needed
public class FormsApiController implements FormsApi {

    private final NativeWebRequest request;
    private final FormService formService;

    @Autowired
    public FormsApiController(NativeWebRequest request, FormService formService) {
        this.request = request;
        this.formService = formService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /forms?limit=...&offset=...
     */
    @Override
    public ResponseEntity<List<FormBlueprint>> formsGet(Integer limit, Integer offset) {
        if (limit == null || offset == null) {
            return ResponseEntity.badRequest().build();
        }
        List<FormBlueprint> formBlueprints = formService.listFormBlueprints(limit, offset);
        return ResponseEntity.ok(formBlueprints);
    }

    /**
     * POST /forms
     * (Create a new form blueprint, admin only)
     */
    @Override
    public ResponseEntity<FormBlueprint> formsPost(FormBlueprint formBlueprint) {
        if (formBlueprint == null) {
            return ResponseEntity.badRequest().build();
        }
        FormBlueprint created = formService.createFormBlueprint(formBlueprint);
        return ResponseEntity.ok(created);
    }

    /**
     * GET /forms/{form_blueprint_uuid}
     */
    @Override
    public ResponseEntity<FormBlueprint> formsFormBlueprintUuidGet(UUID formBlueprintUuid) {
        if (formBlueprintUuid == null) {
            return ResponseEntity.badRequest().build();
        }
        FormBlueprint blueprint = formService.getFormBlueprint(formBlueprintUuid);
        return ResponseEntity.ok(blueprint);
    }

    /**
     * PUT /forms/{form_blueprint_uuid}
     * (Update an existing form blueprint, admin only)
     */
    @Override
    public ResponseEntity<FormBlueprint> formsFormBlueprintUuidPut(UUID formBlueprintUuid, FormBlueprint formBlueprint) {
        if (formBlueprintUuid == null || formBlueprint == null) {
            return ResponseEntity.badRequest().build();
        }
        FormBlueprint updated = formService.updateFormBlueprint(formBlueprintUuid, formBlueprint);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /forms/{form_blueprint_uuid}
     * (Delete a form blueprint, admin only)
     */
    @Override
    public ResponseEntity<Void> formsFormBlueprintUuidDelete(UUID formBlueprintUuid) {
        if (formBlueprintUuid == null) {
            return ResponseEntity.badRequest().build();
        }
        formService.deleteFormBlueprint(formBlueprintUuid);
        return ResponseEntity.noContent().build();
    }
}
