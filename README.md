# consumers_dem
Consumer_Demo

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

## Get All meetups

*Request:*

`localhost/api/v1/consumers/`

*Response:*
```json
[
  {
    "id": 1,
    "topic": "one",
    "description": "one",
    "organizer": "one",
    "date_time": "2022-11-11T00:00:00",
    "place": "one",
    "version": 0
  },
  {
    "id": 2,
    "topic": "two",
    "description": "two",
    "organizer": "two",
    "date_time": "2022-11-11T00:00:00",
    "place": "two",
    "version": 0
  }
]
```
>200 OK
## Get Meetup by ID

*Request:*

`localhost/api/v1/consumers/d9f20b28-7eca-47e7-b3d1-e3916984e1eb`

*Response:*
```json
{
    "id": d9f20b28-7eca-47e7-b3d1-e3916984e1eb,
    "topic": "one",
    "description": "one",
    "organizer": "one",
    "date_time": "2022-11-11T00:00:00",
    "place": "one",
    "version": 0
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

> 204 No Content 
