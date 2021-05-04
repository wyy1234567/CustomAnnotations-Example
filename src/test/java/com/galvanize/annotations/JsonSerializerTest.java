package com.galvanize.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.galvanize.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class JsonSerializerTest {

    @Test
    @DisplayName("Should return serialized Json string for a Person instance")
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person person = new Person("yueying", "wang", "100");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String expected = "{\"personAge\":\"100\",\"firstName\":\"Yueying\",\"lastName\":\"Wang\"}";
        String actual = serializer.convertToJson(person);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw exception if given object is not serializable")
    public void shouldThrowExceptionIfObjectIsNotSerializable() throws JsonSerializationException {
        List<String> list = new LinkedList<>();
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        assertThrows(JsonSerializationException.class, () -> {
            serializer.convertToJson(list);
        });
    }

}