# Veterinary Management System

This project is a veterinary management system project. The system in question was prepared using Spring Boot. The
parameters and endpoints used in entities are given in the document below.
<hr>

## Used Technologies

* Java SDK 21
* Spring Boot 3.2.5
* PostgreSQL 15

<hr>

## Documentation

### Doctor

| Parameter | Required | Description                                                                                                                     | Data Type | Max. Number of Characters |
|-----------|----------|---------------------------------------------------------------------------------------------------------------------------------|-----------|---------------------------|
| id        | True     | It is not required during the new creation phase.                                                                               | Long      | -                         |
| name      | True     | Doctor's name and surname should be sent in the body.                                                                           | String    | 100                       |
| phone     | True     | Doctor's phone number should be sent in the body.                                                                               | String    | 11                        |
| mail      | True     | The e-mail address must be sent within the body. The email must be unique. It is not possible to register with the same e-mail. | String    | 255                       |
| address   | True     | The doctor's address information should be sent within the body.                                                                | String    | 255                       |
| city      | True     | The city where the doctor is located should be sent within the body.                                                            | String    | 255                       |

| Endpoint             | HTTP Method | Description                                        |
|----------------------|-------------|----------------------------------------------------|
| /api/v1/doctors/add  | POST        | Add new doctor endpoint                            |
| /api/v1/doctors/{id} | GET         | Endpoint showing doctor by ID number               |
| /api/v1/doctors      | GET         | Listing all records                                |
| /api/v1/doctors/{id} | PUT         | Relevant doctor update endpoint                    |
| /v1/doctors/{id}     | DELETED     | Endpoint that deletes items according to ID number |

<hr>

### AvailableDate

| Parameter     | Required | Description                                           | Data Type | Max. Number of Characters |
|---------------|----------|-------------------------------------------------------|-----------|---------------------------|
| id            | True     | It is not required during the new creation phase.     | Long      | -                         |
| availableDate | True     | It is date information without time. Ex: 2024-05-20   | LocalDate | -                         |
| doctor        | True     | Has a Many To One relationship with the doctor entity | Doctor    | -                         |

| Endpoint                 | HTTP Method | Description                                          |
|--------------------------|-------------|------------------------------------------------------|
| /v1/available-dates/add  | POST        | Add new available date endpoint                      |
| /v1/available-dates/{id} | GET         | Endpoint showing available date by ID number         |
| /v1/available-dates      | GET         | Endpoint listing all available date by filing method |
| /v1/available-dates/{id} | PUT         | Relevant available date update endpoint              |
| /v1/available-dates/{id} | DELETED     | Endpoint that deletes items according to ID number   |

#### Sample Request for POST

Endpoint : http://localhost:8080/api/v1/available-dates/add

Method: POST

body:

```
{
    "availableDate":"2024-05-08",
    "doctorId": 1
}
```

#### Sample Request for PUT

Endpoint : http://localhost:8080/api/v1/available-dates/{id}

Method: PUT

body:

```
{
    "id": 1,
    "availableDate": "2024-05-09",
    "doctorId": 1
}
```

<hr>

### Customer

| Parameter | Required | Description                                                                                                                     | Data Type | Max. Number of Characters |
|-----------|----------|---------------------------------------------------------------------------------------------------------------------------------|-----------|---------------------------|
| id        | True     | It is not required during the new creation phase.                                                                               | Long      | -                         |
| name      | True     | Customer's name and surname should be sent in the body.                                                                         | String    | 100                       |
| phone     | True     | Customer's phone number should be sent in the body.                                                                             | String    | 11                        |
| mail      | True     | The e-mail address must be sent within the body. The email must be unique. It is not possible to register with the same e-mail. | String    | 255                       |
| address   | False    | The Customer's address information should be sent within the body.                                                              | String    | 255                       |
| city      | False    | The city where the customer is located should be sent within the body.                                                          | String    | 255                       |

| Endpoint               | HTTP Method | Description                                        |
|------------------------|-------------|----------------------------------------------------|
| /api/v1/customers/add  | POST        | Add new customer endpoint                          |
| /api/v1/customers/{id} | GET         | Endpoint showing customer by ID number             |
| /api/v1/customers      | GET         | Listing all records                                |
| /api/v1/customers/{id} | PUT         | Relevant customer update endpoint                  |
| /api/v1/customers/{id} | DELETED     | Endpoint that deletes items according to ID number |

#### Sample Request for POST

Endpoint : http://localhost:8080/api/v1/customers/add

Method: POST

body:

```
{
  "name": "Ahmet Atmaca",
  "phone": "11111111111",
  "mail": "deneme@deneme.com",
  "address": "deneme mah. deneme sok.",
  "city": "Deneme"
}
```

#### Sample Request for PUT

Endpoint : http://localhost:8080/api/v1/customers/{id}

Method: PUT

body:

```
{
  "name": "Ahmet Atmaca",
  "phone": "22222222222",
  "mail": "atmacaahmet5261@hotmail.com",
  "address": "",
  "city": ""
}
```

<hr>

### Animal

| Parameter   | Required | Description                                           | Data Type | Max. Number of Characters |
|-------------|----------|-------------------------------------------------------|-----------|---------------------------|
| id          | True     | It is not required during the new creation phase.     | Long      | -                         |
| name        | True     | Animal's name and surname should be sent in the body. | String    | 100                       |
| species     | True     | Animal's species should be sent in the body.          | String    | 100                       |
| breed       | True     | Animal's breed should be sent in the body.            | String    | 100                       |
| gender      | True     | Animal's gender should be sent in the body.           | String    | 20                        |
| colour      | True     | Animal's colour should be sent in the body.           | String    | 50                        |
| dateOfBirth | True     | Animal's date of birth should be sent in the body.    | LocalDate | -                         |

| Endpoint             | HTTP Method | Description                                        |
|----------------------|-------------|----------------------------------------------------|
| /api/v1/animals/add  | POST        | Add new animal endpoint                            |
| /api/v1/animals/{id} | GET         | Endpoint showing animal by ID number               |
| /api/v1/animals      | GET         | Listing all records                                |
| /api/v1/animals/{id} | PUT         | Relevant animal update endpoint                    |
| /api/v1/animals/{id} | DELETED     | Endpoint that deletes items according to ID number |

#### Sample Request for POST

Endpoint : http://localhost:8080/api/v1/animals/add

Method: POST

body:

```
{
  "name": "Tarçın",
  "species": "Köpek",
  "breed": "Hayır",
  "gender": "Erkek",
  "colour": "Kahverengi",
  "dateOfBirth": "2022-05-17",
  "customerId": {
    "id": 1
  }
}
```

#### Sample Request for PUT

Endpoint : http://localhost:8080/api/v1/animals/{id}

Method: PUT

body:

```
{
  "name": "Tarçın",
  "species": "Köpek",
  "breed": "Hayır",
  "gender": "Erkek",
  "colour": "Siyah",
  "dateOfBirth": "2022-05-17",
  "customerId": {
    "id": 1
  }
}
```

#### Sample Request for GET WITH NO PARAMS

Endpoint : http://localhost:8080/api/v1/animals/

Method: GET

#### Sample Request for GET WITH PARAMS

Endpoint : http://localhost:8080/api/v1/animals?name=tarçın/

Method: GET

<hr>





