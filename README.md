# com.ylz.fundamentals


## Build & Run

Add 'com.spotify:docker-maven-plugin' into pom file

    ./mvnw docker:build
    
    docker run -it -p 3000:6000 -e "DB_URL=jdbc:postgresql://172.17.0.1:5432/com.ylz.fundamentals" -e "DB_USERNAME=postgres" -e "DB_PASSWORD=Welcome" com.ylz.fundamentals


## Postgres Setup

    # Create Docker container with Postgres database:
    docker create --name postgresInstance -e POSTGRES_PASSWORD=Welcome -p 5432:5432 postgres:11.5-alpine

    # Start container:
    docker start postgresInstance

    # Stop container:
    docker stop postgresInstance

Connection Info:

    JDBC URL: `jdbc:postgresql://localhost:5432/com.ylz.fundamentals`
    Username: `postgres`
    Password: `Welcome`

Note: This stores the data inside the container - when you delete the container, the data is deleted as well.

Connect to PSQL prompt from docker:
   docker exec -it postgresInstance psql -U postgres

## Application Database Setup

    # Create the Database:
    psql> create database com.ylz.fundamentals;

    # Setup the Tables:
    psql -d com.ylz.fundamentals -f create_tables.sql

    # Install the Data:
    psql -d com.ylz.fundamentals -f insert_data.sql