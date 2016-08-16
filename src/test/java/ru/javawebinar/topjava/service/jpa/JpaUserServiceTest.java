package ru.javawebinar.topjava.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.AbstractJpaUserServiceTest;

import static ru.javawebinar.topjava.Profiles.JPA;

/**
 * Created by Sergey on 12.07.16.
 */


@ActiveProfiles(JPA)
public class JpaUserServiceTest extends AbstractJpaUserServiceTest {
}