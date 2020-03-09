package ua.ek.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ClassConverter {
    public static <T> List<T> cast(Class<T> clazz, List<?> items){
        return items.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }
}