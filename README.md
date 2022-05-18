# Дипломный проект по автоматизации тестирования сайта [ЦИАН](http://cian.ru/)
Реализован во время обучения в Школе инженеров по автоматизации тестирования [qa.guru](http://qa.guru/)

## Технологии и инструменты
<p align="left"> 
<a href="https://www.jetbrains.com/idea/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Intelij_IDEA.png" width="40" height="40"/> </a>
<a href="https://www.oracle.com/java/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Java.png" width="40" height="40"/> </a>
<a href="https://gradle.org/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Gradle.png" width="40" height="40"/> </a>
<a href="https://junit.org/junit5/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/JUnit5.png" width="40" height="40"/> </a>
<a href="https://selenide.org/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Selenide.png" width="40" height="40"/> </a>
<a href="https://aerokube.com/selenoid/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Selenoid.png" width="40" height="40"/> </a>
<a href="https://qameta.io/allure-report/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Allure_Report.png" width="40" height="40"/> </a> 
<a href="https://www.jenkins.io/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Jenkins.png" width="40" height="40"/> </a>
<a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/daniilshat/daniilshat/2d7eafe5250314b3d422c86b35de062e0f1f5178/icons/git.svg" alt="git" width="40" height="40"/> </a>
<a href="https://telegram.org/" target="_blank" rel="noreferrer"> <img src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/telegram.png" width="38" height="38"/> </a>

> *В данном проекте автотесты написаны на <code><strong>*Java*</strong></code> с использованием фреймворка <code><strong>*Selenide*</strong></code> для UI-тестов*
>
> *Для сборки проекта используется <code><strong>*Gradle*</strong></code>.*
>
> *<code><strong>*JUnit 5*</strong></code> используется как фреймворк для модульного тестирования.*
>
> *Запуск тестов выполняется из <code><strong>*Jenkins*</strong></code>.*
>
> *<code><strong>*Selenoid*</strong></code> используется для запуска браузеров в контейнерах  <code><strong>*Docker*</strong></code>.*
>
> *<code><strong>*Allure Report, Telegram Bot*</strong></code> используются для визуализации результатов тестирования.*
  
## Реализованы проверки UI

- [x] Авторизация по Email
- [x] Поиск аренды дома
- [x] Добавление в избранное в ЛК
- [x] Добавление в избранное без авторизации
- [x] Изменение города
- [x] Проверка промо ссылки

## Запуск тестов из терминала

*Запуск тестов c параметрами по умолчанию:*

```bash
gradle clean test
```

*Запуск тестов с изменением параметров:*

```bash
gradle clean test 
  -Dbrowser=[BROWSER]
  -DbrowserVersion=[BROWSER_VERSION]
  -DbrowserSize=[BROWSER_SIZE]
  -DremoteDriverUrl=https://[selenoidUser]:[selenoidPwd]@[REMOTE_DRIVER_URL]/wd/hub/
  -DvideoStorage=https://[REMOTE_DRIVER_URL]/video/
  -DbaseUrl=[BASE_URL]
```

где:
>- [x] *Dbrowser - браузер, в котором будут выполняться тесты (по умолчанию chrome)*
>- [x] *DbrowserVersion - версия браузера (по умолчанию 91.0)*
>- [x] *DbrowserSize - размер окна браузера (по умолчанию 1920x1080)*
>- [x] *DremoteDriverUrl - логин, пароль и адрес удаленного сервера, где будут выполняться тесты (по умолчанию https://[selenoidUser]:[selenoidPwd]@selenoid.autotests.cloud/wd/hub/)*
>- [x] *DvideoStorage - хранилище видео выполненных тестов (по умолчанию https://selenoid.autotests.cloud/video/)*
>- [x] *DbaseUrl - основной адрес тестового стенда*
  
## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/011-LeshMesh-GraduationWork-UiTests/)
*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<!-- 
<p align="center">
  <img src=".png" alt="job" width="800">
</p>
-->

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="https://github.com/LeshMesh/LeshMesh/blob/main/icon/Allure_Report.png"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница со сформированным отчетом.*

<!-- 
<p align="center">
  <img src=".png" alt="job" width="1000">
</p>
-->

## Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/011-LeshMesh-GraduationWork-UiTests/)
  
### Список тестов c описанием шагов и визуализацией результатов
  
## Пример запуска теста в Selenoid
> К каждому тесту в отчете прилагается видео.
  
## Уведомления в Telegram
> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.
