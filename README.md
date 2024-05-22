# Veterinary Management System

This project is a veterinary management system project. The system in question was prepared using Spring Boot. The
parameters and endpoints used in entities are given in the document below.
<hr>

## Used Technologies

* Java SDK 21
* Spring Boot 3.2.5
* PostgreSQL 15
* JPA
* Swagger

<hr>


## Showing Project
[https://drive.google.com/file/d/1y96Gbz9bxQhLcabH2ExYy-lJM2oMRvYQ/view?usp=sharing](https://drive.google.com/file/d/1y96Gbz9bxQhLcabH2ExYy-lJM2oMRvYQ/view?usp=sharing)
## Documentation

### UML Diagram
![UML](https://github.com/atmacasoftware/veterinarianManagementSystem/assets/94282227/0bed6b76-b3c5-45e5-a44c-b7e4fe4009c8)

<hr>
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
| /api/v1/doctors/{id} | DELETED     | Endpoint that deletes items according to ID number |

#### Sample Request for POST

Endpoint : http://localhost:8080/api/v1/doctors/add

Method: POST

body:

```
{
  "name": "Olwen Schust",
  "mail": "oschustw@soundcloud.com",
  "phone": "054166714330",
  "address": "43 Haas Pass",
  "city": "Paris"
}
```

<hr>

### AvailableDate

| Parameter     | Required | Description                                         | Data Type | Max. Number of Characters |
|---------------|----------|-----------------------------------------------------|-----------|---------------------------|
| id            | True     | It is not required during the new creation phase.   | Long      | -                         |
| availableDate | True     | It is date information without time. Ex: 2024-05-20 | LocalDate | -                         |
| doctorId      | True     | DoctorId's should be sent in the body.              | Long      | -                         |

| Endpoint                   | HTTP Method | Description                                          |
|----------------------------|-------------|------------------------------------------------------|
| /v1/available-dates/add    | POST        | Add new available date endpoint                      |
| /v1/available-dates/{id}   | GET         | Endpoint showing available date by ID number         |
| /v1/available-dates        | GET         | Endpoint listing all available date by filing method |
| /v1/available-dates/{id}   | PUT         | Relevant available date update endpoint              |
| /v1/available-dates/{id}   | DELETED     | Endpoint that deletes items according to ID number   |
| /v1/available-dates/filter | GET         | Endpoint query the doctor's available dates between the start and end date entered with the doctor id   |

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

#### Sample Request for GET WITH FILTER

Endpoint : http://localhost:8080/api/v1/available-dates/filter?doctorId=1&startDate=2024-05-20&endDate=2024-05-30'

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
| customerId  | True     | CustomerId's should be sent in the body.              | Long      | -                         |

| Endpoint             | HTTP Method | Description                                        |
|----------------------|-------------|----------------------------------------------------|
| /api/v1/animals/add  | POST        | Add new animal endpoint                            |
| /api/v1/animals/{id} | GET         | Endpoint showing animal by ID number               |
| /api/v1/animals      | GET         | Listing all records                                |
| /api/v1/animals/customer     | GET         | API that lists animals belonging to customers                                |
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

### Vaccine

| Parameter            | Required | Description                                            | Data Type | Max. Number of Characters |
|----------------------|----------|--------------------------------------------------------|-----------|---------------------------|
| id                   | True     | It is not required during the new creation phase.      | Long      | -                         |
| name                 | True     | Vaccine's name and surname should be sent in the body. | String    | 100                       |
| code                 | True     | Vaccine's code should be sent in the body.             | String    | 100                       |
| protectionStartDate  | True     | Vaccine's breed should be sent in the body.             | LocalDate | -                         |
| protectionFinishDate | True     | Vaccine's gender should be sent in the body.            | LocalDate    | -                         |
| animalId             | True     | AnimalId's should be sent in the body.                    | LocalDate    | -                         |

| Endpoint             | HTTP Method | Description                                                                                                  |
|----------------------|-------------|--------------------------------------------------------------------------------------------------------------|
| /api/v1/vaccines/add | POST        | Add new vaccines endpoint                                                                                      |
| /api/v1/vaccines/{id} | GET         | Endpoint showing vaccines by ID number                                                                         |
| /api/v1/vaccines    | GET         | Listing all records                                                                                          |
| /api/v1/vaccines/filter  | GET         | Endpoint showing vaccines with approaching end dates according to vaccine protection start date and end date |
| /api/v1/vaccines/{id}| PUT         | Relevant vaccines update endpoint                                                                              |
| /api/v1/vaccines/{id} | DELETED     | Endpoint that deletes items according to ID number                                                           |

#### Sample Request for POST

Endpoint : http://localhost:8080/api/v1/vaccines/add

Method: POST

body:

```
{
  "name": "Aşı 3",
  "code": "aaa03",
  "protectionStartDate": "2024-06-01",
  "protectionFinishDate": "2024-06-30",
  "animalId": {
    "id": 3
  }
}
```

#### Sample Request for PUT

Endpoint : http://localhost:8080/api/v1/vaccines/{id}

Method: PUT

body:

```
{
  "name": "Aşı 3",
  "code": "aaa03",
  "protectionStartDate": "2024-05-20",
  "protectionFinishDate": "2024-05-30",
  "animalId": {
    "id": 3
  }
}
```

#### Sample Request for GET WITH NO PARAMS

Endpoint : http://localhost:8080/api/v1/vaccines

Method: GET

#### Sample Request for GET WITH PARAMS

Endpoint : http://localhost:8080/api/v1/vaccines?animalID=1

Method: GET

#### Sample Request for GET WITH START DATE BETWEEN END DATE

Endpoint : http://localhost:8080/api/v1/vaccines/filter?startDate=2024-05-10&endDate=2024-05-20'

Method: GET

<hr>

### Appointment

| Parameter       | Required | Description                                       | Data Type     | Max. Number of Characters |
|-----------------|----------|---------------------------------------------------|---------------|---------------------------|
| id              | True     | It is not required during the new creation phase. | Long          | -                         |
| appoinmentDate  | True     | Appointment's should be sent in the body.         | LocalDateTime | -                         |
| appointmentHour | True     | AppointmentHour's should be sent in the body.     | int           | -                         |
| doctorId        | True     | DoctorId's should be sent in the body.            | Long          | -                         |
| customerId      | True     | DoctorId's should be sent in the body.            | Long          | -                         |
| animalId        | True     | AnimalId's should be sent in the body.            | Long          | -                         |

| Endpoint             | HTTP Method | Description                                             |
|----------------------|-------------|---------------------------------------------------------|
| /api/v1/appointments/add | POST        | Add new appointment endpoint                            |
| /api/v1/appointments/{id} | GET         | Endpoint showing appointment by ID number               |
| /api/v1/appointments    | GET         | Listing all records                                     |
| /api/v1/appointments/filter  | GET         | Based on the date range and animal entered by the user. |
| /api/v1/appointments/{id}| PUT         | Relevant appointment update endpoint                    |
| /api/v1/appointments/{id} | DELETED     | Endpoint that deletes items according to ID number      |

#### Sample Request for POST

Endpoint : http://localhost:8080/api/v1/appointments/add

Method: POST

body:

```
{
  "appoinmentDate": "2024-05-21",
  "appoinmentHour": 10,
  "doctorId": {
    "id": 1
  }
}
```

#### Sample Request for PUT

Endpoint : http://localhost:8080/api/v1/vaccines/{id}

Method: PUT

body:

```
{
  "appoinmentDate": "2024-05-25",
  "appoinmentHour": 12,
  "doctorId": {
    "id": 1
  }
}
```


#### Sample Request for GET WITH FILTER

Endpoint : http://localhost:8080/api/v1/appointments/filter?animalId=11&startDate=2024-05-20&endDate=2024-05-30

Method: GET

#### Sample Request for GET WITH START DATE BETWEEN END DATE

Endpoint : http://localhost:8080/api/v1/vaccines/filter?startDate=2024-05-10&endDate=2024-05-20'

Method: GET

<hr>






