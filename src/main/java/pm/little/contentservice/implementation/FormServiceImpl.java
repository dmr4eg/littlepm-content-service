package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pm.little.api.models.FormBlueprint;
import pm.little.api.models.FormFieldMapper;
import pm.little.api.models.FormInstance;
import pm.little.api.models.dto.FormDTO;
import pm.little.api.models.ids.FormFieldMapperId;
import pm.little.api.models.ids.FormInstanceId;
import pm.little.api.repositories.*;
import pm.little.contentservice.FormService;
import pm.little.contentservice.exceptions.FormBlueprintNotFoundException;
import pm.little.contentservice.exceptions.FormFieldNotFoundException;
import pm.little.contentservice.exceptions.FormInstanceNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public FormFieldMapper createFormFieldMapper(FormFieldMapper mapper, int sortOrder) {
        FormFieldMapper existing = formFieldMapperRepository.findById(mapper.getId()).orElse(null);
        if (existing != null) {
            return existing;
        }
        mapper.setOrder(sortOrder);
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

    private FormDTO toFormDTO(FormInstance instance) {
        // We find the associated blueprint (assuming it should be attached in the DTO).
        UUID blueprintUuid = instance.getId().getFormBlueprintUuid();
        FormBlueprint blueprint = formBlueprintRepository.findById(blueprintUuid)
                .orElseThrow(() -> new FormBlueprintNotFoundException(blueprintUuid));

        // Build the DTO
        FormDTO dto = new FormDTO();
        dto.setBlueprint(blueprint);
        dto.setInstance(instance);
        return dto;
    }

    // ------------------------------------------------------------------------
    // Form Instance methods returning FormDTO
    // ------------------------------------------------------------------------

    @Override
    public FormDTO createFormInstance(FormInstance instance) {
        FormInstance existing = formInstanceRepository.findById(instance.getId()).orElse(null);
        if (existing != null) {
            // If it already exists, just return the DTO of that existing instance
            return toFormDTO(existing);
        }
        FormInstance saved = formInstanceRepository.save(instance);
        return toFormDTO(saved);
    }

    @Override
    public FormDTO getFormInstance(UUID formBlueprintUuid, UUID userUuid) {
        FormInstanceId id = new FormInstanceId(formBlueprintUuid, userUuid);
        FormInstance instance = formInstanceRepository.findById(id)
                .orElseThrow(() -> new FormInstanceNotFoundException(id));
        return toFormDTO(instance);
    }

    @Override
    public FormDTO updateFormInstance(UUID formBlueprintUuid, UUID userUuid, FormInstance updated) {
        FormInstanceId id = new FormInstanceId(formBlueprintUuid, userUuid);

        // Make sure it exists:
        if (!formInstanceRepository.existsById(id)) {
            throw new FormInstanceNotFoundException(id);
        }

        // Load existing, update its fields:
        FormInstance existing = formInstanceRepository.findById(id)
                .orElseThrow(() -> new FormInstanceNotFoundException(id));
        existing.setStatus(updated.getStatus());
        // ...update any other fields you want here...

        FormInstance saved = formInstanceRepository.save(existing);
        return toFormDTO(saved);
    }

    @Override
    public void deleteFormInstance(UUID formBlueprintUuid, UUID userUuid) {
        FormInstanceId id = new FormInstanceId(formBlueprintUuid, userUuid);
        if (!formInstanceRepository.existsById(id)) {
            throw new FormInstanceNotFoundException(id);
        }
        formInstanceRepository.deleteById(id);
    }

    /**
     * Return the raw FormInstances or optionally wrap them into FormDTOs.
     * That depends on your preference.
     */
    @Override
    public List<FormInstance> listFormInstances(int limit, int offset){
        Pageable pageable = PageRequest.of(offset, limit);
        return formInstanceRepository.findAll(pageable).getContent();
    }

    @Override
    public List<FormDTO> listFormInstancesAsDTO(int limit, int offset){
        return listFormInstances(limit, offset)
                .stream()
                .map(this::toFormDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<FormFieldMapper> listFormFieldMappers(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        return formFieldMapperRepository.findAll(pageable).getContent();
    }

    @Override
    public FormFieldMapper updateFormFieldMapper(UUID formBlueprintUuid, UUID formFieldUuid, FormFieldMapper updated) {
        FormFieldMapperId id = new FormFieldMapperId(formBlueprintUuid, formFieldUuid);
        if (!formFieldMapperRepository.existsById(id)) {
            throw new FormFieldNotFoundException(id);
        }
        FormFieldMapper existing = getFormFieldMapper(formBlueprintUuid, formFieldUuid);
        existing.setOrder(updated.getOrder());
        return formFieldMapperRepository.save(existing);
    }

    @Override
    public void deleteFormFieldMapper(UUID formBlueprintUuid, UUID formFieldUuid){
        FormFieldMapperId id = new FormFieldMapperId(formBlueprintUuid, formFieldUuid);
        if (!formFieldMapperRepository.existsById(id)) {
            throw new FormFieldNotFoundException(id);
        }
        formFieldMapperRepository.deleteById(id);
    }

}