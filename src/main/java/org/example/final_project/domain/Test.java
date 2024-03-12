package org.example.final_project.domain;

import org.example.final_project.service.AdvertisementService;
import org.example.final_project.service.CrudService;
import org.example.final_project.service.impl.AdvertisementServiceImpl;
import org.example.final_project.service.impl.AuthorServiceImpl;
import org.example.final_project.service.impl.CategoryServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
           CrudService<Author> authorService = new AuthorServiceImpl();
            CrudService<Category> categoryService = new CategoryServiceImpl();
            AdvertisementService adService = new AdvertisementServiceImpl();

        Category category = Category
                .builder()
                .name("Technology")
                .build();

        categoryService.add(category);

Advertisement advertisement = Advertisement
        .builder()
        .name("Phones")
        .date(LocalDate.of(2022,11,01))
        .cost(BigDecimal.valueOf(120))
        .advertText("Nokia")
        .category(category)
        .build();

adService.add(advertisement);

Address address = Address
        .builder()
        .country("Great Britain")
        .city("London")
        .build();

Email email = Email
        .builder()
        .name("edgar.pau@gmail.com")
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

address.setAuthor(author);
phone.setAuthor(author);
address.setAuthor(author);

authorService.add(author);

advertisement.setAuthor(author);



    }
}
