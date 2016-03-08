# Spray embedded

# Demo
Just run
```
sbt run
```

Open http://localhost:8080/greeting in your browser

You can also try http://localhost:8080/greeting?name=User


# Create Uber JAR
Just run
```
sbt assembly
```

Size of the JAR 36MB

Run your server
```
java -jar target/scala-2.11/spray-example-assembly-0.1.jar
```

# Run test
Just run
```
sbt test
```

# References
This example project was created after the spray template project https://github.com/spray/spray-template/

# Spray documentation
http://spray.io/documentation/1.2.3/

