package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 30.06.16.
 */

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return repository.remove(id) != null;
    }

    @Override
    public User save(User user) {
        Objects.requireNonNull(user);
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        LOG.info("save " + user);
        return user;
    }

    @Override
    public User get(int id) {

        LOG.info("get " + id);
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        List<User> list = new ArrayList<User>(repository.values());
        return list
                .stream()
                .sorted((object1, object2) -> object1.getName().compareTo(object2.getName())).collect(Collectors.toList());

    }

    @Override
    public User getByEmail(String email) {
        Objects.requireNonNull(email);

        LOG.info("getByEmail " + email);

        return repository.values().stream().filter(u -> u.getEmail().equals(u.getEmail())).findFirst().orElse(null);
    }
}
