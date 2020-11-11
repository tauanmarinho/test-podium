# test-podium

- Description

Framework in Java for testing the main elements at https://www.podium.com web page.

For this approach, some concepts and open-source testing framework were used to complete.

- Frameworks used:

    - [Zelenium](https://github.com/zalando/zalenium): A flexible and scalable container based Selenium Grid. Where it's possible to make video recording, live preview and a great dashboard;
    - [TestNG](https://testng.org/doc/TestNG): Very well-known and used java framework for testing. Making your testing code more powerful and easier to use;
    - [Circleci](https://circleci.com): An incredible CI/CD tool, automating the process of build on GitHub, checking the build status of a PR merge;
    - [Docker](https://www.docker.com): Container deployment tool, packaging software into standardized units for deployment or in this case of project testing
    - [Selenium WebDriver](https://www.selenium.dev): Framework for automate browsers in a simple way.
    
## Usage

- Locally:

    - Java 8+ SDK installed in your local machine
    - Maven installed
    - Docker installed

Inside of the project folder, by command line:

```bash
mvn clean test -Dbrowser=chrome -DlocalIpAddress=<your_local_ip_address> -Ppodium
```

- Run in a docker container

```bash
docker build -t test-podium . && docker run test-podium
```

## Dependencies
- seleniumhq: 3.9.1
- testng: 7.1.0
- lombok: 1.18.12

## License
[MIT](https://choosealicense.com/licenses/mit/)