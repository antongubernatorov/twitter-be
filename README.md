# Twitter Clone - Backend

## Overview

A scalable backend for a Twitter-like social media platform, supporting core features such as:
- User registration, authentication, and profile management
- Tweet creation, replies, and retweets
- Real-time notifications (likes, retweets, mentions)
- Followers/Following system
- Timeline generation (home feed, user feed)
- Search and hashtag functionality
- Designed for high performance, fault tolerance, and horizontal scalability to handle millions of users.

## Technologies Used

- Language: Java 17+ (LTS)
- Framework: Spring Boot 3 (Web, Security, Data)
- PostgreSQL (relational data - users, tweets, follows)
- Redis (sessions, timelines, rate limiting)
- Elasticsearch (tweet/search indexing)
- JWT (OAuth2 optional for future integration)
- OpenAPI (Swagger)
- Apache Kafka (activity feeds, notifications)
- WebSocket (real-time updates)
- Docker + Docker Compose
- Unit Tests: JUnit 5, Mockito
  
Future upgrades:
- File Storage: AWS S3 / MinIO (for media uploads)
- CDN: Cloudflare (caching static assets)
- Service Mesh: Istio (for advanced traffic management)
