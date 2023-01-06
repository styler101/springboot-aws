package com.webservices_with_aws.webservicewithaws.mapper.custom;

import com.webservices_with_aws.webservicewithaws.data.vo.v1.PersonVO;
import com.webservices_with_aws.webservicewithaws.data.vo.v2.PersonVOV2;
import com.webservices_with_aws.webservicewithaws.entities.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 personV2 = new PersonVOV2();
        personV2.setId(person.getId());
        personV2.setFirstName(person.getFirstName());
        personV2.setLastName(person.getLastName());
        personV2.setAddress(person.getAddress());
        personV2.setDate(new Date());
        personV2.setGender(person.getGender());
        return personV2;
    }

    public Person convertVoToEntity(PersonVOV2 personVOV2){
        Person entity = new Person();
        entity.setId(personVOV2.getId());
        entity.setFirstName(personVOV2.getFirstName());
        entity.setLastName(personVOV2.getLastName());
        entity.setAddress(personVOV2.getAddress());
        //person.setDate(new Date());
        entity.setGender(personVOV2.getGender());
        return entity;
    }
}
