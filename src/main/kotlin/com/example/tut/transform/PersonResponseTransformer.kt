package com.example.tut.transform

import com.example.tut.domain.Person
import com.example.tut.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.name} ${this?.lastName}"
    )
}
