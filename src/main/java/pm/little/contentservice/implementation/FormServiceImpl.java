package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import pm.little.api.models.FormBlueprint;
import pm.little.api.models.FormFieldMapper;
import pm.little.api.models.FormInstance;
import pm.little.api.models.ids.FormFieldMapperId;
import pm.little.api.models.ids.FormInstanceId;
import pm.little.api.repositories.*;
import pm.little.contentservice.FormService;
import pm.little.contentservice.exceptions.FormBlueprintNotFoundException;
import pm.little.contentservice.exceptions.FormFieldNotFoundException;
import pm.little.contentservice.exceptions.FormInstanceNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormBlueprintRepository formBlueprintRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private FormFieldMapperRepository formFieldMapperRepository;

    @Autowired
    private FormInstanceRepository formInstanceRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public FormBlueprint createFormBlueprint(FormBlueprint blueprint) {
        return formBlueprintRepository.save(blueprint);
    }

    @Override
    public FormBlueprint getFormBlueprint(UUID formBlueprintUuid) {
        return formBlueprintRepository.findById(formBlueprintUuid)
                .orElseThrow(() -> new FormBlueprintNotFoundException(formBlueprintUuid));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public FormBlueprint updateFormBlueprint(UUID formBlueprintUuid, FormBlueprint blueprint) {
        FormBlueprint existing = getFormBlueprint(formBlueprintUuid);
        existing.setTitle(blueprint.getTitle());
        existing.setDescription(blueprint.getDescription());
        existing.setCallbackUrl(blueprint.getCallbackUrl());
        return formBlueprintRepository.save(existing);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFormBlueprint(UUID formBlueprintUuid) {
        formBlueprintRepository.deleteById(formBlueprintUuid);
    }

    @Override
    public List<FormBlueprint> listFormBlueprints(int limit, int offset) {
        return formBlueprintRepository.findAll(PageRequest.of(limit, limit)).getContent();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public FormFieldMapper createFormFieldMapper(FormFieldMapper mapper) {
        return formFieldMapperRepository.save(mapper);
    }

    @Override
    public FormFieldMapper getFormFieldMapper(UUID formBlueprintUuid, UUID formFieldUuid) {
        FormFieldMapperId id = new FormFieldMapperId()
                .formBlueprintUuid(formBlueprintUuid)
                .formFieldUuid(formFieldUuid);
        return formFieldMapperRepository.findById(id)
                .orElseThrow(() -> new FormFieldNotFoundException(id));
    }

    @Override
    public FormInstance createFormInstance(FormInstance instance) {
        return formInstanceRepository.save(instance);
    }

    @Override
    public FormInstance getFormInstance(UUID formBlueprintUuid, UUID userUuid) {
        FormInstanceId id = new FormInstanceId()
                .formBlueprintUuid(formBlueprintUuid)
                .userUuid(userUuid);
        return formInstanceRepository.findById(id)
                .orElseThrow(() -> new FormInstanceNotFoundException(id));
    }
}