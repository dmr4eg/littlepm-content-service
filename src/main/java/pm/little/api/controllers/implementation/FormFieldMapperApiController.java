package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import pm.little.api.controllers.FormFieldMapperApi;
import pm.little.api.models.FormFieldMapper;
import pm.little.contentservice.FormService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.some-base-path:}") // Adjust path if needed
public class FormFieldMapperApiController implements FormFieldMapperApi {

    private final NativeWebRequest request;
    private final FormService formService;

    @Autowired
    public FormFieldMapperApiController(NativeWebRequest request, FormService formService) {
        this.request = request;
        this.formService = formService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /form-field-mapper
     * (List all form-field mappings)
     *
     * If needed, add something like:
     *   List<FormFieldMapper> listFormFieldMappers(int limit, int offset);
     * to FormService, and implement similarly to others.
     * Otherwise, return 501 if not supported.
     */
    @Override
    public ResponseEntity<List<FormFieldMapper>> formFieldMapperGet(
            Integer limit,
            Integer offset,
            UUID userUuid
    ) {
        // Example if you implement:
         List<FormFieldMapper> mappers = formService.listFormFieldMappers(100, 0);
         return ResponseEntity.ok(mappers);
    }

    /**
     * POST /form-field-mapper
     * (Create a form-field mapping, admin only)
     */
    @Override
    public ResponseEntity<FormFieldMapper> formFieldMapperPost(FormFieldMapper formFieldMapper) {
        // The sort order can come from formFieldMapper.getOrder().
        FormFieldMapper created = formService.createFormFieldMapper(formFieldMapper, formFieldMapper.getOrder());
        return ResponseEntity.ok(created);
    }

    /**
     * GET /form-field-mapper/{form_blueprint_uuid}/{form_field_uuid}
     */
    @Override
    public ResponseEntity<FormFieldMapper> formFieldMapperFormBlueprintUuidFieldUuidGet(
            UUID formBlueprintUuid,
            UUID fieldUuid
    ) {
        FormFieldMapper mapper = formService.getFormFieldMapper(formBlueprintUuid, fieldUuid);
        return ResponseEntity.ok(mapper);
    }

    /**
     * PUT /form-field-mapper/{form_blueprint_uuid}/{form_field_uuid}
     * (Update a form-field mapping)
     *
     * If you need an update method (e.g. to adjust sort order),
     * add something like:
     *   FormFieldMapper updateFormFieldMapper(UUID formBlueprintUuid, UUID fieldUuid, FormFieldMapper updated);
     * to the service. Otherwise, return 501 if not implemented.
     */
    @Override
    public ResponseEntity<FormFieldMapper> formFieldMapperFormBlueprintUuidFieldUuidPut(
            UUID formBlueprintUuid,
            UUID fieldUuid,
            FormFieldMapper formFieldMapper
    ) {
         FormFieldMapper updated = formService.updateFormFieldMapper(formBlueprintUuid, fieldUuid, formFieldMapper);
         return ResponseEntity.ok(updated);


    }

    /**
     * DELETE /form-field-mapper/{form_blueprint_uuid}/{form_field_uuid}
     */
    @Override
    public ResponseEntity<Void> formFieldMapperFormBlueprintUuidFieldUuidDelete(
            UUID formBlueprintUuid,
            UUID fieldUuid
    ) {
         formService.deleteFormFieldMapper(formBlueprintUuid, fieldUuid);
         return ResponseEntity.noContent().build();
    }
}
