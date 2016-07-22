package pl.training.bank.dto;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    public <ObjectToMap, DestinationType> DestinationType map(ObjectToMap objectToMap, Class<DestinationType> typeClass) {
        return new ModelMapper().map(objectToMap, typeClass);

    }

    public <Element, DestinationType>List<DestinationType> map(List<Element> objectsToMap, Class<DestinationType> typeClass) {
        ModelMapper modelMapper = new ModelMapper();
        return objectsToMap.stream()
                .map(element -> modelMapper.map(element, typeClass))
                .collect(Collectors.toList());
    }


}
