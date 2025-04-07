// FormService.java
package pm.little.contentservice;

import org.springframework.data.domain.PageRequest;
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

    public int getFormFieldMapperOrder(UUID formBlueprintUuid, UUID fieldUuid) ;

    public List<FormBlueprint> listFormBlueprints(int limit, int offset) ;

    public FormFieldMapper createFormFieldMapper(FormFieldMapper mapper, int sortOrder) ;

    public FormFieldMapper getFormFieldMapper(UUID formBlueprintUuid, UUID fieldUuid) ;

    public FormDTO createFormInstance(FormInstance instance) ;

    public FormDTO getFormInstance(UUID formBlueprintUuid, UUID userUuid) ;

    public List<FormInstance> listFormInstances(int limit, int offset);

    public List<FormDTO> listFormInstancesAsDTO(int limit, int offset);

    public FormDTO updateFormInstance(UUID formBlueprintUuid, UUID userUuid, FormInstance updated);

    public void deleteFormInstance(UUID formBlueprintUuid, UUID userUuid);

    public List<FormFieldMapper> listFormFieldMappers(int limit, int offset);

    public FormFieldMapper updateFormFieldMapper(UUID formBlueprintUuid, UUID fieldUuid, FormFieldMapper updated);

    public void deleteFormFieldMapper(UUID formBlueprintUuid, UUID fieldUuid);

}