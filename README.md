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

- Run locally:

    - Java 8+ SDK installed
    - Maven installed
    
    Find your local ip by:
        - MacOs/Linux: ifconfig
        - Windows: ipconfig
    
    Inside of the project folder, by command line, run the following command replacing <your_local_ip_address> by you local ip machine address:

    ```bash
    mvn clean test -Dbrowser=chrome -DlocalIpAddress=<your_local_ip_address> -Ppodium
    ```
   
- Run in a docker container:

    ```bash
    docker build -t test-podium . && docker run test-podium
    ```

## Dependencies
- seleniumhq: 3.9.1
- testng: 7.1.0
- lombok: 1.18.12

## Final considerations
Really enjoyed creating this framework. I could put into practice much testing knowledge learn during these years in a real environment released product.

## License
[MIT](https://choosealicense.com/licenses/mit/)