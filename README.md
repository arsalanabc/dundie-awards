## Employee directory organization

This is an application for managing employees of a company. Employees belong to organizations within the company.

As recognition, employees can receive Dundie Awards.

* A `Dundie Award` is in reference to the TV show [The Office](https://en.wikipedia.org/wiki/The_Dundies) in which the main character hands out awards to his colleagues. For our purposes, it's a generic award.

## Instructions

In preparation for the upcoming call with NinjaOne, `clone` this repo and run it locally. If everything runs successfully, you will see the following page in your browser.

![success](success.png)

Become familiar with the application and it's characteristics. Use your favorite HTTP Client (like [Postman](https://www.postman.com/)) to exercise the endpoints and step through the code to help you get to know the application. 

In the call, we will introduce new code to the application, and you will comment on issues with the endpoint. Please be ready to share your screen in the call with us with the application ready to run. 

**Bonus:** Spot any issues or potential improvements you notice in the application while you're familiarizing yourself and make note of them for our call. We would love to see your input in how to make this application better.

## Running locally

### Dependencies

- Docker
- Gradle
- Makefile extension 

Use Makefile to run the app locally in a container

- To build with gradle `make gradle-build`

Build the container images

- To build with gradle `make dc-build`

Run the app

- To build with gradle `make dc-up`


### Endpoints

- To give an AWARD to an employee with ID
- `/employees/ID/award/AWARD`
  - i.e. `localhost:3000/employees/1/award/BEST_DAD_AWARD`


- See the message queue
- `localhost:3001/messages`


