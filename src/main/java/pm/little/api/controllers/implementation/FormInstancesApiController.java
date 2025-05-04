package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import pm.little.api.controllers.FormInstancesApi;
import pm.little.api.models.FormInstance;
import pm.little.api.models.dto.FormDTO;
import pm.little.api.models.ids.FormInstanceId;
import pm.little.contentservice.FormService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.some-base-path:}") // Adjust path if needed
public class FormInstancesApiController implements FormInstancesApi {

    private final NativeWebRequest request;
    private final FormService formService;

    @Autowired
    public FormInstancesApiController(NativeWebRequest request, FormService formService) {
        this.request = request;
        this.formService = formService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /form-instances
     * List all form instances but return them as FormDTO.
     */
    @Override
    public ResponseEntity<List<FormDTO>> formInstancesGet(Integer limit, Integer offset, UUID userUuid) {
        if (limit == null || offset == null || userUuid == null) {
            return ResponseEntity.badRequest().build();
        }
        List<FormDTO> dtos = formService.listFormInstancesAsDTO(limit, offset);
        return ResponseEntity.ok(dtos);
    }

    /**
     * POST /form-instances
     * (Create a form instance)
     */
    @Override
    public ResponseEntity<FormDTO> formInstancesPost(FormInstance formInstance) {
        FormInstanceId id = formInstance.getId();
        if (id == null || id.getFormBlueprintUuid() == null || id.getUserUuid() == null || formInstance == null) {
            return ResponseEntity.badRequest().build();
        }
        FormDTO createdDTO = formService.createFormInstance(formInstance);
        return ResponseEntity.ok(createdDTO);
    }

    /**
     * GET /form-instances/{form_blueprint_uuid}/{user_uuid}
     * (Get a specific user’s form instance)
     */
    @Override
    public ResponseEntity<FormDTO> formInstancesFormBlueprintUuidUserUuidGet(
            UUID formBlueprintUuid,
            UUID userUuid
    ) {
        if (formBlueprintUuid == null || userUuid == null) {
            return ResponseEntity.badRequest().build();
        }
        FormDTO dto = formService.getFormInstance(formBlueprintUuid, userUuid);
        return ResponseEntity.ok(dto);
    }

    /**
     * PUT /form-instances/{form_blueprint_uuid}/{user_uuid}
     * (Update a form instance)
     */
    @Override
    public ResponseEntity<FormDTO> formInstancesFormBlueprintUuidUserUuidPut(
            UUID formBlueprintUuid,
            UUID userUuid,
            FormInstance formInstance
    ) {
        if (formBlueprintUuid == null || userUuid == null || formInstance == null) {
            return ResponseEntity.badRequest().build();
        }
        FormDTO updatedDTO = formService.updateFormInstance(formBlueprintUuid, userUuid, formInstance);
        return ResponseEntity.ok(updatedDTO);
    }

    /**
     * DELETE /form-instances/{form_blueprint_uuid}/{user_uuid}
     * (Delete a form instance)
     */
    @Override
    public ResponseEntity<Void> formInstancesFormBlueprintUuidUserUuidDelete(UUID formBlueprintUuid, UUID userUuid) {
        if (formBlueprintUuid == null || userUuid == null) {
            return ResponseEntity.badRequest().build();
        }
        formService.deleteFormInstance(formBlueprintUuid, userUuid);
        return ResponseEntity.noContent().build();
    }
}
