package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод позволяет найти даннные о пользователе по паспорту
     * @param passport паспортные даннные пользователя
     * @return возвращает даннные о пользователе или null,
     * если пользователя нет в базе данных
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет найти данные о счете пользователя по реквизитам
     * @param passport  паспортные даннные пользователя
     * @param requisite реквизиты пользователя
     * @return возвращает данные о счете пользователя
     * или null если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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

        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);

        if (src != null && dest != null && src.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            src.setBalance(src.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
