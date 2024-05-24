FROM postgres:latest

LABEL authors="hange"

# Set environment variables for the database
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=movies-api

# Expose the database port (typically 5432)
EXPOSE 5432

# Command to run the database service
CMD ["postgres", "-h", "localhost", "-p", "5432", "-d", "movies-api"]