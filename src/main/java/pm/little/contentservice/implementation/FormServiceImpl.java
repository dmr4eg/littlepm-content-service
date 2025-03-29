package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private final FormBlueprintRepository formBlueprintRepository;
    private final FieldRepository fieldRepository;
    private final FormFieldMapperRepository formFieldMapperRepository;
    private final FormInstanceRepository formInstanceRepository;

    public FormServiceImpl(
            FormBlueprintRepository formBlueprintRepository,
            FieldRepository fieldRepository,
            FormFieldMapperRepository formFieldMapperRepository,
            FormInstanceRepository formInstanceRepository
    ) {
        this.formBlueprintRepository = formBlueprintRepository;
        this.fieldRepository = fieldRepository;
        this.formFieldMapperRepository = formFieldMapperRepository;
        this.formInstanceRepository = formInstanceRepository;
    }


    @Override
    public FormBlueprint createFormBlueprint(FormBlueprint blueprint) {
        FormBlueprint existing = formBlueprintRepository.findById(blueprint.getFormBlueprintUuid()).orElse(null);
        if (existing != null) {
            return existing;
        }
        return formBlueprintRepository.save(blueprint);
    }

    @Override
    public FormBlueprint getFormBlueprint(UUID formBlueprintUuid) {
        if (!formBlueprintRepository.existsById(formBlueprintUuid)) {
            throw new FormBlueprintNotFoundException(formBlueprintUuid);
        }
        return formBlueprintRepository.findById(formBlueprintUuid)
                .orElseThrow(() -> new FormBlueprintNotFoundException(formBlueprintUuid));
    }

    @Override
    public FormBlueprint updateFormBlueprint(UUID formBlueprintUuid, FormBlueprint blueprint) {
        if (!formBlueprintRepository.existsById(formBlueprintUuid)) {
            throw new FormBlueprintNotFoundException(formBlueprintUuid);
        }
        FormBlueprint existing = getFormBlueprint(formBlueprintUuid);
        existing.setTitle(blueprint.getTitle());
        existing.setDescription(blueprint.getDescription());
        existing.setCallbackUrl(blueprint.getCallbackUrl());
        return formBlueprintRepository.save(existing);
    }

    @Override
    public void deleteFormBlueprint(UUID formBlueprintUuid) {
        if (!formBlueprintRepository.existsById(formBlueprintUuid)) {
            throw new FormBlueprintNotFoundException(formBlueprintUuid);
        }
        formBlueprintRepository.deleteById(formBlueprintUuid);
    }

    @Override
    public List<FormBlueprint> listFormBlueprints(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        return formBlueprintRepository.findAll(pageable).getContent();
    }

    @Override
    public FormFieldMapper createFormFieldMapper(FormFieldMapper mapper, int order) {
        FormFieldMapper existing = formFieldMapperRepository.findById(mapper.getId()).orElse(null);
        if (existing != null) {
            return existing;
        }
        mapper.setOrder(order);
        return formFieldMapperRepository.save(mapper);
    }

    @Override
    public FormFieldMapper getFormFieldMapper(UUID formBlueprintUuid, UUID formFieldUuid) {
        FormFieldMapperId id = new FormFieldMapperId(formBlueprintUuid, formFieldUuid);
        if (!formFieldMapperRepository.existsById(id)) {
            throw new FormFieldNotFoundException(id);
        }
        return formFieldMapperRepository.findById(id)
                .orElseThrow(() -> new FormFieldNotFoundException(id));
    }

    @Override
    public int getFormFieldMapperOrder(UUID formBlueprintUuid, UUID formFieldUuid) {
        FormFieldMapperId id = new FormFieldMapperId(formBlueprintUuid, formFieldUuid);
        if (!formFieldMapperRepository.existsById(id)) {
            throw new FormFieldNotFoundException(id);
        }
        return formFieldMapperRepository.findById(id)
                .orElseThrow(() -> new FormFieldNotFoundException(id))
                .getOrder();
    }

    @Override
    public FormInstance createFormInstance(FormInstance instance) {
        FormInstance existing = formInstanceRepository.findById(instance.getId()).orElse(null);
        if (existing != null) {
            return existing;
        }
        return formInstanceRepository.save(instance);
    }

    @Override
    public FormInstance getFormInstance(UUID formBlueprintUuid, UUID userUuid) {
        FormInstanceId id = new FormInstanceId(formBlueprintUuid, userUuid);
        if (!formInstanceRepository.existsById(id)) {
            throw new FormInstanceNotFoundException(id);
        }
        return formInstanceRepository.findById(id)
                .orElseThrow(() -> new FormInstanceNotFoundException(id));
    }
}