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

1. Clone the repository or download the source code.
2. Open the terminal (or command prompt on Windows) and navigate to the project folder.
3. Run the following command to compile the project:

    ```bash
    mvn clean install
    ```

4. After a successful build, run the program with the command:

    ```bash
    mvn exec:java -Dexec.mainClass="com.scraping.App"
    ```

5. The program will download the PDF files found on the page and compress them into a ZIP file.

### Notes

- The URL used for scraping is the ANS page: [https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos](https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos).
- The PDF files will be downloaded to the `downloads/` directory.
- After downloading, all PDFs will be compressed into a ZIP file named `compact_pdf.zip`.

---

### How to Contribute

1. Fork the repository.
2. Create a branch for your feature (`git checkout -b my-feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Adding new feature'`).
5. Push to your branch (`git push origin my-feature`).
6. Create a Pull Request.

---

### License

This project is licensed under the [MIT License](LICENSE).
