package com.example.projectMara.domain.model;

import com.example.projectMara.repository.CopyDao;
import com.example.projectMara.repository.OrderDao;
import com.example.projectMara.repository.UserDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest

class OrderTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CopyDao copyDao;

    @Test
    public void save_order_and_related_user_and_copy() {
        //given

        User user1 = User.builder().fullName("Adam Mickiewicz")
                .nickName("Wieszczu")
                .phoneNumber("44-44-44-444")
                .password("pantadeusz11")
                .email("adam.miszcz@wp.pl")
                .createdAt(LocalDateTime.now())
                .build();

        Order order1 = Order.builder().createdAt(LocalDateTime.now())
                .price(BigDecimal.valueOf(10))
                .orderStatus(OrderStatus.RETURNED_AND_PAID)
                .build();

        String movieTitle = "Terminator2";
        String movieDirector = "James Cameron";

        Movie movie = Movie.builder().title(movieTitle)
                .movieGenre(MovieGenre.ACTION)
                .movieStatus(MovieStatus.CLASSIC)
                .description("mocny dobry, najlepsza czesc")
                .premiereDate(LocalDate.of(1991,7,1))
                .createdAt(LocalDateTime.now())
                .director(movieDirector)
                .build();

        Copy copy = new Copy();
        copy.setMovie(movie);

        List<Copy> copies = new ArrayList<>();
        copies.add(copy);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);

        order1.setCopiesList(copies);
        order1.setUser(user1);
        user1.setOrderList(orders);
        copy.setOrder(order1);

        Optional<Order> foundMovieOrderOptional = orderDao.findById(1);
        Assertions.assertThat(foundMovieOrderOptional.isEmpty()).isTrue();

        Optional<User> foundUserOptional = userDao.findByNickName("Wieszczu");
        Assertions.assertThat(foundUserOptional.isEmpty()).isTrue();

        Optional<Copy> foundCopyOptional = copyDao.findById(1);
        Assertions.assertThat(foundCopyOptional.isEmpty()).isTrue();

        //when

        orderDao.save(order1);
        //userDao.save(user1);
        order1.getUser().getNickName();
        System.out.println("########" + order1.getUser().getNickName());

        foundMovieOrderOptional = orderDao.findById(1);
        Assertions.assertThat(foundMovieOrderOptional.isPresent()).isTrue();

        foundUserOptional = userDao.findById(1);
        Assertions.assertThat(foundUserOptional.isPresent()).isTrue();

        foundCopyOptional = copyDao.findById(1);
        Assertions.assertThat(foundCopyOptional.isPresent()).isTrue();




        //then
    }

}