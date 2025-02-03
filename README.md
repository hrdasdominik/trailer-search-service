# 🚀 Trailer Search Service

A Spring Boot service for fetching **movie trailers** using the **YouTube API**.

---

## 📌 Table of Contents

- [Introduction](#-introduction)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Installation](#-installation)
- [Environment Variables](#-environment-variables)
- [API Endpoints](#-api-endpoints)
- [Query Parameters](#-query-parameters)
- [Running the Service](#-running-the-service)
- [Swagger API Docs](#-swagger-api-docs)
- [Troubleshooting](#-troubleshooting)
- [Shutting the Service](#-shutting-down-the-service)

---

## 📖 Introduction

Trailer Search Service is a **Spring Boot REST API** that integrates with **YouTube API v3** to fetch **movie trailers**
based on a search query.  

---

## ✨ Features

✔ Search for movie trailers using YouTube API  
✔ Fetch trailer **title, description, video url, thumbnails, and channel info**  
✔ **Pagination support** (`nextPageToken`, `prevPageToken`)  
✔ **Global exception handling**  
✔ **Docker support** for easy deployment

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Web & WebFlux**
- **Spring Validation**
- **SpringDoc OpenAPI (Swagger)**
- **YouTube Data API v3**
- **SLF4J**
- **Lombok**
- **Docker & Docker Compose**

---

## 📥 Installation

Clone the repository:

```sh
  git clone https://github.com/yourusername/trailer-search-service.git
  cd trailer-search-service
```

---

## 🔐 Environment Variables

### This service requires a YouTube API key. Set up environment variables:

Create a .env file on the **TOP** level of the project:

```ini
  YOUTUBE_API_KEY={your_api_key}
  YOUTUBE_API_URL=https://www.googleapis.com/youtube/v3
```

### Note:
**Make sure** when creating credentials to select **API key!**  

YouTube API key can be acquired by following these steps:  
https://developers.google.com/youtube/v3/getting-started

I've left ***.env.example*** in the **TOP** level of the repository as an example just in case.

---

## 📡 API Endpoints

### Method Endpoint Description:  

**GET** ***/api/trailers/search?title={movieName}&objectsPerPage={10}&pageToken={CAUQAA}*** Search for movie
trailers  

---

## 🔍 Query Parameters

***query*** - Movie title (Required)  
***objectsPerPage*** - Number of results per page (Default: 10, Min: 1, Max: 100)  
***pageToken*** - Token for pagination given by backend response (Optional)

---

## 🚀 Running the Service

### Using Docker Compose

```sh
  docker-compose up --build
```

### Using IntelliJ
You can open up this repository with IntelliJ since I left .idea so configuration for running the project should be
already setup for you.

---

## 📜 Swagger API Docs

Once the service is running, access API documentation at:

```sh
  http://localhost:8080/swagger-ui/index.html
```

---

## 🛠 Troubleshooting

### Issue: YOUTUBE_API_KEY not found:

✅ Ensure .env exists at the **TOP** level of the project and inside includes YOUTUBE_API_KEY={your_api_key}

### Issue: 400 Bad Request from YouTube API

Check if pageToken is valid.  
Ensure the API key has YouTube Data API v3 enabled.  
Verify request format using Swagger.  

---

## 🚀 Shutting down the Service using Docker Compose

Linux/macOS
```sh
  docker stop trailer-search-service && docker-compose down
```

Windows
```sh
  docker stop trailer-search-service; docker-compose down
```