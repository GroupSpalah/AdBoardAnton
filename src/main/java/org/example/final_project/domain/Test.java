package org.example.final_project.domain;


import org.example.final_project.service.AdvertisementService;
import org.example.final_project.service.CrudService;
import org.example.final_project.service.impl.AdvertisementServiceImpl;
import org.example.final_project.service.impl.AuthorServiceImpl;
import org.example.final_project.service.impl.CategoryServiceImpl;
import org.example.final_project.service.impl.MatchAdServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        AuthorServiceImpl authorService = context.getBean(AuthorServiceImpl.class);
         CategoryServiceImpl categoryService = context.getBean(CategoryServiceImpl.class);
         AdvertisementServiceImpl adService = context.getBean(AdvertisementServiceImpl.class);
         MatchAdServiceImpl matchAdService = context.getBean(MatchAdServiceImpl.class);

        Category technology = Category
                .builder()
                .name("Technology")
                .build();
        categoryService.add(technology);


        Address address = Address
                .builder()
                .country("Great Britain")
                .city("London")
                .build();

        Email email = Email
                .builder()
                .name("ed.pau@gmail.com")
                .build();


        Phone phone = Phone
                .builder()
                .number("+3809755555")
                .build();

        Author author = Author
                .builder()
                .name("Edgar")
                .address(address)
                .phone(phone)
                .email(email)
                .build();


        phone.setAuthor(author);
        address.setAuthor(author);
        email.setAuthor(author);

        authorService.add(author);

        Advertisement advertisement = Advertisement
                .builder()
                .name("Phones")
                .date(LocalDate.of(2022, 11, 1))
                .cost(BigDecimal.valueOf(120))
                .advertText("Nokia")
                .author(author)
                .category(technology)
                .build();

        adService.add(advertisement);


        Category category1 = categoryService.findById(1);
        advertisement.setCategory(category1);
adService.getByCategory(technology);

    }
}
