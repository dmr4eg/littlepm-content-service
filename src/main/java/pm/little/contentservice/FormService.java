// FormService.java
package pm.little.contentservice;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import pm.little.api.models.FormBlueprint;
import pm.little.api.models.FormFieldMapper;
import pm.little.api.models.FormInstance;
import pm.little.api.models.dto.*;
import pm.little.api.models.ids.FormFieldMapperId;
import pm.little.api.models.ids.FormInstanceId;
import pm.little.contentservice.exceptions.FormBlueprintNotFoundException;
import pm.little.contentservice.exceptions.FormFieldNotFoundException;
import pm.little.contentservice.exceptions.FormInstanceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface FormService {

    public FormBlueprint createFormBlueprint(FormBlueprint blueprint) ;

    public FormBlueprint getFormBlueprint(UUID formBlueprintUuid) ;

    public FormBlueprint updateFormBlueprint(UUID formBlueprintUuid, FormBlueprint blueprint) ;

    public void deleteFormBlueprint(UUID formBlueprintUuid) ;

    public List<FormBlueprint> listFormBlueprints(int limit, int offset) ;

    public FormFieldMapper createFormFieldMapper(FormFieldMapper mapper) ;

    public FormFieldMapper getFormFieldMapper(UUID formBlueprintUuid, UUID formFieldUuid) ;

    public FormInstance createFormInstance(FormInstance instance) ;

    public FormInstance getFormInstance(UUID formBlueprintUuid, UUID userUuid) ;
}