# Spring boot with google auth

### Как попробовать?

1. Сначала разберемся с гуглом
 
   *  Идем [https://console.developers.google.com](https://console.developers.google.com) 
   * Создаем или выбираем проект.
   * Затем переходим в "Учетные данные"
   * "Создать учетные данные" > "Идентификатор клиента OAuth" > "Веб приложение"
   ![atltag](http://i.piccy.info/i9/dc563ea8ee03c88ed46449c037ad78b2/1514353835/57621/1208226/scr_1.png)
   * Название: любое
   * Разрешенные URI перенаправления: [http://localhost:8080/google/login](http://localhost:8080/google/login) (*смысл этой ссылки в том, что после выдачи разрешений гугл сделает GET запрос
   на этот URL в котом параметром **code** пришлет авторизационный код*)
   ![alttag](http://i.piccy.info/i9/ce3369a1d9e79bad1707742901140d7b/1514354625/55876/1208226/scr_2.png)
   * Нам отсюда понадобятся Идентификатор и секрет клиента.
2. Идентификатор и секрет клиента добавляем в файл ```src/main/resources/application-security.properties```
3. Теперь это можно запустить ```mvn spring-boot:run``` или из IDE
4. Для того что бы обратиться [http://localhost:8080/profile](http://localhost:8080/profile) нужно оправить GET
запрос с заголовком ```Authorization : bearer {ваш access_token}```
![alttag](http://i.piccy.info/i9/5f1400d5f60604827ad6f81162a46585/1514355618/12650/1208226/scr_3.png)
### Как получить google access token?

*Получение токена зависит от клиента. Я буду использовать PostMan. Нам нужно получить authorization_code, и затем обменять его на access_token*
1. В браузере (помоему с недавнего времени гугл блокирует "не браузуры" при таком запросе) введем такую ссылку: 

   ```https://accounts.google.com/o/oauth2/auth?redirect_uri=http://localhost:8080/google/login&response_type=code&client_id={client_id}&scope=https://www.googleapis.com/auth/userinfo.email```
заменив ```{client_id}``` на ваш Идентификатор клиента. Эта ссылка отредиректит вас
на страницу указанную при создании Идентификатора клиента и в параметре code
и будет ваш authorization_code
   ![alttag](http://i.piccy.info/i9/d347e8a0c7d7471fc121ae55fdd28bdd/1514356232/4595/1208226/scr_4.png)
2. Теперь нужно послать POST запрос 
   ![alttag](http://i.piccy.info/i9/476e934f8e7ac7f24290d3fc6efe2788/1514356632/26233/1208226/scr_5.png)
   
   и *обязательно* добавить заголовок ```Content-Type  application/x-www-form-urlencoded```
   
3. В ответе и будет access_token


За основу взята [эта статья](http://blog.arnoldgalovics.com/2017/02/05/google-oauth-with-spring-security-as-separated-resource-server/)
