# reactive-spring-exercise
The updated version of the exercise of the course "Reactive Spring" by Chris Anatalio

Changes:

* It uses `maven` instead of `gradle`
* It uses Spring version *2.1* instead of version *2.0*
* It uses the *application properties* instead of class `DataConfig`
* Added file `rest-api.http` for example API requests

MongoDB

* Install Docker
* Get image: `docker pull bitnami/mongodb`
* First time run: `docker run -p 27107:27107 --name mongodb bitnami/mongodb:latest`
* Following times run: `docker run -p 27107:27107 bitnami/mongodb:latest`
