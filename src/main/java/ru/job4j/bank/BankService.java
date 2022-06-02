package ru.job4j.bank;

import java.util.*;
import java.util.Optional;

/**
 * Класс описывает работу сервиса по переводу денег
 * @author EUGENE VOLKONSKIY
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение данных пользователей и информации о счетах
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в базу данных нового пользователя,
     * если пользователь уникальный
     * @param user пользователь, который добавляется в базу данных
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет для пользователя
     * если пользователь есть в базе данных и счет уникальный,
     * @param passport паспортные даннные пользователя
     * @param account  информация о новом счете
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод позволяет найти даннные о пользователе по паспорту
     * @param passport паспортные даннные пользователя
     * @return возвращает даннные о пользователе или null,
     * если пользователя нет в базе данных
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет найти данные о счете пользователя по реквизитам
     * @param passport  паспортные даннные пользователя
     * @param requisite реквизиты пользователя
     * @return возвращает данные о счете пользователя
     * или null если счет не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод осуществляет перевод денег с одного счета на другой
     * @param srcPassport   паспортные даннные отправителя
     * @param srcRequisite  реквизиты отправителя
     * @param destPassport  паспортные даннные получателя
     * @param destRequisite реквизиты получателя
     * @param amount        сумма, которую отправитель хочет перевести
     * @return возвращает true, если перевод произведен успешно
     * или false, если реквизиты не найдены или
     * денег на счете отправителя не хватает
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        boolean rsl = false;

        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);

        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
