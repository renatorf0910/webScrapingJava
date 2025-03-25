# Web Scraping Java - Download and Compression of PDFs

This Java project performs web scraping on a web page, downloads the found PDF files, and compresses them into a single ZIP file.

## Requirements

Before running the project, you will need to have **Java** and **Maven** installed on your system.

### Installing Java and Maven

#### Linux (Ubuntu)
1. Install **Java** (OpenJDK 17):
    ```bash
    sudo apt update
    sudo apt install openjdk-17-jdk
    ```
2. Verify Java installation:
    ```bash
    java -version
    ```

3. Install **Maven**:
    ```bash
    sudo apt install maven
    ```

4. Verify Maven installation:
    ```bash
    mvn -v
    ```

#### macOS
1. Install **Java** using [Homebrew](https://brew.sh/):
    ```bash
    brew install openjdk@17
    ```

2. Install **Maven** using [Homebrew](https://brew.sh/):
    ```bash
    brew install maven
    ```

3. Verify the installation:
    ```bash
    java -version
    mvn -v
    ```

#### Windows
1. Download **JDK** (OpenJDK 17) from the official site: [OpenJDK](https://openjdk.java.net/).
2. Install **Maven**: Download [Maven](https://maven.apache.org/download.cgi) and configure the environment variables `JAVA_HOME` and `MAVEN_HOME`.

### How to Run

1. Run the following command to compile the project:

    ```bash
    mvn clean install
    ```

2. After a successful build, run the program with the command:

    ```bash
    mvn exec:java -Dexec.mainClass="com.scraping.App"
    ```

3. The program will download the PDF files found on the page and compress them into a ZIP file.
