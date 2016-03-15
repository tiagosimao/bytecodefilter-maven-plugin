# bytecodefilter-maven-plugin
A maven plugin for general purpose .class files

Usage
```pom
...
<plugin>
  <groupId>org.irenical.bit</groupId>
  <artifactId>bitecodefilter-maven-plugin</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <configuration>
      <consumerClass>com.mycompany.MyVeryOwnClassThatImplementsConsumerAndGetsTheClassesFolderAsInput</consumerClass>
    </configuration>
    <dependencies>
      <dependency> <!-- You'll probably need something like this so your consumer exists in the classpath during plugin execution -->
        <groupId>com.mycompany</groupId>
        <artifactId>my-consumer</artifactId>
        <version>some-version</version>
      </dependency>
    </dependencies>
    <executions>
      <execution>
        <phase>compile</phase>
        <goals>
          <goal>instrument</goal>
        </goals>
      </execution>
    </executions>
  </plugin>
...
```
