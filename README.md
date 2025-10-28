cat > README.md << 'EOF'
# Mahesh Microservice

A Spring Boot REST API microservice for managing records.

## Features
- ✅ Full CRUD operations
- ✅ Search functionality
- ✅ Exception handling
- ✅ H2 in-memory database
- ✅ JPA/Hibernate integration

## Technologies
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Maven

## Running the Application
```bash
# Build
./mvnw clean install

# Run
./mvnw spring-boot:run
```

## API Endpoints

- `GET /api/mahesh` - Get all records
- `GET /api/mahesh/{id}` - Get record by ID
- `POST /api/mahesh` - Create new record
- `PUT /api/mahesh/{id}` - Update record
- `DELETE /api/mahesh/{id}` - Delete record
- `GET /api/mahesh/search?name=xxx` - Search by name

## H2 Console
Access at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:maheshdb`
- Username: `sa`
- Password: (empty)

## Author
Mahesh Dollu
EOF

# Add and commit README
git add README.md
git commit -m "Add README"
git push
