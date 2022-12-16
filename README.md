# Intervale test task

# Technology stack:
**`Spring Boot (Web, Data JPA, Validation)`**, **`MySQL`**, **`Liquibase`**, **`Swagger`**, **`Docker`**, **`Maven`**. 


## How to build
1. Build project: mvn clean install
2. To run environment: docker compose up

# Endpoints:

|   HTTP Method   | URL                                                     | Description                       |
|:---------------:|---------------------------------------------------------|-----------------------------------|
|      `GET`      | localhost/api/v1/consumers/                             | Get All Entites                   |
|      `GET`      | localhost/api/v1/consumers/{uuid}                       | Get Entity by ID                  |
|     `POST`      | localhost/api/v1/consumers/                             | Create new Entity                 |
|      `PUT`      | localhost/api/v1/consumers/{uuid}/dt_update/{dt_update} | Update Entity by ID and dt_update |
|    `DELETE`     | localhost/api/v1/consumers/{uuid}/dt_update/{dt_update} | Delete Entity by ID and dt_update |

## Get All Entities

*Request:*

`localhost/api/v1/consumers/`

*Response:*
```json
{
    "content": [
        {
            "uuid": "35bee671-c993-49e8-921f-c65327022785",
            "create_date": "2022-12-05T20:02:39.000Z",
            "update_date": 1670270559000,
            "name": "Grisha",
            "surname": "MITSKEVICH",
            "patronymic": "Dmitrievich",
            "email": "aboba.private@gmail.com",
            "role": "ROLE_USER"
        },
        {
            "uuid": "8fb7f8b5-efc9-4e23-ba17-4e1bb1c7e149",
            "create_date": "2022-12-05T20:07:46.000Z",
            "update_date": 1670270866000,
            "name": "Java",
            "surname": "Developer",
            "patronymic": "Senior",
            "email": "senior.java@gmail.com",
            "role": "ROLE_USER"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "page_number": 0,
        "page_size": 10,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "total_pages": 1,
    "total_elements": 2,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "number_of_elements": 2,
    "empty": false
}
```
>200 OK
## Get Meetup by ID

*Request:*

`localhost/api/v1/consumers/35bee671-c993-49e8-921f-c65327022785`

*Response:*
```json
{
    "uuid": "35bee671-c993-49e8-921f-c65327022785",
    "create_date": "2022-12-05T20:02:38.529Z",
    "update_date": 1670270558561,
    "name": "Grisha",
    "surname": "Mitskevich",
    "patronymic": "Dmitrievich",
    "email": "aboba.private@gmail.com",
    "role": "ROLE_USER"
}

```
> 200 OK
## Create new Entity

*Request:*

`localhost/api/v1/consumers`
> 


```json
{
    "name" : "Grisha",
    "surname" : "Mitskevich",
    "patronymic" : "Dmitrievich",
    "email" : "aboba.private@gmail.com",
    "role" : "ROLE_USER"
}
```

*Response:*
```json
{
    "uuid": "35bee671-c993-49e8-921f-c65327022785",
    "create_date": "2022-12-05T20:02:38.529Z",
    "update_date": 1670270558561,
    "name": "Grisha",
    "surname": "Mitskevich",
    "patronymic": "Dmitrievich",
    "email": "aboba.private@gmail.com",
    "role": "ROLE_USER"
}
```
>201 Created
## Update Entity by UUID and dt_update
*Request:*

`localhost/api/v1/consumers/35bee671-c993-49e8-921f-c65327022785/dt_update/1670270559000`

```json
{
    "name": "Grisha",
    "surname": "MITSKEVICH",
    "patronymic": "Dmitrievich",
    "email": "aboba.private@gmail.com",
    "role": "ROLE_USER"
}
```

*Response:*
```json
{
    "uuid": "35bee671-c993-49e8-921f-c65327022785",
    "create_date": "2022-12-05T20:02:39.000Z",
    "update_date": 1670270559000,
    "name": "Grisha",
    "surname": "MITSKEVICH",
    "patronymic": "Dmitrievich",
    "email": "aboba.private@gmail.com",
    "role": "ROLE_USER"
}
```
> 200 OK
## Delete Entity by ID and Version
*Request:*

`localhost/api/v1/consumers/35bee671-c993-49e8-921f-c65327022785/dt_update/1670270559000`

*Response:*

> 200 OK
