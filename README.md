# succinct-hello-world

[![Java CI with Maven](https://github.com/jinahya/succinct-hello-world/actions/workflows/maven.yml/badge.svg)](https://github.com/jinahya/succinct-hello-world/actions/workflows/maven.yml)

A fairly succinct `hello world`.

Execute the `main` class.

```commandline
$ mvn --quiet clean compile exec:java
```

Or build and execute the `jar` file.

```commandline
$ mvn --quiet clean package && java -jar target/succinct-hello-world-<version>.jar
```

Boring? See [verbose-hello-world](https://github.com/jinahya/verbose-hello-world).