package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    @Autowired
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() <= 1) {
            Division division1 = divisionRepository.findById(2L).orElse(null);

            Customer test1 = new Customer();
            test1.setFirstName("Test1");
            test1.setLastName("Coolio");
            test1.setAddress("100 1st St");
            test1.setPostal_code("10010");
            test1.setPhone("(111)111-1111");
            test1.setDivision(division1);


            Customer test2 = new Customer();
            test2.setFirstName("Test2");
            test2.setLastName("Cheerio");
            test2.setAddress("200 2nd St");
            test2.setPostal_code("20020");
            test2.setPhone("(222)222-2222");
            test2.setDivision(division1);

            Customer test3 = new Customer();
            test3.setFirstName("Test3");
            test3.setLastName("Flameo");
            test3.setAddress("300 3rd St");
            test3.setPostal_code("30030");
            test3.setPhone("(333)333-3333");
            test3.setDivision(division1);

            Customer test4 = new Customer();
            test4.setFirstName("Test4");
            test4.setLastName("Oreo");
            test4.setAddress("400 4th St");
            test4.setPostal_code("40040");
            test4.setPhone("(444)444-4444");
            test4.setDivision(division1);

            Customer test5 = new Customer();
            test5.setFirstName("Test5");
            test5.setLastName("Julio");
            test5.setAddress("500 5th St");
            test5.setPostal_code("50050");
            test5.setPhone("(555)555-5555");
            test5.setDivision(division1);

            customerRepository.save(test1);
            customerRepository.save(test2);
            customerRepository.save(test3);
            customerRepository.save(test4);
            customerRepository.save(test5);
        }

    }
}
