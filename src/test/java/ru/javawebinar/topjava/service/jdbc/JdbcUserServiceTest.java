package ru.javawebinar.topjava.service.jdbc;

/**
 * Created by Sergey on 12.07.16.
 */

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;

import static ru.javawebinar.topjava.Profiles.JDBC;
@ActiveProfiles(JDBC)
public class JdbcUserServiceTest extends AbstractUserServiceTest {


}