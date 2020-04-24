package com.kodilla.hibernate.manytomany.repository;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTestSuite {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee ulmKowalsky = new Employee("Ulm", "Kowalsky");
        Employee peterSmith = new Employee("Peter", "Smith");
        Employee elizaNowak = new Employee("Eliza", "Nowak");

        Company obc = new Company("OBC");
        Company joll = new Company("Joll");
        Company enterYou = new Company("EnterYou");

        obc.getEmployees().add(ulmKowalsky);
        joll.getEmployees().add(peterSmith);
        joll.getEmployees().add(elizaNowak);
        enterYou.getEmployees().add(ulmKowalsky);
        enterYou.getEmployees().add(elizaNowak);

        ulmKowalsky.getCompanies().add(obc);
        ulmKowalsky.getCompanies().add(enterYou);
        peterSmith.getCompanies().add(joll);
        elizaNowak.getCompanies().add(joll);
        elizaNowak.getCompanies().add(enterYou);

        //When
        companyRepository.save(obc);
        int softwareMachineId = obc.getId();
        companyRepository.save(joll);
        int dataMaestersID = joll.getId();
        companyRepository.save(enterYou);
        int greyMatterID = enterYou.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersID);
        Assert.assertNotEquals(0, greyMatterID);

        //CleanUp
        try {
            companyRepository.deleteById(softwareMachineId);
            companyRepository.deleteById(dataMaestersID);
            companyRepository.deleteById(greyMatterID);
        } catch (Exception e) {
            //do nothing
        }

    }
}
