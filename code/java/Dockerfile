FROM openjdk

ADD code/java/troop /code
ADD code/java/m2_repo.tgz /root/.m2/
COPY sql/install.sql /code/src/main/resources/schema.sql
COPY sql/load.sql /code/src/main/resources/data.sql

WORKDIR code
CMD ["./mvnw", "spring-boot:run"]
