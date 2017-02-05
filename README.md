** How to start server:

1. cd tools
2. ./gradlew bootRun

** How to run client:
From another window
1. cd tools
2. ./gradlew client (alternative in IntelliJ IDEA project: run ClientApp from jars/client module)

* What we have:
1. Define clean API via interface with required endpoints and methods
2. Implement interface in server side;
3. Use API in client side the same way as it is defined in interface.