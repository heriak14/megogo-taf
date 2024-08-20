### To execute tests, run the following command in project workspace:
```bash
./gradlew clean test
```
### Then you can generate Allure report using Allure CLI command:
```bash
allure serve build/allure-results
```

### To run tests in docker container, execute:
```bash
docker build -t megogo-taf:<tag> .
docker run -p 9999:9999 megogo-taf:<tag>
```

### Then you can open Allure report using the following link:
### http://localhost:9999/index.html

