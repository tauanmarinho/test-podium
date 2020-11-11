# test-podium

## Description

- Test Framework in Java/Maven that runs a suite of selenium tests, target https://www.podium.com web page, that ensure the site is functioning normally.

- For this approach, some concepts and open-source testing framework were used to complete.

- Framework created:
    - Validation the main buttons and fields on Login and Enterprise pages
    - Total of methods test: 5 
        - E-mail or mobile field validation test: 4 variations
        - Credential validation test: 2 variations
        - Total of tests: 9
    - Expected result: 100% pass - 0% fail

- Stack tech used:

    - [Zelenium](https://github.com/zalando/zalenium): A flexible and scalable container based Selenium Grid. Where it's possible to make video recording, live preview and a great dashboard;
    - [TestNG](https://testng.org/doc/TestNG): Very well-known and used java framework for testing. Making your testing code more powerful and easier to use;
    - [Circleci](https://circleci.com): An incredible CI/CD tool, automating the process of build on GitHub, checking the build status of a PR merge;
    - [Docker](https://www.docker.com): Container deployment tool, packaging software into standardized units for deployment or in this case of project testing;
    - [Selenium WebDriver](https://www.selenium.dev): Framework for automate browsers in a simple way;
    - [GibHub](https://github.com): This amazing platform to share, code integration, hostage, deployment and so on;
    - [Git](https://git-scm.com): The most used free and open source distributed version control;
    - [Maven](https://maven.apache.org): Software project management tool.
    
## Usage

- Before running:
    
    - Docker installed
    - Run the Zelenium Grid Frame on port 4444:
        ```bash
        docker run --rm -ti --name zalenium -p 4444:4444 -e PULL_SELENIUM_IMAGE=true -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start
        ```
    - Find your local ip by:
            - MacOs/Linux: ifconfig
            - Windows: ipconfig

- Run locally:

    - Java 8+ SDK installed
    - Maven installed
    
    Inside of the project folder, by command line, run the following command replacing <your_local_ip_address> by you local ip machine address and <browser> by chrome or firefox:

    ```bash
    mvn clean test -Dbrowser=<browser> -DlocalIpAddress=<your_local_ip_address> -Ppodium
    ```
   
- Run in a docker container:

    On the Dockerfile, replace <your_local_ip_address> by you local ip machine address and <browser> by chrome or firefox:
     
    ```batch
    RUN ["mvn", "clean", "test", "-Dbrowser=<browser>", "-DlocalIpAddress=<your_local_ip_address>", "-Ppodium"]
    ```   
  
    And then run the following command:

    ```bash
    docker build -t test-podium . && docker run test-podium
    ```

- Results, dashboard and Live Preview:

    - [Grid Console URL](http://localhost:4444/grid/console)
    - [Zalenium Live Preview](http://localhost:4444/grid/admin/live?only_active_sessions=true&refresh=60)
    - [Zalenium Dashboard](http://localhost:4444/dashboard/)
    - [Report - Locally](http://localhost:63342/test-podium/target/surefire-reports/html/index.html)

## Dependencies
- seleniumhq: 3.9.1
- testng: 7.1.0
- lombok: 1.18.12
- reportng: 1.2.2

## Final considerations
I really enjoyed creating this structure. I was able to put into practice a lot of test knowledge learned during those years in a product launched in a real environment. Of course, this project does not fully apply to UI test quality assurance. It is highly recommended applying tests directly on the back-end, checking status code and the entire body returned by the API, with a great speed and greater variation of use cases, complementing the test cases using Selenium.

## License
[MIT](https://choosealicense.com/licenses/mit/)