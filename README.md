# Starter for a java code kata

This repository is there to allow you starting a new code kata fast.

Requirements:

* Java (minimally 1.8)
* Maven

## Clone and work on branch

One posibility is to clone the repo and work on a branch. Creating a branch can be done with the following command.

```bash
git checkout -b <name of branch>
```

I would suggest to name the branch something like ```2019_10_11_numberToWordKata```

## Download as zip

Another possibility is to download this project as a zipfile, extract it in a directory with the name of the kata.

Don't forget to init the git repository:

```bash
git init
```

## Tips

### Update java version

If you have a more recent java version installed, you an upgrade the java version.

Change the java version in the [pom.xml](pom.xml)
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <source>9</source>
        <target>9</target>
    </configuration>
</plugin>
```

### Upgrade to JUnit 5

Remove this dependency from [pom.xml](pom.xml)

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

Add these dependencies to [pom.xml](pom.xml)
```xml
<dependencies>
     <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.5.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.hamcrest</groupId>
        <artifactId>hamcrest-library</artifactId>
        <version>2.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Use parameterized tests

First upgrade to JUnit5.

A linkt to the JUnit5 documentation for [Parameterized tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests).

```java
@ParameterizedTest
@EnumSource(value = Color.class)
void passing(Color color) {
    assertThat(isValid(color), equalTo(true));
}

@ParameterizedTest
@CsvSource({
        "Red, Purple",
        "Red, Green",
        "Purple, Green"
}
)
void failing(String color1, String color2) {
    assertThat(Color.valueOf(color1), equalTo(Color.valueOf(color2)));
}

@ParameterizedTest
@MethodSource("generateAllColors")
void name(List<Color> color) {
    assertThat(isValid(color), equalTo(true));
}
```


https://github.com/ivanpaulovich/ddd-tdd-rich-domain-model-dojo-kata





