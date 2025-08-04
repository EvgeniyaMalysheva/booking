<a href="https://restful-booker.herokuapp.com/apidoc/index.html"> <img src="media/logo.png" width="250" height="200"> 
<h2>Проект по автоматизации тестирования API для <a href="https://restful-booker.herokuapp.com/apidoc/index.html">api-Booking</a></h2>
Restful Booker API - это тренажёр API, основанный на процессах бронирования отелей. Поддерживает все основные CRUD-операции.

## ☑️ Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins) и из терминала
- Allure отчет
- AllureTestOps дашборд
- Уведомление в Telegram о результатах прогона тестов

<a id="tools"></a>
## :ballot_box_with_check:Технологии и инструменты:

|         Java                                                                                                      | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Rest <br> Assured                                                                                                     | Allure <br> Report                                                                                                         | Allure <br> TestOps                                                                                                         |  Jenkins                                                                                                        |   Telegram
|:----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="media/java-svgrepo-com.svg" width="50" height="50"  alt="Java"/></a>  | <a href="https://www.jetbrains.com/idea/"><img src="media/intellij-idea-svgrepo-com.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/github-badge-svgrepo-com.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/Gradle.png" width="50" height="50"  alt="Gradle"/></a>| <a href="https://rest-assured.io/"><img src="media/Rest-Assured.png" width="50" height="50"  alt="RestAssured"/></a> | <a href="https://github.com/allure-framework"><img src="media/Allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://qameta.io/"><img src="media/AllureTestOps.jpg" width="50" height="50"  alt="AllureTestOps"/></a> |<a href="https://www.jenkins.io/"><img src="media/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://web.telegram.org/"><img src="media/Telegram.svg" width="50" height="50" alt="Telegram"/></a> |

<a id="cases"></a>
## :ballot_box_with_check: Реализованные проверки:
Реализованные API-тесты:
- Запрос списка всех бронирований
- Запрос подробной информации по одному бронированию
- Создание нового бронирования
- Удаление  бронирования
- Проверка работоспособности (ping) сервиса
____
## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C35_Evgenia_Malysheva_booking/)
Jenkins — удобный инструмент для автоматизации сборки, тестирования и развёртывания ПО.

<p align="center">  
<img src="media/JenkinsBuild.jpg" alt="Jenkins" width="950"/></a>  
</p>


### :ballot_box_with_check: Параметры сборки в Jenkins:

- login
- password
- baseURI (по умолчанию установлен адрес [api-Booking](https://restful-booker.herokuapp.com/apidoc/index.html))


### Команда для запуска из терминала
Локальный запуск
```bash
gradle clean test
```
Удаленный запуск через Jenkins:
```bash  
clean
test
"-Dlogin=${LOGIN}"
"-Dpassword=${PASSWORD}"
"-DbaseURI=${BASE_URI}"
```
____
## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure [Report](https://jenkins.autotests.cloud/job/C35_Evgenia_Malysheva_booking/allure/)	</a>
Allure Report - это инструмент для генерации и представления отчетов о результатах автоматизированного тестирования.
Тут можно быстро оценить результаты тестового прогона, посмотреть на шаги теста и пробежаться по приложенным аттачам (скрины, логи, видео и т.п.)

### Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/AllureReport.jpg" width="850">  
</p>  

____
## <img alt="AllureTestOps" height="25" src="media/AllureTestOps.jpg" width="25"/></a>  <a name="AllureTestOps"></a>Allure [TestOps](https://allure.autotests.cloud/project/4853)	</a>
Allure TestOps — это мощный инструмент для управления тестированием, который помогает автоматизировать и оптимизировать процессы тестирования.
Здесь смотрим, контролируем, управляем, все показываем менеджеру и коллегам

### Основная страница отчёта

<p align="center">  
<img title="Allure TestOps Overview Dashboard" src="media/AllureTestOpsDashboard.jpg" width="850">  
</p>  

____
## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
О - оперативность. После окончания тестового прогона сразу получаем нотификацию в Телеграм с результатами

<p align="center">  
<img title="Allure Overview Dashboard" src="media/tgAllert.jpg" width="550">  
</p>

