FROM openjdk:21
ENV ALLURE_VERSION 2.30.0
RUN microdnf install findutils
RUN curl -o allure-commandline-${ALLURE_VERSION}.tgz -Ls https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/${ALLURE_VERSION}/allure-commandline-${ALLURE_VERSION}.tgz
RUN tar -zxvf allure-commandline-${ALLURE_VERSION}.tgz -C /opt/
RUN ln -s /opt/allure-${ALLURE_VERSION}/bin/allure /usr/bin/allure
RUN rm -rf allure-commandline-${ALLURE_VERSION}.tgz
WORKDIR /app
COPY . .
EXPOSE 9999 9999
CMD ./gradlew clean test; allure serve build/allure-results --port 9999
