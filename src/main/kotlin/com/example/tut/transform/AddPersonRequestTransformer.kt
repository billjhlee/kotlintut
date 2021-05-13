package com.example.tut.transform

import com.example.tut.domain.Person
import com.example.tut.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer : Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
                id = 0,
                name = source.name,
            lastName = source.lastName
        )
    }
}