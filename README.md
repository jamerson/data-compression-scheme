# Data Compression Scheme

## Requirements

- Java 8

All dependencies are handled by Maven. The solution contains Maven Wrapper so the system doesn't need to have Maven installed.

## Running Tests

```sh
./mvnw test
```

## Compiling and Packaging

```sh
./mvnw package
```

This command will generate the file `binary-parser-1.0-SNAPSHOT.jar` inside `target` folder.

## Runing from command line

Redirect a binary file to the application:

```sh
cat input.bin | java -cp target/binary-parser-1.0-SNAPSHOT.jar nl.company.challenge.App
```

Use `USE_TRIVIAL_IMPLEMENTATION` environment variable to change the decoding strategy:
```sh
cat input.bin | USE_TRIVIAL_IMPLEMENTATION=1 java -cp target/binary-parser-1.0-SNAPSHOT.jar nl.company.challenge.App
```

