status = all
name= RollingFileLogConfigDemo

# Log files location
property.basePath = C:/APPS/TestProject-workspace/PracticeBBD/logger

# RollingFileAppender name, pattern, path and rollover policy
appender.rolling.type = RollingFile
appender.rolling.name = fileLogger
appender.rolling.fileName= ${basePath}/app.log
appender.rolling.filePattern= ${basePath}/app_%d{yyyyMMdd}.log.gz
appender.rolling.layout.type = PatternLayout
appender.rolling.layout.pattern = %d{yyyy-MM-dd HH:mm:ss.SSS} %level [%t] [%l] - %msg%n
appender.rolling.policies.type = Policies

# RollingFileAppender rotation policy
appender.rolling.policies.size.type = SizeBasedTriggeringPolicy
appender.rolling.policies.size.size = 10MB
appender.rolling.policies.time.type = TimeBasedTriggeringPolicy
appender.rolling.policies.time.interval = 1
appender.rolling.policies.time.modulate = true
appender.rolling.strategy.type = DefaultRolloverStrategy
appender.rolling.strategy.delete.type = Delete
appender.rolling.strategy.delete.basePath = ${basePath}
appender.rolling.strategy.delete.maxDepth = 10
appender.rolling.strategy.delete.ifLastModified.type = IfLastModified

# Delete all files older than 30 days
appender.rolling.strategy.delete.ifLastModified.age = 30d

# Configure root logger
rootLogger.level = debug
rootLogger.appenderRef.rolling.ref = fileLogger


<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.19.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.19.0</version>
</dependency>

public static Logger log = LogManager.getLogger();