<h1 align="center">Сервис для сокращения ссылок</h1>

Над проектом ведется командая некоммерческая разработка, нас 3 человека: бекэндер - я, фронтэндер - ник на гитхабе "shamdzh" и наш тимлид, разработчик с опытом который взял нас под свое крыло, помогает в архитектуре приложения и дает задания и идеи по проекту, ник на гитхабе "nmago".

Проект задеплоен на heroku, в данный момент ведется работа над подключением фронта к бэку.

Ссылка на Open API спецификацию проекта: `https://link-abbreviator.herokuapp.com/swagger-ui.html`

Ссылка на API проекта: `https://link-abbreviator.herokuapp.com/`

## Для чего нужен этот сервис?

Сервис нужен для того, чтобы сокращать пользовательские ссылки и дать пользователю возможность переходить по каким угодно большим ссылкам с помощью нашего сервиса.

## Возможности и реализации

- Сокращение пользовательской ссылки
- Редирект пользователей по сокращенным ссылкам
- Лимит использований ссылки, после чего она сгорает
- Лимит времени существования ссылки, после чего она сгорает
- Автоматическое асинхронное удаление ссылок после определнного времени
- Open API спецификация

## Как использовать наше API

Сделайте POST запрос по адресу `https://link-abbreviator.herokuapp.com/api/v1/abbreviate`, указав в body запроса json такого формата:

{

     "link": "google.com"

}

Вместо google.com, укажите вашу ссылку, которую нужно сократить, вы полчите json ответ с сокращенной ссылкой и другими параметрами, которую вы можете использовать в течении суток не более 5 раз, это сделано чтобы не забивать БД с heroku, поскольку там ограниченное место.

Все выше перечисленное вы можете найти в Open API спецификации, подробно объяснил для тех, кто не встречался с данной технологией.

Проект будет улучшаться и дорабатываться, есть цели на месяцы вперед, цель проекта развивать свои навыки и нарабатывать опыт командной разработки.
