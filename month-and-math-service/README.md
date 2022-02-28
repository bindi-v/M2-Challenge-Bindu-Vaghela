# Month-And-Math-Service

## Task

* Our challenge is to build a simple REST web service.
* Our project must be built using Spring Boot. Initialize our project using start.spring.io.
* Our REST API must accept and return data in JSON format where appropriate.
* Every endpoint must have at least one MockMVC test. 
* Endpoints that have error conditions must also contain a MockMVC test for each kind of error.
* Our REST API must be documented with Swagger. And Save the .yaml file in the root of our project directory.

## Description

![License](https://img.shields.io/badge/License-MIT-yellow)

```
GIVEN a month-and-math-service simple REST web application
WHEN I go to "/month/{monthNumber}" Get end point
THEN I am presented with a name and number of monthNumber 
WHEN I go to "/randomMonth" Get end point
THEN I am presented with a random month with name and number
WHEN I Post "/add" end point
THEN I have to provide two integer operand, after Post that will give value of two integers with sum and operation Add
WHEN I Post "subtract", "multiply", and "divide" endpoints
THEN as like "/add" end point, that will give value of two integers with their respective operation and answer
WHEN I request for missing operand, or if operands are not both numbers
THEN I am presented with a respective Error message
WHEN I request for Post "/divide" end point with value 0 for operand2
THEN I am presented with Error message that "/ zero" not processable
```


## Table Of Contents

- [Installation](#installation)
- [Usage](#usage)
- [License](#license)
- [Contribution](#contribution)
- [Contact](#contact)
- [Questions](#questions)

## Installation

The following necessary tools or dependencies used in this project.

Java, Spring Boot, Spring Initializer, Spring Web, Spring Data Jpa, Validation I/O, Swagger Open Api, Insomnia

## Usage

The project Run in IntelliJIdea

## License

This project is licensed under

[MIT](https://opensource.org/licenses/MIT)

For more about the license, check the above link.

## Contribution

Trilogy Education and SMU,Texas provide guidance for this project

## Contact

* GitHub : [bindi-v](https://github.com/bindi-v)
* Email : bindi.vaghela@gmail.com

## Questions

If you have any questions, please reach out to my Github.


#### Thank you for visiting my Github!