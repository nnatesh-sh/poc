# Cloudinary Scaling BFF for Catalog

## Prerequisites ##

To run this project you need to install **JDK 11** or later.

```
https://www.oracle.com/java/technologies/javase-jdk13-downloads.html
```

## How to prepare environment

### 1. Download and confingure GCLOUD ###

```
https://cloud.google.com/sdk/docs/quickstarts
```

### 2. Setup project ###

```bash
gcloud config set project myproject
```

### 3. Create project in AppEngine ###

```bash
gcloud app create --region us-central
```

## How to build and deploy

Application uses Maven to build. If you're using latest JDK's also update Maven.

```java
./mvnw clean package appengine:deploy
```

## Testing application ##

```bash
gcloud app browse
```