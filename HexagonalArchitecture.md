# Hexagonal Architecture

Hexagonal Architecture is a software design pattern that centers the application around the **domain layer**, isolating it from external systems such as databases, UI, or messaging platforms.

## Key Concepts

- **Domain Layer**:
  Contains the business logic of the application. It is exposed via **ports** and **adapters**.

- **Ports**:
  Define interfaces that allow actors to communicate with the application. These serve as entry points or exit points, depending on the context.

- **Adapters**:
  Use specific technologies (like REST, messaging, or databases) to interact with the application via ports.

In our project:

- A **REST controller** acts as a **driving adapter**, allowing the client to communicate with the application.

## Architecture Diagram (Textual)

```
    Adapter -> port -> ( application layer (Domain Layer) application layer ) -> port -> Adapter

                  Driving side                    |                Driven Side
    - Driving Adapter , port IN                      - Driven Adapter , port In
```

## Driving Side vs. Driven Side

- **Driving Side**:

  - Driving actors initiate the interaction.
  - Example: A controller taking user input and sending it to a `Port In`.

- **Driven Side**:
  - Driven actors are triggered by the application.
  - Example: A database adapter called by the application via a `Port Out`.

## Project Structure

- **Adapter Layer**:

  - Contains all Spring-related code and infrastructure-related adapters.

- **Application Layer**:

  - Contains services and ports used to communicate within the application.

  - **Ports**:
    - `Port In`: Interfaces exposed to controllers or other driving adapters to initiate use cases.
    - `Port Out`: Interfaces used to communicate with external systems like databases or messaging systems.

- **Domain Layer**:
  - Contains the core business logic.
  - Keeps the domain isolated from the UI and infrastructure layers.

## Advantages

- Clean separation of concerns
- Highly testable and scalable
- Framework-agnostic core logic
- Great for real-time and modular systems

## Disadvantages

- Slightly steeper learning curve
- More boilerplate (interfaces and adapters)
