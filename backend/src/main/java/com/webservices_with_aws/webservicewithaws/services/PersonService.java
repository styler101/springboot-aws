package com.webservices_with_aws.webservicewithaws.services;

import com.webservices_with_aws.webservicewithaws.data.vo.v1.PersonVO;
import com.webservices_with_aws.webservicewithaws.data.vo.v2.PersonVOV2;
import com.webservices_with_aws.webservicewithaws.entities.Person;
import com.webservices_with_aws.webservicewithaws.exceptions.RessourceNotFoundException;

import com.webservices_with_aws.webservicewithaws.mapper.DozerMapper;
import com.webservices_with_aws.webservicewithaws.mapper.custom.PersonMapper;
import com.webservices_with_aws.webservicewithaws.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO findById(Long id){
        Person entity = repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("No data found for this ID"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Create one Person!");
        var entity =  DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(Long id , PersonVO person){
       logger.info("Create one Person!");
       Person entity = repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("No recors found for this ID"));
       entity.setId(entity.getId());
       entity.setFirstName(person.getFirstName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());
       entity.setLastName(person.getLastName());
       var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
       return vo;
    }

    public void delete(Long id){
       Person entity = repository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Id not found"));
       repository.delete(entity);
    }


    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("Create one Person!");
        var entity =  mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }
}

