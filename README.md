# Offsidegaming
"Gas &amp; Water Usage Monitoring Application"

1. На каркас приложения потратил 5 часов :
-Базовая архитектура 
-Так как нет описания модели и поедения,нет описания нагрузки - то храню все параметры в одной таблице в виде строки и прпринимаю данные все сразу.
-Структура пакетов 
-Добавил логирование
-Добавил логирование SQL запросов в читаемом виде с подстановкой параметров ( через spy)
-Проектирование объектной модели - два класса та как в ТЗ нет точного описания модели и поведенческих сценариев.
-Спроектировал базу Данных (обычно создаю её отдельными скриптами, но для учебного примера оформил через генерацию из кода)
-Прописал все связи, поля , индексы( для быстрой выборки и поиска за O(1), FK ключи
-Так как данная база (HSQLDB) поддерживает SEQUENCE - указал для каждой таблицы отдельный счетчик (для высоких нагрузок)
-Добавил два простых метода get - получение истории и add добавление новых данных с проверкой 
-Добавил базовые проверки на уровне модели ( аннотации и валидации на всех уровнях) 
-Добавил Репозитории и сервисы , описал все сервисы и уровни транзакции .
-Добавил кеширование для запроса истории и сброс кеша при добавлении новых данных.
-Добавил howto как вызвать через curl  на главную страницу
-Реализовал максимально эффективный для такой объектной модели запрос поиска последних введенных данных(через подзапрос и max)
-Для того чтобы избежать гонок - реализовал добавление данных через пессимистическую блокировку(в качестве монитора использую родительскую запись клиента на чтение)
-Добавил проверки на возможность добавления новой записи в историю показаний
-Добавил тесты (тестов мало, обычно добавляю больше на разные виды кейсов и слоев)

Create an application to monitor gas, cold and hot water usage. 
No UI needed, only REST API. 
Two REST API methods should be implemented: one for submitting the current measurements for a given user, 
other for getting the history of previously submitted measurements for a given user. 
User inputs should be validated to reject incomplete or invalid data.

Technical Requirements

1. Use Java 1.8, Spring Framework and Maven.

2. Use other Java libraries as needed.

3. Use HSQLDB for storing data. It is ok NOT to persist data across application launches.

4. Try following all the good principles of writing qualitative and testable code.

5. Fill in missing requirements as you feel suitable.

6. Include a short README file describing how the application works and how to build and run the project.

Focus on the most essential features first. It is fine to leave TODOs in places across the code, 
where a certain feature is missing, but you would have implemented it 
if you had more time. Package the final project into a ZIP archive.
