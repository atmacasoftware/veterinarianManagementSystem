# Veterinary Management System
This project is a veterinary management system project. The system in question was prepared using Spring Boot. The parameters and endpoints used in entities are given in the document below.
<hr>

## Used Technologies
* Java SDK 21
* Spring Boot 3.2.5
* PostgreSQL 15

<hr>

## Documentation

### Doctor
| Parameter | Required | Description | Data Type | Max. Number of Characters |
|-----------|----------|-------------| --------- |---------------------------|
| id        | True     | It is not required during the new creation phase. | int |                           |
| name      | True     | Doctor's name and surname should be sent in the body.  | String | 100                       |
| phone     | True     | Doctor's phone number should be sent in the body.  | String | 11                        |
| mail      | TRUE     | The e-mail address must be sent within the body. The email must be unique. It is not possible to register with the same e-mail.  | String | 255                       |
| address   | TRUE     | The doctor's address information should be sent within the body.  | String | 255                       |
| city      | TRUE     | The city where the doctor is located should be sent within the body.  | String | 255                       |


| Endpoint         | HTTP Method | Description |
|------------------|-------------|-------------|
| /v1/doctors/add  | POST        | Add new doctor endpoint  |
| /v1/doctors/{id} | GET         | Endpoint showing doctor by ID number  |
| /v1/cursor       | GET         | Endpoint listing all doctors by filing method  |
| /v1/doctors      | PUT         | Relevant doctor update endpoint  |
| /v1/doctors/{id} | DELETED     | Endpoint that deletes items according to ID number  |
