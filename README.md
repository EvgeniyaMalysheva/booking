<a href="https://restful-booker.herokuapp.com/apidoc/index.html"> <img src="media/logo.png" width="400" height="200"> 
<h2>Проект по автоматизации тестирования API для тренажера <a href="https://restful-booker.herokuapp.com/apidoc/index.html">api-Booking</a></h2>

## ☑️ Содержание:

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins) и из терминала
- Allure-отчет
- Уведомление в Telegram о результатах прогона тестов

<a id="tools"></a>
## :ballot_box_with_check:Технологии и инструменты:

|         Java                                                                                                      | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | RestAssured                                                                                                     | Selenide                                                                                                         | Allure <br> Report                                                                                                         |  Jenkins                                                                                                        |   Telegram
|:----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="media/java-svgrepo-com.svg" width="50" height="50"  alt="Java"/></a>  | <a href="https://www.jetbrains.com/idea/"><img src="media/intellij-idea-svgrepo-com.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/github-badge-svgrepo-com.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/Gradle.png" width="50" height="50"  alt="Gradle"/></a>| <a href="https://rest-assured.io/"><img src="media/Rest-Assured.png" width="50" height="50"  alt="Rest-Assured"/></a> | <a href="https://selenide.org/"><img src="media/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://github.com/allure-framework"><img src="media/Allure.svg" width="50" height="50"  alt="Allure"/></a> |<a href="https://www.jenkins.io/"><img src="media/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://web.telegram.org/"><img src="media/Telegram.svg" width="50" height="50" alt="Telegram"/></a> |<a href="https://qameta.io/"><img src="images\logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |

<a id="cases"></a>
## :ballot_box_with_check: Реализованные проверки:
Реализованные API-тесты:
- Запрос списка всех бронирований
- Запрос подробной информации по одному бронированию
- Создание нового бронирования
- Удаление  бронирования
- Проверка работоспособности (ping) сервиса

## <img alt="Jenkins" height="25" src="media/Jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C35_Evgenia_Malysheva_booking/)


<p align="center">  
<img src="media/JenkinsBuild.jpg" alt="Jenkins" width="950"/></a>  
</p>


## :ballot_box_with_check: Параметры сборки в Jenkins:

- login
- password
- baseURI (по умолчанию установлен адрес [api-Booking](https://restful-booker.herokuapp.com/apidoc/index.html))


## Команда для запуска из терминала
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

## <img alt="Allure" height="25" src="media/Allure.svg" width="25"/></a>  <a name="Allure"></a>Allure [Report](https://jenkins.autotests.cloud/job/C35_Evgenia_Malysheva_booking/allure/)	</a>


## Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/AllureReport.jpg" width="850">  
</p>  

____
## <img alt="Allure" height="25" src="media/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="media/tgAllert.jpg" width="550">  
</p>

