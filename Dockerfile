FROM adoptopenjdk/openjdk11 AS builder

COPY . /usr/src/sba
WORKDIR /usr/src/sba

RUN ./gradlew build

FROM adoptopenjdk/openjdk11

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS

RUN useradd -ms /bin/bash sba
WORKDIR /home/sba

USER sba

COPY --from=builder /usr/src/sba/build/libs/*.jar app.jar

EXPOSE 8188

ENTRYPOINT ["java","-jar","app.jar"]



