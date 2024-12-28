# Simple Blog System

This is a simple blog system built with Spring Boot. It allows users to create, view, and delete blog posts.

## Features

- Create new blog posts
- View all blog posts
- View individual blog posts
- Delete blog posts

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Thymeleaf
- Maven

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:

```sh
git clone https://github.com/yourusername/simple-blog-system.git
cd simple-blog-system

Sure! Below is a ready and complete `README.md` file for your Simple Blog System project.

```markdown
# Simple Blog System

This is a simple blog system built with Spring Boot. It allows users to create, view, and delete blog posts.

## Features

- Create new blog posts
- View all blog posts
- View individual blog posts
- Delete blog posts

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Thymeleaf
- Maven

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:

```sh
git clone https://github.com/yourusername/simple-blog-system.git
cd simple-blog-system
```

2. Build the project using Maven:

```sh
mvn clean install
```

3. Run the application:

```sh
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### Running Tests

To run the unit tests, use the following command:

```sh
mvn test
```

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── anirthec
│   │           └── simpleblog
│   │               ├── SimpleBlogApplication.java
│   │               ├── controller
│   │               │   └── PostController.java
│   │               ├── model
│   │               │   └── Post.java
│   │               ├── repository
│   │               │   └── PostRepository.java
│   │               └── service
│   │                   └── PostService.java
│   └── resources
│       ├── application.properties
│       └── templates
│           ├── index.html
│           ├── post.html
│           └── postForm.html
└── test
    └── java
        └── com
            └── anirthec
                └── simpleblog
                    ├── controller
                    │   └── PostControllerTest.java
                    └── service
                        └── PostServiceTest.java
```

## API Endpoints

- `GET /` - View all blog posts
- `GET /post/{id}` - View a specific blog post
- `GET /post/new` - Form to create a new blog post
- `POST /post` - Save a new blog post
- `GET /post/delete/{id}` - Delete a specific blog post

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [H2 Database](https://www.h2database.com/)

```

This `README.md` file provides an overview of the project, including features, technologies used, installation instructions, project structure, API endpoints, and acknowledgements. Adjust the repository URL and any other details as necessary.