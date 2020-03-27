# Laboratory 7-Amazon Gateway-Lambda

This web app calculates the square of a given number.

In this [file](reporte.pdf) you can find the test report.

## Prerequisites

- You must have an account in AWS or AWS Educate

[AWS](https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Faws.amazon.com%2Fmarketplace%2Fmanagement%2Fsignin%3Fstate%3DhashArgs%2523%26isauthcode%3Dtrue&client_id=arn%3Aaws%3Aiam%3A%3A015428540659%3Auser%2Faws-mp-seller-management-portal&forceMobileApp=0)

[AWS Educate](https://www.awseducate.com/signin/SiteLogin)

## Development

### Lambda-API Gateway

1. You need to create a program with java and maven. In this case in this program exists a method that returns the square of a number.

![](https://github.com/nduran06/AREM-AWS-DIST/blob/master/images/spark/1.png)

2. Then you have to create the .jar file, executing: 

```markdown
mvn package
```

My .jar is [hello-handler-1.0-SNAPSHOT.jar](hello-handler-1.0-SNAPSHOT.jar) 

3. Now you have to create a role in AWS, and then create a lambda function.

4. In this lambda function was upload this .jar file with the path of the method, in this case is: 

```markdown
edu.escuelaing.arem.services.MathServices::square
```
Where edu.escuelaing.arem.services.MathServices is the path of the class, and square the method that we want to use.

5. Then you have to create an API-Gateway in AWS and relate it with the previous Lambda function. It will generate a link.

### EC2 

1. It is necessary to create a Spark service with maven and java.

![](https://github.com/nduran06/AREM-AWS-DIST/blob/master/images/spark/2.png)

2. Now create an EC2 instance in aws.

#### Installations in the instance

- Git

```markdown
# yum install git 
```
- Java and Maven

You can go to:

```markdown
[https://www.tecmint.com/install-apache-maven-on-centos-7/](https://www.tecmint.com/install-apache-maven-on-centos-7/) 
```

3. Now clone this repository in that instance:

```markdown
git clone https://github.com/nduran06/AREM-AWS-DIST.git
```
4. Open the directory

```markdown
cd AREM-AWS-DIST
```
5. You have to modify the API-Gateway which is accessed by the server:

![](https://github.com/nduran06/AREM-AWS-DIST/blob/master/images/spark/3.png)

- You have to replace it with the one that was generated previously, in "edu.escuelaing.arem.spark.SparkApp" in the method "getSquareResultPage(Request req, Response res)"

6. Compile the project:

```markdown
mvn package
```
7. Execute it:

```markdown
mvn exec:java
```
or

```markdown
$ mvn exec:java -Dexec.mainClass="edu.escuelaing.arem.spark.SparkApp"
```

8. You can access with EC2 url and the port of the server (in this case is 14789):

```markdown
http://ec2-54-82-225-132.compute-1.amazonaws.com:14789/square
```
- To run it locally, perform the above steps on your machine, and execute:

```markdown
http://localhost:14789/square
```
## Javadoc

To generate javadoc, you can run:

```markdown
$ mvn javadoc:javadoc
$ mvn javadoc:jar
$ mvn javadoc:aggregate
$ mvn javadoc:aggregate-jar
$ mvn javadoc:test-javadoc
$ mvn javadoc:test-jar
$ mvn javadoc:test-aggregate
$ mvn javadoc:test-aggregate-jar
```
You can go to /tarjet/site to see the documentation 

## Authors

```markdown
* Natalia Durán Vivas
```

## License

This project is licensed under the GNU License - see the [LICENSE.md](LICENSE) file for details




