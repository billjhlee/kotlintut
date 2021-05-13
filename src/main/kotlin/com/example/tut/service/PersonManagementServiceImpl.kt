package com.example.tut.service

import com.example.tut.dao.PersonDao
import com.example.tut.domain.Person
import com.example.tut.dto.AddPersonRequest
import com.example.tut.dto.PersonResponse
import com.example.tut.dto.UpdatePersonRequest
import com.example.tut.transform.AddPersonRequestTransformer
import com.example.tut.transform.toPersonResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class PersonManagementServiceImpl(@Autowired private val personDao: PersonDao, private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagementService {
    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()

    override fun findAll(pageable:Pageable): Page<PersonResponse> = this.personDao.findAll(pageable).map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(addPersonRequestTransformer.transform(addPersonRequest))
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")

        return this.saveOrUpdate(person.apply{
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}