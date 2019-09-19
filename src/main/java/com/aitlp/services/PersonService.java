package com.aitlp.services;

import com.aitlp.domain.Person;
import com.aitlp.repositories.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Value("${spring.data.neo4j.uri}")
    private String URI;

    @Value("${spring.data.neo4j.username}")
    private String USERNAME;

    @Value("${spring.data.neo4j.password}")
    private String PASSWORD;

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> findByConditions(Person person) {
        List<Person> resultList = new ArrayList<>();
        StringBuilder paramsBuilder = new StringBuilder();
        if (StringUtils.isNotBlank(person.getName())) {
            paramsBuilder.append(",");
            paramsBuilder.append("name:\"");
            paramsBuilder.append(person.getName());
            paramsBuilder.append("\"");
        }

        if (StringUtils.isNotBlank(person.getIdCard())) {
            paramsBuilder.append(",");
            paramsBuilder.append("idCard:\"");
            paramsBuilder.append(person.getIdCard());
            paramsBuilder.append("\"");
        }
        Driver driver = GraphDatabase.driver(URI, AuthTokens.basic(USERNAME, PASSWORD));//配置驱动
        Session session = driver.session();//建立连接
        System.out.println("MATCH (n:Person {" + paramsBuilder.toString().substring(1) + "}) RETURN n");
        StatementResult result = session.run("MATCH (n:Person {" + paramsBuilder.toString().substring(1) + "}) RETURN n");//获取结果集
        for (Record record : result.list()) {
            Node personNode = record.get("n").asNode();
            Person p = new Person();
            p.setName(personNode.get("name").asString());
            if (personNode.containsKey("idCard")) {
                p.setIdCard(personNode.get("idCard").asString());
            }
            resultList.add(p);
        }
        return resultList;
    }


    /**
     * 新增或修改
     *
     * @param person
     * @return
     */
    public Map save(Person person) {
        Map resultMap = new HashMap();
        String code = "200";
        String msg = "success";
        try {
            Person savedPerson = personRepository.save(person);
            resultMap.put("data", savedPerson);
        } catch (Exception e) {
            code = "500";
            msg = "error";
            e.printStackTrace();
        }
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }


    /**
     * 删除
     *
     * @return
     */
    public Map delete(Person person) {
        Map resultMap = new HashMap();
        String code = "200";
        String msg = "删除成功！";
        try {
            personRepository.delete(person);
        } catch (Exception e) {
            code = "500";
            msg = "删除失败";
            e.printStackTrace();
        }
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }
}
