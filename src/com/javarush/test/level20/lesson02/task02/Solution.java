package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            for (User user : users) {
                String FirstName = user.getFirstName();
                if(FirstName != null)
                    writer.println(FirstName);
                else
                    writer.println("NA");
                String LastName = user.getLastName();
                if(FirstName != null)
                    writer.println(LastName);
                else
                    writer.println("NA");
                Date BirthDate = user.getBirthDate();
                if(BirthDate != null)
                    writer.println(formatter.format(BirthDate));
                else
                    writer.println("NA");
                writer.println(user.isMale());
                User.Country Country = user.getCountry();
                if(Country != null)
                    writer.println(Country.getDisplayedName());
                else
                    writer.println("NA");
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while(reader.ready())
            {
                User user = new User();
                String FirstName = reader.readLine();
                if(FirstName.equals("NA"))
                    FirstName = null;
                user.setFirstName(FirstName);
                String LastName = reader.readLine();
                if(LastName.equals("NA"))
                    LastName = null;
                user.setLastName(LastName);
                String BirthDate = reader.readLine();
                if(BirthDate.equals("NA"))
                    BirthDate = null;
                user.setBirthDate(new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(BirthDate));
                String isMale = reader.readLine();
                user.setMale(Boolean.valueOf(isMale));
                String Country = reader.readLine();
                if(Country.equals("NA"))
                    user.setCountry(null);
                else if (Country.equals("Russia"))
                    user.setCountry(User.Country.RUSSIA);
                else if (Country.equals("Ukraine"))
                    user.setCountry(User.Country.UKRAINE);
                else
                    user.setCountry(User.Country.OTHER);
                users.add(user);
            }
            reader.close();
        }
    }
}
